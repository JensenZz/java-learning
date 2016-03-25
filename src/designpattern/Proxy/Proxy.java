package designpattern.Proxy;

/**
 * <p>Title: 类的名称</p>
 * <p>Description: 类的实现描述<p>
 * <p>Copyright: Copyright (c) 2016</p>
 * <p>Company:人人行科技 </p>
 *
 * @author JensenZz
 * @version 1.0
 * @date 16/3/25
 */

public class Proxy implements SourceInter {

    private Source source;

    public Proxy() {
        this.source = new Source();
    }

    @Override
    public void doSomeThing() {
        before();
        source.doSomeThing();
        after();
    }

    private void before() {
        System.out.println("使用代理之后前操作");
    }

    private void after() {
        System.out.println("使用代理之后后操作");
    }
}
