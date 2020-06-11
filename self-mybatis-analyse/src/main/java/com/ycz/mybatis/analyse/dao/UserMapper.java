package com.ycz.mybatis.analyse.dao;

import com.ycz.mybatis.analyse.domain.User;

public interface UserMapper {
    /**
     * 用户ID查询
     *
     * @param id
     * @return
     */
    User queryById(Integer id);

    /**
     * 插入用户数据
     *
     * @param user
     * @return
     */
    int insert(User user);
}
