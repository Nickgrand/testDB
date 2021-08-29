package com.qyf.pojo.dao;

import com.qyf.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("userDao")
public class userDaoImpl implements userDao {

    //使用配置文件中的jdbc模板
    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * 更新方法
     *
     * @param sql
     * @param param
     * @return
     */
    public int update(String sql, Object[] param) {
        return jdbcTemplate.update(sql, param);
    }

    /**
     * 查询方法
     *
     * @param sql
     * @param param
     * @return
     */
    public List<User> query(String sql, Object[] param) {
        RowMapper<User> rowMapper = new BeanPropertyRowMapper<>(User.class);

        return jdbcTemplate.query(sql, rowMapper, param);
    }
}