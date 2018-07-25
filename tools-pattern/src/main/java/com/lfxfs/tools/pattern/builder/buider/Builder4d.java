package com.lfxfs.tools.pattern.builder.buider;

import com.lfxfs.tools.pattern.builder.vacation.Vacation;

public class Builder4d extends AbsBuilder{
    public Builder4d(String stDate) {
        super(new Vacation(stDate));
    }


    @Override
    public void buildVacation() {
        addHotal("四季酒店");
        addTicket("机票");
        addEnvent("坐飞机");
        addTicket("房卡");
        addEnvent("住酒店");
        addTicket("四季酒店");
        addEnvent("吃完饭");

        addDay();
        addHotal("如家");
        addTicket("迪斯尼门票");
        addEnvent("游玩迪斯尼");
        addTicket("上海铁塔通票");
        addEnvent("游玩铁塔");

        addDay();
        addHotal("豪泰");
        addTicket("苏州园林门票");
        addEnvent("游玩苏州园林");

        addDay();
        addHotal("");
        addTicket("机票");
        addEnvent("城市游玩");
        addEnvent("坐飞机");
    }
}

