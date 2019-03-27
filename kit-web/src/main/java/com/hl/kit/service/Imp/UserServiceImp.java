package com.hl.kit.service.Imp;

import com.hl.kit.data.common.mybaties.repository.UserMapper;
import com.hl.kit.data.entity.User;
import com.hl.kit.data.repository.MyRepository;
import com.hl.kit.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: honglei
 * @Date: 2019/3/27 13:49
 * @Version: 1.0
 * @See:
 * @Description:
 */
@Service
public class UserServiceImp implements UserService{
    @Autowired
    private UserMapper  myRepository;
    @Override
    public User getUser() {
        return myRepository.findOne(1);
    }
}
