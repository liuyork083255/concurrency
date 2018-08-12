package liu.york.concurrent.singleton;

import liu.york.concurrent.annoations.ThreadSafe;

/**
 * 懒汉模式
 */
@ThreadSafe
public class SingletonExample5 {
    private SingletonExample5(){}

    private static volatile SingletonExample5 instance;

    /**
     *  终极版本
     *      使用 volatile 关键字
     *
     * @return
     */
    public static SingletonExample5 getInstance(){
        if(instance == null){
            synchronized (SingletonExample5.class){
                if(instance == null){
                    instance = new SingletonExample5();
                }
            }
        }
        return instance;
    }
}
