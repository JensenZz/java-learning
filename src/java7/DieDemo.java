package java7;

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

public class DieDemo {
    int data[] = {1, 8, 3, 5, 4, 6, 10, 9, 2, 7};

    int indexOf(int x) {
        for (int i = 0; i < data.length; i++) {
            if (data[i] == x) {
                return i;
            }
        }
        return -1;
    }

}
