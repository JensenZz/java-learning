package designpattern.Adapter.Object;

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

public class Adapter implements Targetable {

    private OriginalClass originalClass;

    public Adapter(OriginalClass originalClass) {
        this.originalClass = originalClass;
    }

    @Override
    public void method1() {
        originalClass.method1();
    }

    @Override
    public void method2() {
        System.out.println("新适配对象的方法");
    }
}
