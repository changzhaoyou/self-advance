package com.ycz.pattern.chain;

/**
 * 具体处理者
 *
 * @author ycz
 * @version 1.0
 * @date 2020/6/9 11:20
 * @desc
 */
public class HttpFilter implements Filter {

    @Override
    public void doFilter(String type, FilterChain chain) {
        System.out.println("调用HttpFilter处理，type=" + type);
        chain.doChain(type);
    }
}
