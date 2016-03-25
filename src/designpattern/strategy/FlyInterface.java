package designpattern.Strategy;

/**
 * Created by JensenZz on 16/3/2.
 * Project name is mywork
 * O(∩_∩)O ^_^
 */
public interface FlyInterface {
    //因为飞不一定是鸟所有  鸭子也有   小鸡也有  所有单独设为接口  实现时  不同飞法不同实现
	public void fly();
}
