package zookeeper.test;

import zookeeper.drm.DrmAppNode;
import zookeeper.drm.DrmZookeeperClient;

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

public class DrmTest {

    public static void main(String[] args) {
        DrmZookeeperClient drmZookeeperClient = new DrmZookeeperClient();
        drmZookeeperClient.setAppName("zhazha");
        drmZookeeperClient.setTimeout(10000);
        drmZookeeperClient.setZkAddress("127.0.0.1:2181");
        try {
            drmZookeeperClient.init();
        } catch (Exception e) {
            e.printStackTrace();
        }
        TestBean testBean = new TestBean();
        DrmAppNode appDrmNode = new DrmAppNode(testBean, "test1", "true");
            drmZookeeperClient.confRegist(appDrmNode, true);
    }
}
