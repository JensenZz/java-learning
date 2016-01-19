import myTest.MyTest;

/**
 * Created by JensenZz on 16/1/13.
 * Project name is mywork
 * O(∩_∩)O ^_^
 */
public class SynchronizedMain {

	public static void main(String[] args) {
		try {
			//  synchronized  锁研究  线程相关
			MyTest myTest=new MyTest();
			new Thread(myTest.new Inner(0), "A").start();
			new Thread(myTest.new Inner(1), "B").start();
			new Thread(myTest.new Inner(2), "C").start();
			//test  commit
		} catch (Exception e) {
			e.printStackTrace();

		}
	}
}
