package com.hl.kit.data.common.jpa.repository;

import com.hl.kit.data.common.jpa.model.T_user;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author: honglei
 * @Date: 2018/9/29 09:58
 * @Version: 1.0
 * @See:
 * @Description:
 */
public interface  UserRepository extends JpaRepository<T_user, Integer>{

}
