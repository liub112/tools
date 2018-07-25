package com.lfxfs.tools.pattern.builder.vacation;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class VacationDay {
    private Date mDate;

    private String hotal;

    private List<String> tickets;

    private List<String> envents;

    public VacationDay(Date mDate) {
        this.mDate = mDate;

        this.tickets = new ArrayList<>();
        this.envents = new ArrayList<>();
    }

    public Date getmDate() {
        return mDate;
    }

    public void setmDate(Date mDate) {
        this.mDate = mDate;
    }

    public String getHotal() {
        return hotal;
    }

    public void setHotal(String hotal) {
        this.hotal = hotal;
    }

    public void addTicket(String ticket) {
        this.tickets.add(ticket);
    }

    public void addEnvent(String envent) {
        this.envents.add(envent);
    }

    public void showVacationDay(){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println("*** 时间:"+simpleDateFormat.format(this.mDate)+"");
        System.out.println("*** 酒店:"+hotal+"");
        System.out.println("*** tickets:"+tickets.toString()+"");
        System.out.println("*** envents:"+envents.toString()+"");
    }
}
