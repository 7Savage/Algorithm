package 面试.多线程;

import org.junit.Test;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicStampedReference;

/*
    CAS
    1. synchronized关键字与Lock等锁机制都是悲观锁：无论做何种操作，首先需要上锁，接下来再去执行后续操作，从而确保了接下来的所有
       操作都是由当前这个线程来执行
    2. 乐观锁：线程在操作之前不会做任何预先处理，而是直接去执行；当在最后执行变量更新的时候，当前线程需要有一种机制来确保当前操作
       的变量是没有被其他线程修改的；CAS是乐观锁的一种极为重要的实现方式

    CAS(Compare And Swap)
    比较与交换：这是一个不断循环的过程，一直到变量值被修改成功为止，CAS本身是由硬件指令来提供的。换句话说，硬件中通过一个原子指令
    来实现与比较的；因此，CAS可以确保变量操作的原子性

    对于CAS来说，其操作数主要涉及到如下三个：
    1. 需要被操作的内存值V
    2. 需要进行比较的值A
    3. 需要进行写入的值B

    只有当V==A的时候，CAS才会通过原子操作的手段来讲V的值更新为B

    关于CAS的限制或是问题
    1. 循环开销问题：并发量大的情况下会导致线程一直自旋
    2. 只能脑子一个变量的原子操作；可以通过AtomicReference来实现对多个变量的原子操作
    3. ABA问题：1 ->3 ->1
 */
public class CASTest {
    @Test
    //CAS产生ABA问题，单元测试不支持多线程，需要引入额外包
    public void ABA1(){
        AtomicInteger atomicInteger=new AtomicInteger(2000);
        //捣乱线程
        System.out.println(atomicInteger.compareAndSet(2000, 2001));
        System.out.println(atomicInteger.get());
        System.out.println(atomicInteger.compareAndSet(2001, 2000));
        System.out.println(atomicInteger.get());
        //期望的线程
        System.out.println(atomicInteger.compareAndSet(2000, 6666));
        System.out.println(atomicInteger.get());
    }
    // 正常在业务操作，这里面比较的都是一个个对象
    static AtomicStampedReference<Integer> atomicStampedReference = new AtomicStampedReference<>(1,1);

    // CAS  compareAndSet : 比较并交换！
    public static void main(String[] args) {

        new Thread(()->{
            int stamp = atomicStampedReference.getStamp(); // 获得版本号
            System.out.println("a1=>"+stamp);

            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            //Lock lock = new ReentrantLock(true);

            atomicStampedReference.compareAndSet(1, 2,
                    stamp, stamp + 1);

            System.out.println("a2=>"+atomicStampedReference.getStamp());


            System.out.println(atomicStampedReference.compareAndSet(2, 1,
                    atomicStampedReference.getStamp(), atomicStampedReference.getStamp() + 1));

            System.out.println("a3=>"+atomicStampedReference.getStamp());

        },"a").start();


        // 乐观锁的原理相同！
        new Thread(()->{
            int stamp = atomicStampedReference.getStamp(); // 获得版本号
            System.out.println("b1=>"+stamp);

            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            //返回false，如果最后两个参数改为get和get+1，则返回true
            System.out.println(atomicStampedReference.compareAndSet(1, 6,
                    stamp, stamp + 1));

            System.out.println("b2=>"+atomicStampedReference.getStamp());

        },"b").start();

    }
}
