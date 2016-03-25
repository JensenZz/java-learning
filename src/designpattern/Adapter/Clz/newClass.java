package designpattern.Adapter.Clz;

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

public class newClass extends OriginalClass implements Targetable {
    @Override
    public void method2() {
        System.out.println("这个是新适配之后的样子");
    }
}
