package com.lfxfs.tools.pattern.proxy;

public interface ICache {
    Object get(String key);

    void put(String key,String value);
}
