package myTest.MyServlet;

import java.util.Hashtable;
import java.util.regex.Pattern;

import myTest.Request.MyRequest;
import myTest.Response.MyResponse;

/**
 * Created by JensenZz on 16/1/11.
 * Project name is sbkj-b2b-mall
 * O(∩_∩)O ^_^
 */
public class MyLoginServlet extends MyServletImpl {

	@Override
	public void doGet(MyRequest req, MyResponse res) {
		String username = req.getParameterValue("username"); // 接收客户端请求参数
		String password = req.getParameterValue("password");
		if (username.equals("zz") && password.equals("123456")) { // 执行简单逻辑判断
			res.out.print("Hello, " + username + "<br>"); // 输出结果信息
		}
		res.out.close();
	}

	@Override
	public void doPost(MyRequest req, MyResponse res) {
		String username = req.getParameterValue("username");
		String password = req.getParameterValue("password");
		if (username.equals("zz") && password.equals("123456")) {
			res.out.print("Hello, " + username + "<br>");
		}
		res.out.close();
	}


}