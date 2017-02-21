package zookeeper.zk;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.api.ACLBackgroundPathAndBytesable;
import org.apache.curator.framework.api.BackgroundPathAndBytesable;
import org.apache.curator.framework.api.BackgroundPathable;
import org.apache.curator.framework.api.CuratorWatcher;
import org.apache.curator.framework.state.ConnectionStateListener;
import org.apache.curator.retry.RetryNTimes;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.data.Stat;

import java.nio.charset.Charset;
import java.util.List;

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

public class CuratorClient {

    private String zkAddress;
    private String namespace;
    private CuratorFramework curator;

    public CuratorClient() {
    }

    public void init(String namespace, String address, int timeout, ConnectionStateListener stateListener) throws Exception {
        this.namespace = namespace;
        this.zkAddress = address;
        this.curator = CuratorFrameworkFactory.builder().connectString(this.zkAddress).namespace(this.namespace).retryPolicy(new RetryNTimes(5, 1000)).connectionTimeoutMs(timeout).build();
        this.curator.getConnectionStateListenable().addListener(stateListener);
        this.curator.start();
    }

    public void removeListener(ConnectionStateListener stateListener) {
        this.curator.getConnectionStateListenable().removeListener(stateListener);
    }

    public void close() throws Exception {
        try {
            this.curator.close();
            this.curator = null;
        } catch (Exception var2) {
            throw var2;
        }
    }

    public Stat getStat(String path) throws Exception {
        return (Stat) this.curator.checkExists().forPath(path);
    }

    public boolean isPathExist(String path) throws Exception {
        Stat serverStat = this.getStat(path);
        return serverStat != null;
    }

    public void createPath(String path, CreateMode mode) throws Exception {
        this.createPath(path, mode, "");
    }

    public void createPath(String path, CreateMode mode, String value) throws Exception {
        ((BackgroundPathAndBytesable) ((ACLBackgroundPathAndBytesable) this.curator.create().creatingParentsIfNeeded().withMode(mode)).withACL(ZooDefs.Ids.OPEN_ACL_UNSAFE)).forPath(path, value.getBytes(Charset.forName("utf-8")));
    }

    public void deletePath(String path) throws Exception {
        this.curator.delete().forPath(path);
    }

    public void writePath(String path, String value) throws Exception {
        this.curator.setData().forPath(path, value.getBytes(Charset.forName("utf-8")));
    }

    public String readPath(String path) throws Exception {
        byte[] buffer = (byte[]) this.curator.getData().forPath(path);
        return new String(buffer);
    }

    public String watcherPath(String path, CuratorWatcher watcher) throws Exception {
        byte[] buffer = (byte[]) ((BackgroundPathable) this.curator.getData().usingWatcher(watcher)).forPath(path);
        return new String(buffer);
    }

    public List<String> getChildren(String path) throws Exception {
        return (List) this.curator.getChildren().forPath(path);
    }

    public CuratorFramework getCurator() {
        return this.curator;
    }
}
