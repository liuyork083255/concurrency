package liu.york.concurrent;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.TimeUnit;


public class ConcurrentApplicationTests {

    @Test
    public void contextLoads() throws InterruptedException {

        try {
            new Thread(() -> {
                if(1 == 1){
                    throw new RuntimeException("heiehi ");
                }
            }).start();
        } catch (Throwable e) {
            System.out.println("发现异常");
        }

        TimeUnit.SECONDS.sleep(10);
    }

}
