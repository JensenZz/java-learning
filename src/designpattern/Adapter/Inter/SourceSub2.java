package designpattern.Adapter.Inter;

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

public class SourceSub2 extends Wrapper1 {
    public void method2() {
        System.out.println("我只实现了方法2哦 ,适配器蛮好用的呢");
    }
}
