package com.ycz.pattern.flyweight;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * FlyweightFactory（享元工厂类）
 *
 * @author ycz
 * @version 1.0
 * @date 2020/5/23 18:23
 * @desc
 */
public class WebSiteFactory {
    /**
     * 对象池
     */
    private Map<String, WebSite> websiteMap = new ConcurrentHashMap();

    private WebSiteFactory() {
    }

    /**
     * 单例内部类
     */
    private static class inner {
        public static WebSiteFactory getInstance() {
            return new WebSiteFactory();
        }

    }

    public static WebSiteFactory getFactory() {
        return inner.getInstance();
    }

    /**
     * 获取享元池对象
     *
     * @param type
     * @return
     */
    public WebSite getWebSite(String type) {
        if (!websiteMap.isEmpty()) {
            if (websiteMap.containsKey(type)) {
                return websiteMap.get(type);
            }
        }
        WebSite webSite = new ConcreteWebSite(type);
        websiteMap.put(type, webSite);
        return webSite;
    }
}
