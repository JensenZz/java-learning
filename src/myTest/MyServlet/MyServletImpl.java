package myTest.MyServlet;

import myTest.Request.MyRequest;
import myTest.Response.MyResponse;

/**
 * Created by JensenZz on 16/1/11.
 * Project name is sbkj-b2b-mall
 * O(∩_∩)O ^_^
 */
public class MyServletImpl implements MyServlet {

	@Override public void Myservice(MyRequest req, MyResponse res) {
		if (req.getHeader().getMethod().equalsIgnoreCase("get")) {
			this.doGet(req, res);
		} else if (req.getHeader().getMethod().equalsIgnoreCase("post")) {
			this.doPost(req, res);
		} else {
			res.out.print("Cant Find This Method");
			res.out.close();
		}

	}

	public void doGet(MyRequest req, MyResponse res) {
	}

	public void doPost(MyRequest req, MyResponse res) {
	}
}
