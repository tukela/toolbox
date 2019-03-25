package com.hl.kit.data.jpa.repository;


import com.hl.kit.data.repository.MyRepository;
import com.hl.kit.data.entity.T_user;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author: honglei
 * @Date: 2018/9/29 09:58
 * @Version: 1.0
 * @See:
 * @Description:
 */
public interface  UserRepository extends JpaRepository<T_user, Integer>,MyRepository{

}