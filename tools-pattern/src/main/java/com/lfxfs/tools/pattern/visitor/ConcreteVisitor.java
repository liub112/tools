package com.lfxfs.tools.pattern.visitor;

public class ConcreteVisitor implements Visitor{
    @Override
    public void visit(Element element) {
        ConcreteElement concreteElement = (ConcreteElement) element;
        float rate = 0;
        switch (concreteElement.getLevel().intValue()){
            case 1:
                rate= 2.3f;
                break;
            case 2:
                rate= 1.2f;
                break;
            case 3:
                rate= 0.85f;
                break;
            default:
                rate=0.5f;
                break;
        }
        float momey = concreteElement.getMomey()*rate;
        System.out.println("name:"+concreteElement.getName()+",momey:"+String.format("%1.2f", momey));
    }
}
