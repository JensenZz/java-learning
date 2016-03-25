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

public class Test {
    public static void main(String[] args) {
        ChainsFactory chainsFactory=new ChainsFactory();
        HandleService handleService=chainsFactory.produce(1);
        handleService.doSomeThing();
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        handleService=chainsFactory.produce(2);
        handleService.doSomeThing();
    }
}
