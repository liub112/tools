package com.lfxfs.tools.pattern.builder.buider;

import com.lfxfs.tools.pattern.builder.vacation.Vacation;
import com.lfxfs.tools.pattern.builder.vacation.VacationDay;

import java.util.List;

public class BuilderSelf {
    private Vacation mVacation;


    public BuilderSelf(String stDate) {
        this.mVacation = new Vacation(stDate);
    }


    public BuilderSelf addDay(){
        mVacation.addDay();
        return this;

    }

    public BuilderSelf addHotal(String hotal) {
        mVacation.addHotal(hotal);
        return this;

    }

    public BuilderSelf addTicket(String ticket) {
        mVacation.addTicket(ticket);
        return this;
    }
    public BuilderSelf addEnvent(String envent) {
        mVacation.addEnvent(envent);
        return this;
    }


    public void showVacation(){
        System.out.println("开始时间："+mVacation.getStDate());
        List<VacationDay> vacationDays = mVacation.getVacationDays();
        for (int i = 0; i < vacationDays.size(); i++) {
            System.out.println("第"+(i+1)+"天");
            vacationDays.get(i).showVacationDay();
            System.out.println();
        }
    }
}
