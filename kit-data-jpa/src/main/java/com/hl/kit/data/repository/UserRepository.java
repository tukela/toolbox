package com.hl.kit.data.repository;


import com.hl.kit.data.MyRepository;
import com.hl.kit.data.model.T_user;
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
