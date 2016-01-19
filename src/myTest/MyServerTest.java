package myTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import myTest.MyServlet.MyServlet;
import myTest.Request.MyRequest;
import myTest.Response.MyResponse;

/**
 * Created by JensenZz on 16/1/7.
 * Project name is sbkj-b2b-mall
 * O(∩_∩)O ^_^
 */
public class MyServerTest extends Thread {

	//这个是服务端的套接字
	private ServerSocket server;

	public MyServerTest() {

	}

	public MyServerTest(ServerSocket serverSocket) {
		this.server = serverSocket;
	}

	//启动服务器
	public void openServer() throws Exception {
		System.out.println("服务器启动啦~~~~~~~~~~O(∩_∩)O哈哈哈~");
		//起一个线程来接受客户端请求
		MyServerTest myServerTest=new MyServerTest(new ServerSocket(Integer.parseInt(MyTest.getValue("myserver.port"))));
		myServerTest.setName("我是服务器9527");
		myServerTest.start();
	}

	//关闭服务器
	public void closeServer() throws Exception {
		if (server != null) {
			if (!server.isClosed()) {
				server.close();
				System.out.println("服务器关闭啦~~~~~~~~~~O(∩_∩)O哈哈哈~");
			}
		} else {
			System.out.println("服务器为NULL~~~~~~~~~~O(∩_∩)O哈哈哈~");
		}
	}

	//重载run方法
	@Override public void run() {
		while (true) {
			try {
				Socket socket = server.accept();
				if (socket != null) {
					System.out.println("收到了socket：" + socket.getRemoteSocketAddress().toString() + "我是父线程" + Thread.currentThread().getName());

					Thread thread = new Thread(new Processor(socket),"客户端");
					thread.start();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	//内部建一个一个新线程  用于通常解决这个问题的方法是使用多线程技术，一个客户端一个处理线程，出现阻塞时只是一个线程阻塞而不会影响其它线程工作；为了减少系统线程的开销，采用线程池的办法来减少线程创建和回收的成本
	public class Processor implements Runnable {

		private Socket socket;

		public Processor(Socket socket) {
			this.socket = socket;
		}

		@Override public void run() {
			InputStream in = null;
			OutputStream out = null;
			FileInputStream fin = null;
			try {
				System.out.println("我是" + Thread.currentThread().getName()+"子线程,我的地址是"+this.socket.getRemoteSocketAddress().toString());
				in = socket.getInputStream(); // 获取客户端发送的字节流
				out = socket.getOutputStream(); // 获取服务端响应的字节流
				byte[] b = new byte[1024 * 1024]; // 设置字节缓冲区
				in.read(b); // 读取客户端字节流（字节流的请求头）
				String txt = new String(b).trim(); // 将请求头封装成String，准备交给解析器解析
				MyRequestHeaderParser parser = (MyRequestHeaderParser) Class.forName(MyTest.getValue("myserver.requestheader.class")).newInstance(); // 使用工厂设计模式从config中加载请求头解析器的实例
				RequestHeader header = parser.parse(txt); // 终于可以解析了
				System.out.println(header);

				MyRequest myRequest = new MyRequest();
				myRequest.setHeader(header);
				myRequest.setParameter(header.getParameter());

				MyResponse myResponse = new MyResponse();
				//判断是不是动态加载页面
				if (null != MyTest.getValue(header.getUrl())) {
					try {
						MyServlet myServlet = (MyServlet) Class.forName(MyTest.getValue(header.getUrl())).newInstance();
						myResponse.setOut(new PrintWriter(out));
						myServlet.Myservice(myRequest, myResponse);
					} catch (Exception e) {
						File file = new File(MyTest.getValue("myserver.webapps"), "500.html");
						fin = new FileInputStream(file);
						byte[] buf = new byte[(int) file.length()];
						fin.read(buf);
						out.write(buf);
					}
				} else {
					//获取静态页面输出
					File html = new File(MyTest.getValue("myserver.webapps"), header.getUrl()); // 从配置文件检索服务端静态页面存放目录，定位到服务器端的静态页面
					if (!html.exists()) {
						html = new File(MyTest.getValue("myserver.webapps"), "404.html");
					}
					fin = new FileInputStream(html);
					byte[] buf = new byte[(int) html.length()];
					fin.read(buf);  // 读取静态页面内容
					out.write(buf); // 将静态页面内容写回给客户端浏览器显示
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
