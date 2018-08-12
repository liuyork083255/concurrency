package liu.york.concurrent.singleton;

import liu.york.concurrent.annoations.ThreadSafe;

/**
 * 懒汉模式
 */
@ThreadSafe
public class SingletonExample3 {
    private SingletonExample3(){}

    private static SingletonExample3 instance;

    /**
     * synchronized 保证线程安全，但是这个方式很影响性能
     * @return
     */
    public static synchronized SingletonExample3 getInstance(){
        if(instance == null){
            instance = new SingletonExample3();
        }
        return instance;
    }
}
