package com.ycz.pattern.chain;

/**
 * 等同于类图中Handler抽象类
 *
 * @author ycz
 * @version 1.0
 * @date 2020/6/9 10:28
 * @desc
 */
interface Filter {

    /**
     * 处理请求接口
     * @param type
     * @param filterChain
     */
    void doFilter(String type, FilterChain filterChain);
}
