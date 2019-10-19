package test.java.util.concurrent.locks;

import org.junit.Test;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

public class LockSupportSpec {


    class MyFuture implements Runnable {

        private Thread target;

        private String result;

        public MyFuture(Thread target) {
            this.target = target;
        }

        @Override
        public void run() {


            try {
                System.out.println("sleeping");
                TimeUnit.SECONDS.sleep(5);

                result = "Orson";
//                LockSupport.unpark(target);
                System.out.println("unpark");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


        public String get() {

            if(result == null) {
                System.out.println("park");
                LockSupport.park(this);
                System.out.println("hahah");
            }

            return result;
        }
    }

    @Test
    public void part() {


        MyFuture myFuture = new MyFuture(Thread.currentThread());
        Thread thread = new Thread(myFuture);
        thread.start();


        String result = myFuture.get();
        System.out.println("main: result is " + result);


    }
}
