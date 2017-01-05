package java7;

import java.util.*;

/**
 * <p>Title: 类的名称</p>
 * <p>Description: 类的实现描述<p>
 * <p>Copyright: Copyright (c) 2016</p>
 * <p>Company:人人行科技 </p>
 *
 * @author JensenZz
 * @version 1.0
 * @date 16/8/23
 */

public class ComparatorTest {

    private Date aa;

    public static void main(String[] args) {

//        List<ComparatorTest> comparatorTests = new ArrayList<>();
//        Collections.sort(comparatorTests, new Comparator<ComparatorTest>() {
//            @Override
//            public int compare(ComparatorTest o1, ComparatorTest o2) {
//                return 0;
//            }
//        });
        Date bb =new Date(1);
        Date aa=new Date();
        System.out.println(aa.compareTo(bb));
    }
}
