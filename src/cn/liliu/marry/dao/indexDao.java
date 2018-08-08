package cn.liliu.marry.dao;


import cn.liliu.marry.entity.User;

import java.util.List;

public interface indexDao {

    //插入用户表
    boolean insertUserInfo(User user);

    //查询用户匹配
    List<User> findUserInfo(User user);
}
