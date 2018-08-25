package com.flf.service.impl;

import com.flf.dao.UserMapper;
import com.flf.entity.User;
import com.flf.service.IUserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
public class UserService implements IUserService {

    @Resource
    private UserMapper userDao;

    @Override
    public User getUserById(int userId) {
        return this.userDao.selectByPrimaryKey(userId);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,timeout=36000,rollbackFor=Exception.class)
    public int insertBy() {
        int m = 0;
                User user = new User();
        user.setAge(1);
        user.setPassword("zzzzz1");
        user.setUserName("1zzz11");
        m=m+userDao.insert(user);

//        int k = 2/0;
        User user2 = new User();
        user2.setAge(1);
        user2.setPassword("222222");
        user2.setUserName("2222");
        m=m+userDao.insert(user2);
return m;
    }
}