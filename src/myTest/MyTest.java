package myTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by JensenZz on 16/1/6.
 * Project name is sbkj-b2b-mall
 * O(∩_∩)O ^_^
 */
public class MyTest {

    //下面是  3线程循环打印ABC
    private AtomicInteger atomicInteger = new AtomicInteger(0);

    //自定义锁  用来锁代码块
    private byte[] lock = new byte[0];

    public class Inner implements Runnable {

        private int pid = 0;

        public Inner(int pid) {
            this.pid = pid;
        }

        @Override
        public void run() {
            try {
                for (int i = 0; i < 10; i++) {
                    while (true) {
                        synchronized (lock) {
                            if (atomicInteger.get() % 3 == this.pid) {
                                System.out.println(Thread.currentThread().getName() + "已经运行次数" + atomicInteger.get());
                                atomicInteger.incrementAndGet();
                                lock.notifyAll();
                                break;
                            }
                            lock.wait();
                        }
                    }
                }
            } catch (Exception e) {

            }
        }
    }


    //读配置文件

    private static Properties props = new Properties();

    static {
        try {
            props.load(new FileInputStream("/Users/JensenZz/Documents/mywork/src/myTest/MyTestConfig.properties"));
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(0);
        }
    }

    public static String getValue(String key) {
        return props.getProperty(key);
    }

}
