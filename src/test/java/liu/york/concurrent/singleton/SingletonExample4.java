package liu.york.concurrent.singleton;

import liu.york.concurrent.annoations.NotThreadSafe;

/**
 * 懒汉模式
 */
@NotThreadSafe
public class SingletonExample4 {
    private SingletonExample4(){}

    private static SingletonExample4 instance;

    /**
     * 双重检测机制 + 同步锁
     * 第二重检测因为：
     *      多个线程进入以后第一个if以后，排队执行 sync 修饰的 第二个if
     *      如果没有第二个if，而是直接 new 对象，那么所有进入第一个 if 的线程都会新建 new
     * 但是：
     *      仍然不是安全的
     *      instance = new SingletonExample4();其实有三个步骤
     *          1 memory = allocate() 分配内存空间
     *          2 初始化对象
     *          3 设置对象执行内存
     *      JVM 和 CPU 会发生指令重排，那么这三个步骤会乱序
     *
     * @return
     */
    public static SingletonExample4 getInstance(){
        if(instance == null){
            synchronized (SingletonExample4.class){
                if(instance == null){
                    instance = new SingletonExample4();
                }
            }
        }
        return instance;
    }
}
