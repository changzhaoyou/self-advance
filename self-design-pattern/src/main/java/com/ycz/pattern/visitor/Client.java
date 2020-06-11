package com.ycz.pattern.visitor;

/**
 * @author ycz
 * @version 1.0
 * @date 2020/6/9 17:42
 * @desc
 */
public class Client {

    public static void main(String[] args) {
        Visitor visitorA = new ConcreteVisitorB();
        Element elementA = new ElementA();
        Element elementB = new ElementB();
        ObjectStructure objectStructure = new ObjectStructure();
        objectStructure.addElement(elementA);
        objectStructure.addElement(elementB);
        objectStructure.accept(visitorA);
    }
}
