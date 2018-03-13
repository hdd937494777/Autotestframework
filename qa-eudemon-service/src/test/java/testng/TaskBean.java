package testng;

import java.util.concurrent.CyclicBarrier;

/**
 * Created by huangyt on 2017/6/3.
 */
public class TaskBean implements Runnable {
    private CyclicBarrier cyclicBarrier;
    int n = 0;

    public TaskBean(CyclicBarrier cyclicBarrier, int n) {
        this.cyclicBarrier = cyclicBarrier;
        this.n = n;
    }

    @Override
    public void run() {
        try {
            // 等待所有任务准备就绪
            System.out.println("赛马" + n + "到达栅栏前");
            cyclicBarrier.await();
            System.out.println("赛马" + n + "开始跑");
            // 测试内容
            System.out.println("hello: " + n);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

