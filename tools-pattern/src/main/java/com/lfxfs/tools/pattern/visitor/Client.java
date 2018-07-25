package com.lfxfs.tools.pattern.visitor;

import java.util.List;

public class Client {
    List<ConcreteElement> concreteElementList;

    public Client(List<ConcreteElement> concreteElementList) {
        this.concreteElementList = concreteElementList;
    }

    public void getConcreteElement(){
        for (int i = 0; i < concreteElementList.size(); i++) {
            System.out.println("name:"+concreteElementList.get(i).getName()+",momey:"+concreteElementList.get(i).getMomey());
        }
    }

    /**
     * 福利计划
     */
    public void getConcreteElementYear(Visitor visitor){
        for (int i = 0; i < concreteElementList.size(); i++) {
            concreteElementList.get(i).accept(visitor);
        }
    }
}
