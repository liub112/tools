package com.lfxfs.tools.pattern.genericity;

import com.lfxfs.tools.pattern.singleton.Singleton;

public abstract class AbstractRouteStratery<T> implements IRouteStratery<T> {
    private Class<T> clz;

    public AbstractRouteStratery(Class<T> clz) {
        this.clz = clz;
    }

    public Class<T> getClz() {
        return clz;
    }

    public void setClz(Class<T> clz) {
        this.clz = clz;
    }
}
