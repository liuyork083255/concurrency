package liu.york.concurrent;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicBoolean;

public class ConcurrencyTest {
    private static int count = 0;

    private static int threadTotal = 100;

    private static int clientTotal = 5000;

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        final Semaphore semaphore = new Semaphore(threadTotal);
        final CountDownLatch countDownLatch = new CountDownLatch(clientTotal);

        for(int i=0; i<clientTotal;i++)
        {
            executorService.execute(() ->
            {
                try {
                    /*
                     * 申请一个信号量，如果没有申请到，当前线程则阻塞
                     * 可以用来控制并发数量，如果信号量设置100，那么最多同时只有100个线程获取到信号量，才能执行
                     */
                    semaphore.acquire();
                    add();
                    /*
                     * 释放当前线程申请到的信号量
                     */
                    semaphore.release();
                } catch (InterruptedException e) {
                    System.out.println("cache " + e.getMessage());
                }
                /*
                 * 每个线程执行完成以后，调用这个方法可以让 countDownLatch 值减一
                 */
                countDownLatch.countDown();
            });
        }
        /*
         * 这个方法会阻塞直到 countDownLatch 变为0 才会执行
         */
        countDownLatch.await();

        executorService.shutdown();
        System.out.println("count = " + count);
    }

    private static void add(){
        count++;
    }
}
