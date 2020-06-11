package com.ycz.mybatis.analyse.service.impl;

import com.ycz.mybatis.analyse.domain.User;
import com.ycz.mybatis.analyse.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {


    @Override
    public User queryById(Integer id) {
        return null;
    }

    @Override
    public int insert(User user) {
        return 0;
    }
}
