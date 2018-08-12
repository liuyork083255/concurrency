package liu.york.concurrent.sync;

import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 原子性 synchronized 关键字
 * 修饰代码块：   大括号括起来的代码，作用于调用对象
 * 修饰方法：     整个方法，作用于调用对象
 * 修饰静态方法： 整个静态方法，作用于所有对象
 * 修饰类：       括起来的的部分，作用于所有对象
 *
 * Note：一个方法被 synchronized 关键字修饰了，那么这个方法如果被继承，synchronized 是不会被继承的
 * 因为 synchronized 不属于方法申明的一部分
 *
 */
public class SyncTest1 {
    /**
     * 作用于调用这个对象的方法
     */
    public void test1(){
        synchronized (this){
            for(int i=0;i<10;i++)
            {
                System.out.println("test1 -> " + i);
            }
        }
    }

    /**
     * 修饰方法，作用于调用这个对象的方法
     */
    public synchronized void test2(){
        for(int i=0;i<10;i++)
        {
            System.out.println("test2 -> " + i);
        }
    }


    @Test
    public void main(){
        ExecutorService executorService = Executors.newCachedThreadPool();

        /*  同一个对象调用，线程安全，有序输出 */
//        SyncTest syncTest1 = new SyncTest();
//        executorService.execute(() -> syncTest1.test1());
//        executorService.execute(() -> syncTest1.test1());

        /* 不同的方法，它们之间是线程不安全的，各自不影响 */
        SyncTest1 syncTest1 = new SyncTest1();
        SyncTest1 syncTest2 = new SyncTest1();
        executorService.execute(() -> syncTest1.test1());
        executorService.execute(() -> syncTest2.test1());
    }

}