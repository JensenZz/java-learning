package myTest;

import java.util.HashMap;

/**
 * 封装请求头
 * Created by JensenZz on 16/1/7.
 * Project name is sbkj-b2b-mall
 * O(∩_∩)O ^_^
 */
public class RequestHeader {

	private String method;
	private String url;
	private String protocal;
	private String accept;
	private String accept_language;
	private String user_agent;
	private String accept_encoding;
	private String ip;
	private String port;
	private String connection;
	private String cookie;
	private String parameter;

	// 存放请求头键值对
	private HashMap<String, String> map;
	// 存放请求头文本
	private String txt;

	@Override
	public String toString() {
		return "RequestHeader [" + "\n"
				+ method + " " + url + " " + protocal + "\n"
				+ "Accept: " + accept + "\n"
				+ "Accept-Language: " + accept_language + "\n"
				+ "User-Agent: " + user_agent + "\n"
				+ "Accept-Encoding: " + accept_encoding + "\n"
				+ "Host: " + ip + ":" + port + "\n"
				+ "Connection: " + connection + "\n"
				+ "Cookie: " + cookie + "\n"
				+ "Parameter: " + parameter + "\n"
				+ "]";
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public void setProtocal(String protocal) {
		this.protocal = protocal;
	}

	public void setAccept(String accept) {
		this.accept = accept;
	}

	public void setAccept_language(String accept_language) {
		this.accept_language = accept_language;
	}

	public void setUser_agent(String user_agent) {
		this.user_agent = user_agent;
	}

	public void setAccept_encoding(String accept_encoding) {
		this.accept_encoding = accept_encoding;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public void setPort(String port) {
		this.port = port;
	}

	public void setConnection(String connection) {
		this.connection = connection;
	}

	public void setCookie(String cookie) {
		this.cookie = cookie;
	}

	public void setMap(HashMap<String, String> map) {
		this.map = map;
	}

	public void setTxt(String txt) {
		this.txt = txt;
	}

	public String getMethod() {
		return method;
	}

	public String getUrl() {
		return url;
	}

	public String getProtocal() {
		return protocal;
	}

	public String getAccept() {
		return accept;
	}

	public String getAccept_language() {
		return accept_language;
	}

	public String getUser_agent() {
		return user_agent;
	}

	public String getAccept_encoding() {
		return accept_encoding;
	}

	public String getIp() {
		return ip;
	}

	public String getPort() {
		return port;
	}

	public String getConnection() {
		return connection;
	}

	public String getCookie() {
		return cookie;
	}

	public HashMap<String, String> getMap() {
		return map;
	}

	public String getTxt() {
		return txt;
	}

	public String getParameter() {
		return parameter;
	}

	public void setParameter(String parameter) {
		this.parameter = parameter;
	}
}
