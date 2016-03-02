package designpattern.strategy;

/**
 * Created by JensenZz on 16/3/2.
 * Project name is mywork
 * O(∩_∩)O ^_^
 */
public interface QuackInterface {
	//因为叫不一定是鸟所有  鸭子也有   小鸡也有  所有单独设为接口  实现时  不同叫法不同实现
	public void quack();
}
