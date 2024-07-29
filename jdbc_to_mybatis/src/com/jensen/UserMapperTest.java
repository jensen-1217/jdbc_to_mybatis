package com.jensen;

import cn.itcast.config.SqlSession;

import java.util.List;

public class UserMapperTest {
    public static void main(String[] args) {
        SqlSession sqlSession = new SqlSession();

        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        List list = userMapper.queryAllUser();

        for (Object user : list) {
            System.out.println(user);
        }
    }
}
