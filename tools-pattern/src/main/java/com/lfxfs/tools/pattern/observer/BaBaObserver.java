package com.lfxfs.tools.pattern.observer;

import java.util.Observable;
import java.util.Observer;

public class BaBaObserver implements Observer {
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
        String content = (String) arg;
        System.out.println(Thread.currentThread().getName()+":baba lisenter:"+content);
    }
}
