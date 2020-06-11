package com.ycz.pattern.facade;

/**
 * 统一外观接口实现
 *
 * @author ycz
 * @version 1.0
 * @date 2020/5/13 22:37
 * @desc
 */
public class FadeImpl implements Facade {
    /**
     * 子系统A （最好使用接口类或者抽象类便于后续扩展）
     */
    private SystemA systemA;
    /**
     * 子系统B （最好使用接口类或者抽象类便于后续扩展）
     */
    private SystemB systemB;

    public FadeImpl(SystemA systemA, SystemB systemB) {
        this.systemA = systemA;
        this.systemB = systemB;
    }

    @Override
    public void request() {
        systemA.requestA();
        systemB.requestB();
    }
}
