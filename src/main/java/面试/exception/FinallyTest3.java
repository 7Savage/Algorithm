package 面试.exception;

public class FinallyTest3 {
    public static void main(String[] args) throws Exception {
        Thread thread = new Thread(new Runnable() {
            public void run() {
                try {
                    //正常业务逻辑
                    System.out.println("I am try");
                    Thread.sleep(1000);
                } catch (Exception e) {
                    //异常处理
                    System.out.println("I am Exception -> " + e.getMessage());
                } finally {
                    //释放资源等
                    System.out.println("I am Finally");
                }
            }
        });
        thread.setDaemon(true);
        thread.start();
        Thread.sleep(1000);
        System.out.println("end");
    }
}
