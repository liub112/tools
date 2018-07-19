package com.lfxfs.tools.pattern.observer;

import java.util.Observable;

public class Subject extends Observable{
    private String name="I'm lili";

    public void doSomething(){
        setChanged();
        notifyObservers(name);
    }
}
