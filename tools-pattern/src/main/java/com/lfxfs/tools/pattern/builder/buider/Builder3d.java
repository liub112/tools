package com.lfxfs.tools.pattern.builder.buider;

import com.lfxfs.tools.pattern.builder.vacation.Vacation;

public class Builder3d extends AbsBuilder{
    public Builder3d(String stDate) {
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
        addHotal("");
        addTicket("机票");
        addEnvent("城市游玩");
        addEnvent("坐飞机回家");
    }
}
