package liu.york.concurrent.sync;

/**
 * 原子对比
 *          synchronized ----- Lock
 *    前者是不可中断锁，进入代码块后，就必须等待执行完成，适用于竞争不激烈，可读性好
 *    后者是可中断锁，(使用 unlock)， 多样化同步，竞争激烈时能维持常态，也就是如果竞争激烈，前者性能下降很快
 *
 *    而 Atomic 包下的对象，竞争激烈时能维持常态，比 Lock 性能好，但是只能同步一个值
 *
 */
public class Readme {}
