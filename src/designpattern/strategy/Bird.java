package designpattern.Strategy;

/**
 * Created by JensenZz on 16/3/2.
 * Project name is mywork
 * O(∩_∩)O ^_^
 */
public class Bird {
	//我们来组装鸟吧   飞  叫  但是鸟也有不同种类 那父类就放一些共有的吧 ,不同的鸟根据特点分开区分实现

	protected QuackInterface quackInterface;

	protected FlyInterface flyInterface;

	public void performFly() {
		flyInterface.fly();
	}

	public void performQuack() {
		quackInterface.quack();
	}

	//默认展示一般鸟的属性  不同种类鸟展示就重写方法吧
	public void showMe(){
		performFly();
		performQuack();
	}

	public QuackInterface getQuackInterface() {
		return quackInterface;
	}

	public void setQuackInterface(QuackInterface quackInterface) {
		this.quackInterface = quackInterface;
	}

	public FlyInterface getFlyInterface() {
		return flyInterface;
	}

	public void setFlyInterface(FlyInterface flyInterface) {
		this.flyInterface = flyInterface;
	}
}
