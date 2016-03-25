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

public class SecondHandle implements Handler {
    private Handler nextHandler;

    @Override
    public void doHandle() {
        System.out.println("第二不要做的事情!");
        if (null != nextHandler) {
            this.nextHandler.doHandle();
        } else return;
    }

    @Override
    public void setNext(Handler next) {
        this.nextHandler = next;
    }
}
