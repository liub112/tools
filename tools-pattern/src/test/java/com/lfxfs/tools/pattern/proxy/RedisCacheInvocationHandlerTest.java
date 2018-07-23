package com.lfxfs.tools.pattern.proxy;


import org.junit.Test;

import java.lang.reflect.Proxy;

public class RedisCacheInvocationHandlerTest {

    @Test
    public void testRedisCacheInvocationHandler(){
        ICache cacheProxy= (ICache) Proxy.newProxyInstance(ClassLoader.getSystemClassLoader()
                ,new Class[]{ICache.class}
                ,new CacheInvocationHandler(new RedisCache()));
        cacheProxy.get("111");
        cacheProxy.put("222","234234");
    }
}
