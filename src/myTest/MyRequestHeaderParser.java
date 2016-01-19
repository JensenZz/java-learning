package myTest;

/**
 * Created by JensenZz on 16/1/7.
 * Project name is sbkj-b2b-mall
 * O(∩_∩)O ^_^
 */
public interface MyRequestHeaderParser {

	/**
	 * 解析请求头
	 * @param txt
	 * @return
	 * @throws Exception
	 */
	public RequestHeader parse(String txt) throws Exception;
}
