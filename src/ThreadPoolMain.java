import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import myTest.MyServerTest;
import myTest.MyTest;

/**
 * Created by JensenZz on 16/1/22.
 * Project name is mywork
 * O(∩_∩)O ^_^
 */
public class ThreadPoolMain {

	public static void main(String[] args) {
		//创建一个可重用固定线程数的线程池  只有一条线程
		ExecutorService pool1 = Executors. newSingleThreadExecutor();
		//创建一个可重用固定线程数的线程池   可设置的固定大小的创建固定大小的线程池。每次提交一个任务就创建一个线程，直到线程达到线程池的最大大小。线程池的大小一旦达到最大值就会保持不变，如果某个线程因为执行异常而结束，那么线程池会补充一个新线程。
		ExecutorService pool2 = Executors.newFixedThreadPool(2);
		//创建一个可缓存的线程池。如果线程池的大小超过了处理任务所需要的线程，
		//那么就会回收部分空闲（60秒不执行任务）的线程，当任务数增加时，此线程池又可以智能的添加新线程来处理任务。此线程池不会对线程池大小做限制，线程池大小完全依赖于操作系统（或者说JVM）能够创建的最大线程大小。
		ExecutorService pool3 = Executors.newCachedThreadPool();
		//创建一个大小无限的线程池。此线程池支持定时以及周期性执行任务的需求。
		ExecutorService pool4 =Executors.newScheduledThreadPool(9);
		//创建实现了Runnable接口对象，Thread对象当然也实现了Runnable接口
		Thread t1 = new MyServerTest();
		Thread t2 = new MyServerTest();
		Thread t3 = new MyServerTest();
		Thread t4 = new MyServerTest();
		Thread t5 = new MyServerTest();
		//将线程放入池中进行执行
		pool1.execute(t1);
		pool1.execute(t2);
		pool1.execute(t3);
		pool1.execute(t4);
		pool1.execute(t5);
		//关闭线程池
		pool1.shutdown();
	}
}
