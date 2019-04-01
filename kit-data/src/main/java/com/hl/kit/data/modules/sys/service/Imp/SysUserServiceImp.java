package com.hl.kit.data.modules.sys.service.Imp;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.hl.kit.data.common.mybaties.dao.Imp.AbsServiceImpl;
import com.hl.kit.data.modules.sys.entity.SysUser;
import com.hl.kit.data.modules.sys.mapper.SysUserMapper;
import com.hl.kit.data.modules.sys.service.SysUserService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: honglei
 * @Date: 2019/4/1 15:32
 * @Version: 1.0
 * @See:
 * @Description:
 */
@Service
public class SysUserServiceImp extends AbsServiceImpl<SysUserMapper, SysUser> implements SysUserService {
    @Override
    public List<SysUser> getSysUser(SysUser sysUser, int current, int size) {
        Page<SysUser> page=new Page<>(current,size);
        List<SysUser> list= baseMapper.selectPage(page,new EntityWrapper<SysUser>(sysUser));
        return list;
    }
}
