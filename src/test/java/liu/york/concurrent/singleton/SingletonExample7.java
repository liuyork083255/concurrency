package liu.york.concurrent.singleton;

import liu.york.concurrent.annoations.ThreadSafe;

/**
 * 使用枚举 很安全
 */
@ThreadSafe
public class SingletonExample7 {
    private SingletonExample7(){}

    private static SingletonExample7 instance = null;

    public static SingletonExample7 getInstance(){
        return Singleton.INSTANCE.getInstance();
    }

    private enum Singleton{
        INSTANCE;

        private SingletonExample7 singleton;

        // JVM 会保证这个方法只被调用一次
        Singleton(){
            singleton = new SingletonExample7();
        }

        public SingletonExample7 getInstance(){
            return singleton;
        }

    }
}
