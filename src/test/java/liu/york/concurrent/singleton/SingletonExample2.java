package liu.york.concurrent.singleton;

import liu.york.concurrent.annoations.ThreadSafe;

/**
 * 饿汉模式
 * 好处就是不用考虑线程安全
 * 但是如果类初始化很慢，那么加载这个类的时候就非常慢，影响性能
 * 并且如果没有使用这个类，那么加载了它也会出现浪费
 */
@ThreadSafe
public class SingletonExample2 {
    private SingletonExample2(){}

    private static SingletonExample2 instance = new SingletonExample2();

    public static SingletonExample2 getInstance(){
        return instance;
    }
}
