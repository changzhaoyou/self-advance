package com.ycz.pattern.chain;

/**
 * 具体请求执行者
 * @author ycz
 * @version 1.0
 * @date 2020/6/9 10:30
 * @desc
 */
public class WebFilter implements Filter {

    @Override
    public void doFilter(String type, FilterChain chain) {
        System.out.println("调用webFilter链处理，type=" + type);
        chain.doChain(type);
    }
}
