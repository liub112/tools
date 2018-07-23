package com.lfxfs.tools.pattern.singleton;

import java.io.Serializable;

public class Singleton implements Serializable{

    private Singleton() {}

    public static final Singleton newInstance(){
        return SingletonHandler.INSTANCE;
    }

    private static class SingletonHandler{
        private static final  Singleton INSTANCE =  new Singleton();
    }

    public void doSomething(){
        System.out.println("I'm a Singleton class");
    }


    private Object readResolve(){
        return SingletonHandler.INSTANCE;
    }

}
