package com.lfxfs.tools.pattern.genericity;

import com.lfxfs.tools.pattern.observer.Subject;

public class DefaultRouteStratery extends AbstractRouteStratery<Subject>{

    public DefaultRouteStratery(Class<Subject> clz) {
        super(clz);
    }

    @Override
    public Subject lookup() {
        Subject subject=null;
        try {
            subject= getClz().newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return subject;
    }
}
