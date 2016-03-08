package designpattern.strategy;

import java.util.HashMap;

/**
 * Created by JensenZz on 16/3/2.
 * Project name is mywork
 * O(∩_∩)O ^_^
 */
public class BlackBird extends Bird {

	//来组装黑鸟吧    加一些他自己特有的玩意
	private String plume = "黑色的羽毛";

	//来注入一些他想要的飞法或者叫法
	BlackBird() {
		flyInterface = new ShaBeeFly();
		quackInterface = new zhizhiQuack();
	}

	@Override public void showMe() {
		this.performQuack();
		this.performFly();
		System.out.println(plume);
	}

}
