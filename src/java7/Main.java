package java7;

import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Main {

    //main  run方法

    //    public static void main(String[] args) {
////        String url = "";
////        Pattern f = Pattern.compile("href=\"([^\"]*)\"");
////        Matcher m = f.matcher(url);
////        while (m.find()) {
////            System.out.println(m.group(0));
////        }
//        for (int i = 0; i < 10; i++) {
//
////            long a = 0;
//           long a = (long) (Math.random() * 100000l);
//            System.out.println(a);
//        }
////        System.out.println((long)(Math.random()*1000000l));
//
//    }
    public static int aVoid() {
        return 1;
    }

    static Set<Long> dups = new HashSet<Long>();

    public static void main(String[] args) {
        File file = new File("/Users/JensenZz/Desktop/民族代码.xlsx");
        ArrayList<ArrayList<Object>> result = ExcelUtil.readExcel(file);
        for (int i = 0; i < result.size(); i++) {
            for (int j = 0; j < result.get(i).size(); j++) {
                System.out.println(i + "行" + j + "列" + result.get(i).get(j).toString());

            }
        }
        for (int i = 0; i < result.size(); i++) {
            System.out.println("insert into general_config values(null,'PGW','nationality','" + result.get(i).get(0).toString() + "','" + result.get(i).get(1).toString().trim()+"','1','民族列表',now(),now());");
        }

    }

}
