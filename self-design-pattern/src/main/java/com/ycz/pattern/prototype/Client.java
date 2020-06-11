package com.ycz.pattern.prototype;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 测试示例
 */
public class Client {

    public static void main(String[] args) {
        HashMap<String, String> originHashMap = new HashMap<>();
        originHashMap.put("1", "1");
        System.out.println("源对象：" + originHashMap.get("1"));
        HashMap<String, String> sourceHashMap = (HashMap<String, String>) originHashMap.clone();
        sourceHashMap.put("1", "2");
        System.out.println("originHashMap==sourceHashMap:"+(originHashMap==sourceHashMap));
        System.out.println("复制后对象：" + sourceHashMap.get("1"));
        System.out.println("源对象内容：" + originHashMap.get("1"));
        System.out.println("originHashMap==sourceHashMap:"+(originHashMap==sourceHashMap));

        List<String> originList = new ArrayList<String>();
        originList.add("1");
        System.out.println("源对象list:" + originList.get(0));
        List<String> targetList = (ArrayList<String>) ((ArrayList<String>) originList).clone();
        targetList.set(0, "2");
        System.out.println("originList==targetList:"+(originList==targetList));
        System.out.println("复制后对象list:" + targetList.get(0));
        System.out.println("源对象list:" + originList.get(0));
        System.out.println("originList==targetList:"+(originList==targetList));

        System.out.println();
    }
}
