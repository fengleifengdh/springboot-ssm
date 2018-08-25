package com.flf.dao;


import com.flf.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

//@Mapper     //声明是一个Mapper,与springbootApplication中的@MapperScan二选一写上即可
@Repository
public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    List<User> getUseByAge(int age);
}