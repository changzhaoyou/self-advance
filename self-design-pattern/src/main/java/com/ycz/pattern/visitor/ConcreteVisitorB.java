package com.ycz.pattern.visitor;

/**
 * 具体访问者实现
 *
 * @author ycz
 * @version 1.0
 * @date 2020/6/9 17:40
 * @desc
 */
public class ConcreteVisitorB implements Visitor {

    @Override
    public void visitorElementA(ElementA elementA) {
        System.out.println("具体访问者实现B");
        if (elementA.getAge() < 18) {
            System.out.println(elementA.getName() + ",未成年");
        } else {
            System.out.println(elementA.getName() + ",已经成人");
        }
    }

    @Override
    public void visitorElementB(ElementB elementB) {
        System.out.println("具体访问者实现B");
        if (elementB.getAge() < 18) {
            System.out.println(elementB.getName() + ",未成年");
        } else {
            System.out.println(elementB.getName() + ",已经成人");
        }
    }
}
