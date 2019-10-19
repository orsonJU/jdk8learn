package test.java.lang;


import org.junit.Test;

import java.util.concurrent.TimeUnit;

public class ThreadSpec {

    class JoinThread implements Runnable {

        int count;

        @Override
        public void run() {
            while(!Thread.interrupted()) {
                count++;
                try {
                    TimeUnit.SECONDS.sleep(1);
                    System.out.println("i'm running");

                    if(count > 5) {
                        // 因为是thread线程自己中断，所以不会抛出InterruptedException
                        // 当且仅当线程调用类似sleep或者其他会抛出InterruptedException的方法的时候被中断才会抛出异常
                        Thread.currentThread().interrupt();
                    }
                } catch (InterruptedException e) {
                    System.out.println("i was interrupted.");
                    e.printStackTrace();
                }
            }
            System.out.println("out of while loop");
        }
    }

    @Test
    public void test_join() throws InterruptedException {

        JoinThread jt = new JoinThread();
        Thread thread = new Thread(jt);
        thread.start();

        System.out.println("start join");

        // 因为main线程调用了thread的join方法，所以main线程会等待thread的执行结束
        thread.join();

        System.out.println("end join");

    }
}
