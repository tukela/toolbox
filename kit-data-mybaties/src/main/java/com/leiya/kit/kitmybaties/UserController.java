package com.leiya.kit.kitmybaties;

/**
 * @author: honglei
 * @Date: 2018/9/29 11:32
 * @Version: 1.0
 * @See:
 * @Description:
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@EnableTransactionManagement
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @RequestMapping("/all")
    public Object findAll(){
        List<User> userList = userMapper.findAll();
        return userList;
    }


}