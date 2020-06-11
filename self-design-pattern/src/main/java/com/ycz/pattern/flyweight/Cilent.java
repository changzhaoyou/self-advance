package com.ycz.pattern.flyweight;

/**
 * 测试
 *
 * @author ycz
 * @version 1.0
 * @date 2020/5/23 18:34
 * @desc
 */
public class Cilent {

    public static void main(String[] args) {
        User user = new User();
        user.setAge(20);
        user.setName("张三");
        WebSiteFactory webSiteFactory = WebSiteFactory.getFactory();
        WebSite news = webSiteFactory.getWebSite("News");
        news.published(user);
        WebSite news1 = webSiteFactory.getWebSite("News");
        news1.published(user);
        System.out.println(news == news1);
        WebSite blog = webSiteFactory.getWebSite("Blog");
        blog.published(user);
    }
}
