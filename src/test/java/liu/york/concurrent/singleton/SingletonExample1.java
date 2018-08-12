package liu.york.concurrent.singleton;

import liu.york.concurrent.annoations.NotThreadSafe;

/**
 * 懒汉模式
 */
@NotThreadSafe
public class SingletonExample1 {
    private SingletonExample1(){}

    private static SingletonExample1 instance;

    public static SingletonExample1 getInstance(){
        if(instance == null){
            instance = new SingletonExample1();
        }
        return instance;
    }
}
