package java7;

/**
 * <p>Title: 类的名称</p>
 * <p>Description: 类的实现描述<p>
 * <p>Copyright: Copyright (c) 2017</p>
 * <p>Company:人人行科技 </p>
 *
 * @author JensenZz
 * @version 1.0
 * @date 2017/3/3
 */

public class Singleton2 {
    private static volatile Singleton2 INSTANCE;

    public Singleton2() {
    }

    public static Singleton2 getINSTANCE() {
        if (INSTANCE == null) {
            synchronized (Singleton2.class) {
                if (INSTANCE == null) {
                    INSTANCE=new Singleton2();
                }
            }
        }
        return INSTANCE;
    }
}
