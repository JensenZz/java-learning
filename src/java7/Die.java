package java7;

import java.util.Random;

/**
 * <p>Title: 类的名称</p>
 * <p>Description: 类的实现描述<p>
 * <p>Copyright: Copyright (c) 2016</p>
 * <p>Company:人人行科技 </p>
 *
 * @author JensenZz
 * @version 1.0
 * @date 16/6/28
 */

public class Die {
    private int sideUp;

    public Die(int sideUp) {
        this.sideUp = sideUp;
    }

    public void roll() {
        //产生1~6的随机数
        this.sideUp = new Random().nextInt(6) % (6) + 1;
    }

    public int getSideUp() {
        return sideUp;
    }
}
