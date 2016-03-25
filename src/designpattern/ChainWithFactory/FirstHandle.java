package designpattern.ChainWithFactory;

/**
 * <p>Title: 类的名称</p>
 * <p>Description: 类的实现描述<p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company:XXXXXX </p>
 *
 * @author JensenZz
 * @version 1.0
 * @date 16/3/25
 */

public class FirstHandle implements Handler {
    private Handler nextHandler;

    @Override
    public void doHandle() {
        System.out.println("完成第一步要做的事");

        if (null != nextHandler) {
            this.nextHandler.doHandle();
        } else return;
    }

    //这里如果使用spring直接注入进来就好了
    @Override
    public void setNext(Handler next) {
        this.nextHandler = next;
    }
}
