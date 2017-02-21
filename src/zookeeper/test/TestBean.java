package zookeeper.test;


import org.apache.commons.lang3.StringUtils;

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

public class TestBean {
    private String test1;

    public String getTest1() {
        return test1;
    }

    public void setTest1(String test1) {
        System.out.println("接收到推送的allBankRouteInfo配置：" + test1);
        if (StringUtils.isNotBlank(test1)) {
            this.test1 = test1;
        }
    }
}
