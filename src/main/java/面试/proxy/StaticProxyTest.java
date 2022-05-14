package 面试.proxy;

import org.junit.Test;
//静态代理实现步骤:
//1.定义一个接口及其实现类；
//2.创建一个代理类同样实现这个接口
//3.将目标对象注入进代理类，然后在代理类的对应方法调用目标类中的对应方法。
// 这样的话，我们就可以通过代理类屏蔽对目标对象的访问，并且可以在目标方法执行前后做一些自己想做的事情。
public class StaticProxyTest {
    interface SmsService {
        public void send(String msg);
    }

    class SmsServiceImpl implements SmsService {
        @Override
        public void send(String msg) {
            System.out.println("信息发送：" + msg);
        }
    }

    class proxySmsService implements SmsService{

        private final SmsService smsService;

        proxySmsService(SmsService smsService) {
            this.smsService = smsService;
        }

        @Override
        public void send(String msg) {
            System.out.println("发送前");
            smsService.send(msg);
            System.out.println("发送后");
        }
    }

    @Test
    public void test(){
        SmsServiceImpl smsService = new SmsServiceImpl();
        proxySmsService proxySmsService = new proxySmsService(smsService);
        proxySmsService.send("特雷杨");
    }
}
