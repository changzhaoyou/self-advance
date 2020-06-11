package com.ycz.pattern.chain;

/**
 * 测试类
 *
 * @author ycz
 * @version 1.0
 * @date 2020/6/9 9:58
 * @desc
 */
public class Client {

    public static void main(String[] args) {
        Filter webFilter=new WebFilter();
        Filter httpFilter=new HttpFilter();
        FilterChain filterChain=new FilterChain();
        filterChain.addFilter(httpFilter);
        webFilter.doFilter("hello",filterChain);
    }
}
