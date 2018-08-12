package liu.york.concurrent.volatil;

/**
 * volatile 关键字修饰变量进行 i++ 操作解析：
 *      i++ 操作其实分为了三步
 *      1 读取i，这个时候肯定是最新的
 *      2 +1 操作
 *      3 写回主存
 *      这个时候两个线程A B 都进行1操作，比如读取到5，然后都执行2操作，然后同时写入主存，这样
 *      A B两个线程都把6 写回去，丢失了一次 +1 操作
 * 所以 这个关键字 不具备原子性
 * 那什么时候可以使用？
 * 的具备两个条件
 *      1 对变量写操作不依赖当期值
 *      2 该变量没有包含在具有其它变量的不变的式子中
 *
 * 使用场景：
 *      终止一个线程执行
 *      volatile boolean flag = false;
 *      while(!flag){sleep();}
 *
 * 使用场景：
 *      double check 双重检测
 *
 */
public class Readme {
}
