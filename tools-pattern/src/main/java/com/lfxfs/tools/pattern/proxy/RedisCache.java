package com.lfxfs.tools.pattern.proxy;

public class RedisCache implements ICache{
    @Override
    public Object get(String key) {
        System.out.println("I'm real Cache get");
        return "I'm real Cache";
    }

    @Override
    public void put(String key, String value) {
        System.out.println("I'm real Cache put");
    }
}
