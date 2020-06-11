package com.ycz.pattern.visitor;

/**
 * @author ycz
 * @version 1.0
 * @date 2020/6/9 17:35
 * @desc
 */
public interface Visitor {
    /**
     * @param elementA
     */
    void visitorElementA(ElementA elementA);

    /**
     * @param elementB
     */
    void visitorElementB(ElementB elementB);
}
