package com.jensen;

import cn.itcast.anno.ResultType;
import cn.itcast.anno.Select;

import java.util.List;

public interface UserMapper {

    @Select("select id, name, birthday,sex ,address from tb_user")//SQL语句
    @ResultType("com.jensen.User")//POJO类
    public abstract List queryAllUser();


}
