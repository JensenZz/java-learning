package zookeeper.drm;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.state.ConnectionState;
import org.apache.curator.framework.state.ConnectionStateListener;
import org.apache.zookeeper.CreateMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import zookeeper.util.IpUtil;
import zookeeper.util.ReflectionUtils;
import zookeeper.zk.CuratorClient;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.CountDownLatch;

/**
 * <p>Title: 类的名称</p>
 * <p>Description: 类的实现描述<p>
 * <p>Copyright: Copyright (c) 2017</p>
 * <p>Company:人人行科技 </p>
 *
 * @author JensenZz
 * @version 1.0
 * @date 2017/2/17
 */

public class DrmZookeeperClient {
    private static Logger logger = LoggerFactory.getLogger("zookeeper-appender");
    private CuratorClient curatorClient;
    private static final String namespace = "DRM";
    private String ip;
    private String zkAddress;
    private int timeout = 10000;
    private String appName;
    private ConnectionStateListener listener;
    private Set<DrmAppNode> confSet = new CopyOnWriteArraySet();
    private CountDownLatch latch = null;

    public DrmZookeeperClient() {
    }

    public void init() throws Exception {
        this.ip = IpUtil.getRealIp();
        this.latch = new CountDownLatch(1);
        this.listener = new DrmZookeeperClient.StateEventListener();
        this.curatorClient = new CuratorClient();
        this.curatorClient.init("DRM", this.zkAddress, this.timeout, this.listener);
        this.latch.await();

        try {
            if (!this.curatorClient.isPathExist(this.appName)) {
                this.curatorClient.createPath(this.appName, CreateMode.PERSISTENT);
                this.curatorClient.writePath(this.appName, "");
            }
        } catch (Exception var2) {
            ;
        }

    }

    public boolean confRegist(DrmAppNode drmNode) {
        return this.confRegist(drmNode, true);
    }

    public boolean confRegist(DrmAppNode drmNode, boolean addset) {
        String path = this.appName + "/" + drmNode.getClassname() + "." + drmNode.getParmname();
        String ippath = path + "/" + this.ip;
        if (addset && this.confSet.contains(drmNode)) {
            logger.error("重复注册节点{}", drmNode);
            return false;
        } else {
            try {
                if (!this.curatorClient.isPathExist(path)) {
                    this.curatorClient.createPath(path, CreateMode.PERSISTENT);
                    this.curatorClient.writePath(path, drmNode.getValue());
                } else {
                    String ex = this.curatorClient.readPath(path);
                    if (!ex.equals(drmNode.getValue())) {
                        ReflectionUtils.writeField(drmNode.getParmname(), drmNode.getObj(), ex);
                        drmNode.setValue(ex);
                    }
                }

                this.curatorClient.watcherPath(path, new DrmIPWatcher(this, drmNode.getObj(), drmNode.getParmname(), true));
                if (this.curatorClient.isPathExist(ippath)) {
                    this.curatorClient.deletePath(ippath);
                }

                this.curatorClient.createPath(ippath, CreateMode.EPHEMERAL);
                this.curatorClient.writePath(ippath, drmNode.getValue());
                this.curatorClient.watcherPath(ippath, new DrmIPWatcher(this, drmNode.getObj(), drmNode.getParmname(), false));
                if (addset) {
                    this.confSet.add(drmNode);
                }

                return true;
            } catch (Exception var6) {
                logger.error("注册drm异常", var6);
                return false;
            }
        }
    }

    private void reinit() {
        try {
            this.unregister();
            this.init();
            Iterator e = this.confSet.iterator();

            while (e.hasNext()) {
                DrmAppNode conf = (DrmAppNode) e.next();
                this.confRegist(conf, false);
            }
        } catch (Exception var3) {
            logger.error("重新初始化异常！", var3);
        }

    }

    private void unregister() throws Exception {
        try {
            this.curatorClient.removeListener(this.listener);
            this.listener = null;
            this.curatorClient.close();
            this.curatorClient = null;
        } catch (Exception var2) {
            logger.warn("unregister failed");
            throw var2;
        }
    }

    public void setZkAddress(String zkAddress) {
        this.zkAddress = zkAddress;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public void setTimeout(int timeout) {
        this.timeout = timeout;
    }

    public CuratorClient getCuratorClient() {
        return this.curatorClient;
    }

    final class StateEventListener implements ConnectionStateListener {
        StateEventListener() {
        }

        public void stateChanged(CuratorFramework curator, ConnectionState state) {
            if (state == ConnectionState.CONNECTED) {
                DrmZookeeperClient.logger.info(" connection established");
                DrmZookeeperClient.this.latch.countDown();
            } else if (state == ConnectionState.LOST) {
                DrmZookeeperClient.logger.info(" connection lost, waiting for reconnect");

                try {
                    DrmZookeeperClient.logger.info(" re-initing");
                    DrmZookeeperClient.this.reinit();
                    DrmZookeeperClient.logger.info(" re-inited");
                } catch (Exception var4) {
                    DrmZookeeperClient.logger.error("re-inited%s", var4);
                }
            }

        }
    }
}
