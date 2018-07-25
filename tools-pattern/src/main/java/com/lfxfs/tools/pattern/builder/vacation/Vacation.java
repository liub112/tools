package com.lfxfs.tools.pattern.builder.vacation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Vacation {
    private String stDate;

    private List<VacationDay> vacationDays;

    private VacationDay mVacationDay=null;

    public Vacation(String stDate) {
        this.stDate = stDate;
        vacationDays = new ArrayList<>();
        vacationDays.add(new VacationDay(nextDate(0)));
        mVacationDay=vacationDays.get(0);
    }

    public String getStDate() {
        return stDate;
    }

    public void setStDate(String stDate) {
        this.stDate = stDate;
    }

    public List<VacationDay> getVacationDays() {
        return vacationDays;
    }

    public void addDay(){
        int n = vacationDays.size();
        mVacationDay = new VacationDay(nextDate(n++));
        vacationDays.add(mVacationDay);
    }

    public void addHotal(String hotal) {
        mVacationDay.setHotal(hotal);
    }

    public void addTicket(String ticket) {
        mVacationDay.addTicket(ticket);
    }

    public void addEnvent(String envent) {
        mVacationDay.addEnvent(envent);
    }


    private Date nextDate(int n){
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = simpleDateFormat.parse(stDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        calendar.setTime(date);
        calendar.add(Calendar.DATE,n);
        return calendar.getTime();
    }

}
