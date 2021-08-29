package com.qyf.pojo.dao;

import com.qyf.pojo.User;

import java.util.List;

public interface userDao {
    int update(String sql,Object[] param);
    List<User> query(String sql, Object[] param);
}