package com.lfxfs.tools.pattern.observer;

import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MamaObserver implements Observer {
    ExecutorService executor = Executors.newSingleThreadExecutor();
    /**
     * This method is called whenever the observed object is changed. An
     * application calls an <tt>Observable</tt> object's
     * <code>notifyObservers</code> method to have all the object's
     * observers notified of the change.
     *
     * @param o   the observable object.
     * @param arg an argument passed to the <code>notifyObservers</code>
     */
    @Override
    public void update(Observable o, Object arg) {
       final String content = (String) arg;
        executor.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000l);
                    System.out.println(Thread.currentThread().getName()+":I'm MAMA lisenter:"+content);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
