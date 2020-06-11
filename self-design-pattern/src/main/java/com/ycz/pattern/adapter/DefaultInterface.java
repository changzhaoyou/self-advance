package com.ycz.pattern.adapter;

/**
 * 缺省适配器
 *
 * @author ycz
 * @version 1.0
 * @date 2020/5/12 22:02
 * @desc
 */
abstract class DefaultInterface implements ServiceInterface {

    @Override
    public void request() {
        //可以空实现或者自定义异常类
    }
}
