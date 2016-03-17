import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by JensenZz on 16/3/4.
 * Project name is mywork
 * O(∩_∩)O ^_^
 */
public class LockMain {

	Lock lock = new ReentrantLock();

	ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

	Lock readLock = readWriteLock.readLock();
	Lock writeLock = readWriteLock.writeLock();

	Condition condition = lock.newCondition();

	Set set = new HashSet();
	List list = new ArrayList();
	Map map =new ConcurrentHashMap();


	public static void main(String[] args) {
		Map hashMap =new HashMap();
		hashMap.put(null,null);
		System.out.println(hashMap.get(null));
	}


}
