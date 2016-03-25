package designpattern.Strategy;

/**
 * Created by JensenZz on 16/3/2.
 * Project name is mywork
 * O(∩_∩)O ^_^
 */
public class RedBird extends Bird {

	//来组装红鸟吧    加一些他自己特有的玩意
	private String plume = "红色的羽毛";

	//来注入一些他想要的飞法或者叫法
	RedBird() {
		flyInterface = new NewBeeFly();
		quackInterface = new zhazhaQuack();
	}

	@Override public void showMe() {
		this.performQuack();
		this.performFly();
		System.out.println(plume);
	}
}
