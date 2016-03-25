package designpattern.Strategy;

/**
 * Created by JensenZz on 16/3/2.
 * Project name is mywork
 * O(∩_∩)O ^_^
 */
public class Test {

	public static void main(String[] args) {
		BlackBird blackBird = new BlackBird();
		RedBird redBird = new RedBird();
		blackBird.showMe();
		redBird.showMe();
	}


}
