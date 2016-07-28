package java7;

import java.util.HashMap;
import java.util.Map;

import myTest.MyTest;

/**
 * Created by JensenZz on 16/1/13.
 * Project name is mywork
 * O(∩_∩)O ^_^
 */
public class ClassLoaderMain {

	public static void main(String[] args) {
		try {
			//研究类加载机制  其中的过程就是类加载过程：
			//1、寻找jre目录，寻找jvm.dll，并初始化JVM；
			//2、产生一个Bootstrap Loader（启动类加载器）；
			//3、Bootstrap Loader自动加载Extended Loader（标准扩展类加载器），并将其父Loader设为Bootstrap Loader。
			//4、Bootstrap Loader自动加载AppClass Loader（系统类加载器），并将其父Loader设为Extended Loader。
			//5、最后由AppClass Loader加载HelloWorld类

			for (Map.Entry<Object, Object> entry : System.getProperties().entrySet()) {
				System.out.println(entry.getKey() + "        [    " + entry.getValue() + "    ]");
			}
			ClassLoader loader = MyTest.class.getClassLoader();
			System.out.println(loader);
			System.out.println(loader.getParent());
			System.out.println(loader.getParent().getParent());
			//使用ClassLoader.loadClass()来加载类，不会执行初始化块
			loader.loadClass("Inner2");
			//使用Class.forName()来加载类，默认会执行初始化块
			Class.forName("myTest.MyServerTest");
			//使用Class.forName()来加载类，并指定ClassLoader，初始化时不执行静态块
			Class.forName("Inner2", false, loader);

		} catch (Exception e) {
			e.printStackTrace();
		}


	}
}
