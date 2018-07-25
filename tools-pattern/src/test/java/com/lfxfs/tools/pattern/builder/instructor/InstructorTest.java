package com.lfxfs.tools.pattern.builder.instructor;

import com.lfxfs.tools.pattern.builder.buider.AbsBuilder;
import com.lfxfs.tools.pattern.builder.buider.Builder3d;
import com.lfxfs.tools.pattern.builder.buider.Builder4d;
import com.lfxfs.tools.pattern.builder.buider.BuilderSelf;
import org.junit.Test;

import static org.junit.Assert.*;

public class InstructorTest {

    @Test
    public void testBuilder(){
        AbsBuilder builder = new Builder3d("2018-09-25");
        Instructor instructor = new Instructor(builder);
        instructor.construct();
        instructor.getVacation();

        instructor.setBuilder(new Builder4d("2018-08-25"));
        instructor.construct();
        instructor.getVacation();
    }

    @Test
    public void testBuilderSelf(){
        BuilderSelf builder = new BuilderSelf("2018-07-25");
        builder.addHotal("四季酒店")
        .addTicket("机票")
        .addEnvent("坐飞机")
        .addTicket("房卡")
        .addEnvent("住酒店")
        .addTicket("四季酒店")
        .addEnvent("吃完饭");

        builder.addDay()
        .addHotal("如家")
        .addTicket("迪斯尼门票")
        .addEnvent("游玩迪斯尼")
        .addTicket("上海铁塔通票")
        .addEnvent("游玩铁塔");

        builder.addDay()
        .addHotal("豪泰")
        .addTicket("苏州园林门票")
        .addEnvent("游玩苏州园林")

        .addDay()
        .addHotal("")
        .addTicket("机票")
        .addEnvent("城市游玩")
        .addEnvent("坐飞机");

        builder.showVacation();
    }


}