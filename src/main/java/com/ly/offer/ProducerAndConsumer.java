package com.ly.offer;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * description:生产着和消费者模型
 *
 * @author: tuoer
 * @date： 2019/9/29
 */
public class ProducerAndConsumer {
    public static void main(String[] args) throws Exception {
        Mydata mydata = new Mydata();

        new Thread(() ->{

            try {
                mydata.increame1();
                mydata.increame1();
                mydata.increame1();
                mydata.increame1();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() ->{

            try {
                mydata.decreame1();
                mydata.decreame1();
                mydata.decreame1();
                mydata.decreame1();
                mydata.decreame1();
            } catch (Exception e) {
                e.printStackTrace();
            }


        }).start();
    }
}

class Mydata {
    private volatile int num = 0 ;
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();
    final ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue<>(10);



    public void increame() throws Exception  {

        lock.lock();
        while (num == 5 ) {
            condition.await();
        }
        num ++;
        System.out.println(Thread.currentThread().getName()+"生产：" + num);
        condition.signal();
        lock.unlock();

    }

    public void decreame() throws  Exception {
        lock.lock();
        while (num == 0 ) {
            condition.await();
        }

        System.out.println(Thread.currentThread().getName()+"消费：" + num);
        num --;
        condition.signal();
        lock.unlock();

    }



    public void increame1() throws Exception  {
        lock.lock();
        final int round = Math.round(1000);
        queue.put(round);
        System.out.println(Thread.currentThread().getName()+"生产：" + round);
        lock.unlock();

    }

    public void decreame1() throws  Exception {
        System.out.println(Thread.currentThread().getName()+"消费：" +queue.take());

    }



}
