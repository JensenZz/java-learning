package designpattern.strategy;

/**
 * Created by JensenZz on 16/3/2.
 * Project name is mywork
 * O(∩_∩)O ^_^
 */
public class CanNotFly implements FlyInterface {

	@Override public void fly() {
		System.out.println("shit , I can not fly ,怪我咯!!");
	}
}
