package java7;

/**
 * <p>Title: 类的名称</p>
 * <p>Description: 类的实现描述<p>
 * <p>Copyright: Copyright (c) 2016</p>
 * <p>Company:人人行科技 </p>
 *
 * @author JensenZz
 * @version 1.0
 * @date 2016/12/7
 */

public class Test {
    public static void main(String[] args) {
        int arg[] = new int[]{3, 5, 1, 2, 8, 2, 7, 0};
//        asdasd
        Test a = new Test();
        System.out.println("排序前样子");
        for (int i : arg) {
            System.out.print(i + ",");
        }
        System.out.println("");
        a.testA(arg);
//devdddd
        System.out.println("排序后");
        for (int i : arg) {
            System.out.print(i + ",");
        }
    }


    public void testA(int array[]) {
        for (int i = 0; i < array.length; i++) {
            for (int j = i+1; j < array.length; j++) {
                if (array[i] < array[j]) {
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
    }

}
