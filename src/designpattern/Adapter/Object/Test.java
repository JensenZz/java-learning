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

public class Test {
    public static void main(String[] args) {
        OriginalClass originalClass=new OriginalClass();
        Targetable targetable=new Adapter(originalClass);
        targetable.method1();
        targetable.method2();
    }
}
