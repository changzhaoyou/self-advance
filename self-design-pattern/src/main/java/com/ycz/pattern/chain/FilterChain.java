package com.ycz.pattern.chain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 责任链集合
 *
 * @author ycz
 * @version 1.0
 * @date 2020/6/9 10:29
 * @desc
 */
public class FilterChain {
    /**
     * Filter集合
     */
    private List<Filter> filters = new ArrayList<>();
    /**
     * 下一个调用链
     */
    private Iterator<Filter> nextIterator;

    /**
     * 添加调用链
     *
     * @param filter
     * @return
     */
    public boolean addFilter(Filter filter) {
        return filters.add(filter);
    }

    /**
     * 调用下个链
     *
     * @param type
     */
    public void doChain(String type) {
        if (this.nextIterator == null) {
            this.nextIterator = this.filters.iterator();
        }
        if (this.nextIterator.hasNext()) {
            Filter filter = this.nextIterator.next();
            filter.doFilter(type, this);
        }
    }
}
