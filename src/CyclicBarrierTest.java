import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * Created by JensenZz on 16/3/1.
 * Project name is mywork
 * O(∩_∩)O ^_^
 */
public class CyclicBarrierTest {

	//时间  为秒
	Long time = 0l;

	/**
	 * 问题：一个池塘，有很多鸟和很多鱼，鸟每分钟产生一个后代，鱼每30秒钟产生2个后代。鸟每10秒钟要吃掉一条鱼。
	 * 建一个池塘，初始化一些鱼和鸟，看看什么时候鸟把鱼吃光。
	 * 解决方案  利用cyclicBarrier  来保证鸟的的时间线与鱼的时间线能够同步
	 */
	Fish fish;

	Bird bird;

	CyclicBarrierTest(Long fish, Long bird) {
		this.fish = new Fish(fish);
		this.bird = new Bird(bird);
	}

	CyclicBarrier cyclicBarrier = new CyclicBarrier(2, new Runnable() {

		//cyclicBarrier中的参数是在2个线程到awake方法之前会被暂停 直到2线程都到达指定位置
		// 触发下面run方法候 那两个线程再继续执行下去
		@Override public void run() {
			System.out.println("时间线走到" + time + "秒");
			if (fish.getFishCount() > bird.getBirdCount()) {
				if (time % 10 == 0) {
					fish.setFishCount(fish.getFishCount() - bird.getBirdCount());
					System.out.println("现在有鱼" + fish.getFishCount() + "条,有鸟" + bird.getBirdCount() + "只,刚刚被吃了" + bird.getBirdCount() + "条!");
				}
			} else {
				System.out.println("此时鸟的数量比鱼多,大家都死光吧!O(∩_∩)O哈哈~");
				fish.setRun(false);
				bird.setRun(false);
				System.exit(-1);
			}
			time += 10;
		}
	});

	public void start() {
		fish.start();
		new Thread(bird).start();
	}

	public static void main(String[] args) {
		CyclicBarrierTest cyclicBarrierTest = new CyclicBarrierTest(100l, 20l);
		cyclicBarrierTest.start();
	}

	public class Fish extends Thread {

		//鱼的数量
		Long fishCount = 0l;

		Boolean run = true;

		Fish(Long num) {
			this.fishCount = num;
		}

		@Override public void run() {
			while (run) {
				try {
					//设置大门
					cyclicBarrier.await();

					if (time % 30 == 0) {
						fishCount = fishCount * 3;
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				} catch (BrokenBarrierException e) {
					e.printStackTrace();
				}

			}
		}

		public Long getFishCount() {
			return fishCount;
		}

		public void setFishCount(Long fishCount) {
			this.fishCount = fishCount;
		}

		public Boolean getRun() {
			return run;
		}

		public void setRun(Boolean run) {
			this.run = run;
		}
	}

	public class Bird implements Runnable {

		//鸟的数量
		Long birdCount = 0l;

		Boolean run = true;

		Bird(Long num) {
			this.birdCount = num;
		}

		@Override public void run() {
			while (run) {
				try {
					cyclicBarrier.await();
					if (time % 60 == 0) {
						birdCount += birdCount;
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				} catch (BrokenBarrierException e) {
					e.printStackTrace();
				}
			}
		}

		public Long getBirdCount() {
			return birdCount;
		}

		public void setBirdCount(Long birdCount) {
			this.birdCount = birdCount;
		}

		public Boolean getRun() {
			return run;
		}

		public void setRun(Boolean run) {
			this.run = run;
		}
	}

}
