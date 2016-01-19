import myTest.MyServerTest;

/**
 * Created by JensenZz on 16/1/13.
 * Project name is mywork
 * O(∩_∩)O ^_^
 */
public class ServerMain {

	public static void main(String[] args) {
		try {
			//自己写一个简单服务器 研究
			MyServerTest myServerTest = new MyServerTest();
			myServerTest.openServer();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
