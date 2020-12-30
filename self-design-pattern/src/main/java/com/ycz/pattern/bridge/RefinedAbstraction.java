package com.ycz.pattern.bridge;

/**
 * 扩充抽象类
 *
 * @author ycz
 * @version 1.0
 * @date 2020/5/16 17:24
 * @desc
 */
public class RefinedAbstraction extends Abstraction {
    /**
     * 构造函数传递具体实现类
     *
     * @param implementor
     */
    public RefinedAbstraction(Implementor implementor) {
        super(implementor);
    }

    @Override
    public void operation() {
        System.out.println("扩充抽象类");
        implementor.operationImpl();
    }
}
