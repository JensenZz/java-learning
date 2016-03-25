package designpattern.ChainWithFactory;

/**
 * <p>Title: 类的名称</p>
 * <p>Description: 类的实现描述<p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: </p>
 *
 * @author JensenZz
 * @version 1.0
 * @date 16/3/25
 */

public interface Handler {

    public void doHandle();

    public void setNext(Handler next);

}
