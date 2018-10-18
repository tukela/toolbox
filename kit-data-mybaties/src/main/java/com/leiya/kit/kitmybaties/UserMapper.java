package com.leiya.kit.kitmybaties;

import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author: honglei
 * @Date: 2018/9/29 11:21
 * @Version: 1.0
 * @See:
 * @Description:
 */
@Mapper
public interface UserMapper {
    @Select("SELECT * FROM t_user")
    List<User> findAll();

    @Insert("INSERT INTO user(userName,password,authority,phone) VALUES (#{userName},#{password},#{authority},#{phone})")
    @Results({ @Result(column = "user_name",property = "userName") })
    void addOne(User user);
    @Update("UPDATE user SET userName=#{userName},password=#{password},authority=#{authority},phone=#{phone} where id=#{id}")
    @Results({ @Result(column = "user_name",property = "userName") })
    void update(User user); @Select("SELECT * FROM user WHERE id=#{id}")
    User findOne(int id);
    @Delete("DELETE FROM user WHERE id=#{id}")
    void delOne(int id);


}
