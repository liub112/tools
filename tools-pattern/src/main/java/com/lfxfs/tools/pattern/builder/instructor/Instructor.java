package com.lfxfs.tools.pattern.builder.instructor;

import com.lfxfs.tools.pattern.builder.buider.AbsBuilder;

public class Instructor {
    private AbsBuilder builder;

    public Instructor(AbsBuilder builder) {
        this.builder = builder;
    }

    public void setBuilder(AbsBuilder builder) {
        this.builder = builder;
    }

    public void construct(){
        builder.buildVacation();
    }

    public void getVacation(){
        builder.showVacation();
    }
}
