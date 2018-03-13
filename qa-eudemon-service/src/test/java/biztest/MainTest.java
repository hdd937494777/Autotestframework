package biztest;

/**
 * Created by huangyt on 2017/6/6.
 */
public class MainTest {

    @org.junit.Test
    public void testSmssend() {
        String prtNo = "1001200912310155555";
        //调用异步发送消息
        for (int i =0; i<10;i++){
            SmsSendAsync sendAsync = new SmsSendAsync(String.valueOf(i));
            // sendAsync.run();
            sendAsync.send();
        }
        System.out.println("已经签单");
    }
}
