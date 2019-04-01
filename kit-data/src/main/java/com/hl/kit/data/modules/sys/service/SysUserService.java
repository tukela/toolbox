package com.hl.kit.data.modules.sys.service;

import com.hl.kit.data.common.mybaties.dao.MyBaseService;
import com.hl.kit.data.modules.sys.entity.SysUser;

import java.util.List;

/**
 * @author: honglei
 * @Date: 2019/4/1 15:30
 * @Version: 1.0
 * @See:
 * @Description:
 */
public interface SysUserService extends MyBaseService<SysUser> {
    List<SysUser> getSysUser(SysUser sysUser, int current, int size);
}
