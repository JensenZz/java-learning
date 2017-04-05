package java7;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {

    public static Set<String> UrlDistinct(List<String> strings) {
        Set<String> UrlSet = new HashSet<String>();
        for (String string : strings) {
            if (null != string && !string.isEmpty()) {
                if (!string.contains("?")) {
                    UrlSet.add(string);
                } else {
                    String[] s = string.split("\\?");
                    if (null != s && null != s[0]) {
                        UrlSet.add(s[0]);
                    }
                }
            }
        }
        return UrlSet;
    }

    public static void main(String[] args) {
        List<String> strings = new ArrayList<String>();
        String url1 = "";
        String url2 = "https://www.baidu.com";
        String url3 = "https://item.taobao.com/item.htm?spm=a21bo.50862.201867-rmds-1.1.xQVq98&scm=1007.12807.73594.100200300000004&id=44912154257&pvid=0fb65e13-e110-4bb1-a667-dc234d2cf746";
        String url4 = "https://mensway.taobao.com/shop/view_shop.htm?mytmenu=mdianpu&user_number_id=63118522&ali_trackid=17_3ab1209443378f1c7327af6b3077c137&spm=a21bo.50862.201861.1.xQVq98";
        String url5 = "https://daigou.taobao.com/item.htm?spm=5418.7905509.2.1.84Riyc&id=437542";
        String url6 = "https://item.taobao.com/item.htm?id=44912154257&pvid=0fb65e13-e110-4bb1-a667-dc234d2cf746";
        strings.add(url1);
        strings.add(url2);
        strings.add(url3);
        strings.add(url4);
        strings.add(url5);
        strings.add(url6);
        Set<String> stringSet = UrlDistinct(strings);
        for (String s : stringSet) {
            System.out.println(s);
        }
//        ByteBuffer
    }

}
