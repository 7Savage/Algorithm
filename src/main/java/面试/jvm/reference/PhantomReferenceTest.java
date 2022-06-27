package 面试.jvm.reference;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class PhantomReferenceTest {
    public static void main(String[] args) {

        ReferenceQueue<PhantomReferenceTest> referenceQueue = new ReferenceQueue();
        PhantomReference<PhantomReferenceTest> phantomReference = new PhantomReference<>(new PhantomReferenceTest(),referenceQueue);
        //System.out.println(phantomReference.get());

        List<byte[]> list = new ArrayList<>();

        new Thread(() -> {
            while (true)
            {
                list.add(new byte[1 * 1024 * 1024]);
                try { TimeUnit.MILLISECONDS.sleep(500); } catch (InterruptedException e) { e.printStackTrace(); }
                System.out.println(phantomReference.get());
            }
        },"t1").start();

        new Thread(() -> {
            while (true)
            {
                Reference<? extends PhantomReferenceTest> reference = referenceQueue.poll();
                if (reference != null) {
                    //下面这句话被打印出说明进行了gc,然后将对象放在了引用队列中,我们可以使用poll方法获取
                    System.out.println("***********有虚对象加入队列了"+reference);
                }
            }
        },"t2").start();

        //暂停几秒钟线程
        try { TimeUnit.SECONDS.sleep(5); } catch (InterruptedException e) { e.printStackTrace(); }

    }

    @Override
    protected void finalize() throws Throwable {
        // gc finalize method over 这句话被打印出来,说明进行了gc
        System.out.println("gc finalize method over");
    }
}
