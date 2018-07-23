package com.lfxfs.tools.pattern.observer;




public class ObserverTest {

    public static void main(String[] args) {
        Subject subject = new Subject();
        BaBaObserver baBaObserver = new BaBaObserver();
        MamaObserver mamaObserver = new MamaObserver();
        subject.addObserver(baBaObserver);
        subject.addObserver(mamaObserver);
        for (int i = 0; i <20 ; i++) {
            subject.doSomething();
        }
        System.out.println("I'm finished!");
    }


}
