package biztest;

/**
 * Created by huangyt on 2017/6/6.
 */
public class SmsSendAsync/* implements Runnable*/{
    private String prtNo;

    public SmsSendAsync(String prtNo) {
        super();
        this.prtNo = prtNo;
    }

    public String getPrtNo() {
        return prtNo;
    }

    public void setPrtNo(String prtNo) {
        this.prtNo = prtNo;
    }
    public void send() {
        new Thread(){
            public void run() {
                System.out.println("新的线程在执行..."+prtNo);
                System.out.println(prtNo);
            }
        }.start();
    }
   /* @Override
    public void run() {
            System.out.println("新的线程在执行...");
            System.out.println(prtNo);
    }*/
}
