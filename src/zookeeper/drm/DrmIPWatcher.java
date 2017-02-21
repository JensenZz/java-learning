package zookeeper.drm;

import org.apache.curator.framework.api.CuratorWatcher;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import zookeeper.util.IpUtil;
import zookeeper.util.ReflectionUtils;

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

public class DrmIPWatcher implements CuratorWatcher {
    private static Logger logger = LoggerFactory.getLogger("zookeeper-appender");
    private DrmZookeeperClient client;
    private Object drmobj;
    private String param;
    private boolean isroot;

    public DrmIPWatcher(DrmZookeeperClient client, Object drmobj, String param, boolean isroot) {
        this.client = client;
        this.drmobj = drmobj;
        this.param = param;
        this.isroot = isroot;
    }

    public void process(WatchedEvent event) throws Exception {
        logger.info(event.toString());
        if (event.getState() != Watcher.Event.KeeperState.Disconnected && event.getState() != Watcher.Event.KeeperState.Expired) {
            if (this.client != null) {
                if (event.getType() == Watcher.Event.EventType.NodeDataChanged) {
                    try {
                        String path = event.getPath();
                        String value = this.client.getCuratorClient().readPath(path);
                        if (this.isroot) {
                            String ip = IpUtil.getRealIp();
                            String ippath = path + "/" + ip;
                            this.client.getCuratorClient().writePath(ippath, value);
                        } else {
                            ReflectionUtils.writeField(this.param, this.drmobj, value);
                        }

                        logger.info(this.client.getCuratorClient().readPath(path));
                    } finally {
                        this.client.getCuratorClient().watcherPath(event.getPath(), this);
                    }
                }

            }
        }
    }
}
