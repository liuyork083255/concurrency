package liu.york.concurrent.sync;


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
public class SyncTest2{
    /**
     * 作用于这个类的所有实现类
     * 跟下面的其实是一致的
     */
    public static void test1(){
        synchronized (SyncTest2.class){
            for(int i=0;i<10;i++)
            {
                System.out.println("test1 -> " + i);
            }
        }
    }

    /**
     * 修饰方法，作用于这个类的所有实现类
     */
    public static synchronized void test2(){
        for(int i=0;i<10;i++)
        {
            System.out.println("test2 -> " + i);
        }
    }
}