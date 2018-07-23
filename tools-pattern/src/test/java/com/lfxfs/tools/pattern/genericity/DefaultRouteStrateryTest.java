package com.lfxfs.tools.pattern.genericity;

import com.lfxfs.tools.pattern.adapter.AudioPlay;
import com.lfxfs.tools.pattern.observer.Subject;
import org.junit.Test;


public class DefaultRouteStrateryTest {

    @Test
    public  void testRouteStratey() {
        AbstractRouteStratery routeStratery = new DefaultRouteStratery(Subject.class);
        Subject s = (Subject) routeStratery.lookup();
        System.out.println(s);
    }



}
