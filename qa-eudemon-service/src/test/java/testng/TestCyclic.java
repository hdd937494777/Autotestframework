package testng;

import org.junit.Test;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by huangyt on 2017/6/3.
 */
public class TestCyclic {
    @Test
    public void test01() {
       int count = 10;//并发线程数
        CyclicBarrier cyclicBarrier = new CyclicBarrier(count);
        ExecutorService executorService = Executors.newFixedThreadPool(count);
        int n = 0;
        for (int i = 0; i < count; i++) {

            executorService.execute(new TaskBean(cyclicBarrier, n));
            n++;
        }
        executorService.shutdown(); // 关闭线程池
        // 判断是否所有的线程已经运行完
        while (!executorService.isTerminated()) {
            try {
                // 所有线程池中的线程执行完毕，执行后续操作
                // TODO
                System.out.println("==============is sleep============");
                Thread.sleep(10000);
                System.out.println("==============is wake============");

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        for (int j =0 ;j < 12;){

            for (int i = 1; i <= 4; i++) {
                System.out.println("i-----------------:"+i);
                System.out.println("j---------------------"+j);
                j++;
            }


        }
    }
}
