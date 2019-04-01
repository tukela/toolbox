package com.hl.kit.modules.sys.controller;

import com.hl.kit.data.modules.sys.entity.SysUser;
import com.hl.kit.data.modules.sys.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @since 2017-07-31
 */
@RestController
public class SysUserController {
    @Autowired
    private SysUserService sysUserService;

    @RequestMapping("/list")
    @ResponseBody
    public Object getAppVersionMessageList(SysUser sysUser,int current, int size){
        List<SysUser> sysUser2=sysUserService.getSysUser(sysUser,current,size);
        return sysUser2;
    }



}
