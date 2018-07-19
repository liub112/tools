package com.lfxfs.tools.pattern.singleton;


import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class SingletonTest {
    public static void main(String[] args) {
        Executor executor = Executors.newFixedThreadPool(20);
        for (int i = 0; i < 1000; i++) {
            executor.execute(new Runnable(){

                /**
                 * When an object implementing interface <code>Runnable</code> is used
                 * to create a thread, starting the thread causes the object's
                 * <code>run</code> method to be called in that separately executing
                 * thread.
                 * <p>
                 * The general contract of the method <code>run</code> is that it may
                 * take any action whatsoever.
                 *
                 * @see Thread#run()
                 */
                @Override
                public void run() {
                    Singleton singleton  = Singleton.newInstance();
                    System.out.println(singleton);
                    singleton.doSomething();
                }
            });
        }
    }
}
