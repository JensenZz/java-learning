package demo;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>Title: 类的名称</p>
 * <p>Description: 类的实现描述<p>
 * <p>Copyright: Copyright (c) 2017</p>
 * <p>Company:人人行科技 </p>
 *
 * @author JensenZz
 * @version 1.0
 * @date 2017/4/5
 */

public class Demo {
    public static void main(String[] args) {
        try {
            FileWriter writer = new FileWriter("/Users/JensenZz/Desktop/demo.txt", true);
            for (int i = 1; i <= 1000; i++) {
                if (i % 5 == 0) {
                    writer.write(i + "\n");
                }
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        List<String> strings = new ArrayList<String>();
        File file = new File("/Users/JensenZz/Desktop/demo.txt");
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(file));
            String tempString = null;
            // 一次读入一行，直到读入null为文件结束
            while ((tempString = reader.readLine()) != null) {
                // 显示行号
                if (null != tempString && !tempString.isEmpty()) {
                    strings.add(tempString);
                }
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                }
            }
        }
        for (String string : strings) {
            System.out.println(string);
        }
        System.out.println(strings.size());

    }

}
