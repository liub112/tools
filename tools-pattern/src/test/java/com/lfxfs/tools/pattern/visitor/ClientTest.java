package com.lfxfs.tools.pattern.visitor;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ClientTest {
    @Test
    public void testClient(){
        List<ConcreteElement> concreteElementList = new ArrayList<>();
        concreteElementList.add(new ConcreteElement("Summmer",2320f,4));
        concreteElementList.add(new ConcreteElement("Allen", 5220f,2));
        concreteElementList.add(new ConcreteElement("Kitter",4320f,3));
        concreteElementList.add(new ConcreteElement("Blanec",13320f,1));

        Client client = new Client(concreteElementList);
        System.out.println("员工工资:");
        client.getConcreteElement();
        //年终奖计划
        System.out.println("年终奖计划:");
        Visitor visitor = new ConcreteVisitor();
        client.getConcreteElementYear(visitor);

        System.out.println("月度奖金计划:");
        Visitor visitor1 = new MonthlyBonusVisitor();
        client.getConcreteElementYear(visitor1);

    }

}