package com.lfxfs.tools.pattern.builder.buider;

import com.lfxfs.tools.pattern.builder.vacation.Vacation;
import com.lfxfs.tools.pattern.builder.vacation.VacationDay;

import java.util.List;

public abstract class AbsBuilder {
    private Vacation mVacation;

    public AbsBuilder(Vacation mVacation) {
        this.mVacation = mVacation;
    }

    protected void addDay(){
        mVacation.addDay();
    }

    protected void addHotal(String hotal) {
        mVacation.addHotal(hotal);
    }

    protected void addTicket(String ticket) {
        mVacation.addTicket(ticket);
    }

    protected void addEnvent(String envent) {
        mVacation.addEnvent(envent);
    }

    public abstract void buildVacation();

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
