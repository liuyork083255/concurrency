package liu.york.concurrent.singleton;

import liu.york.concurrent.annoations.ThreadSafe;

/**
 * 饿汉模式
 * 使用静态方块
 * Note：
 *      如果使用静态块一定要注意顺序
 */
@ThreadSafe
public class SingletonExample6 {
    private SingletonExample6(){}

    static {
        instance = new SingletonExample6();
    }
    private static SingletonExample6 instance = null;

    // TODO: 2018/8/9  上面代码永远都是空指针，因为是按照顺序来执行的，先是初始化，然后又被赋值微 null

    public static SingletonExample6 getInstance(){
        return instance;
    }
}
