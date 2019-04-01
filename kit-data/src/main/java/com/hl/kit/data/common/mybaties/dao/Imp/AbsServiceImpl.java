package com.hl.kit.data.common.mybaties.dao.Imp;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.hl.kit.data.common.mybaties.mapper.MyBaseMapper;
import com.hl.kit.data.common.mybaties.dao.MyBaseService;

/**
 * @author: honglei
 * @Date: 2019/4/1 15:33
 * @Version: 1.0
 * @See:
 * @Description:
 */
public abstract class AbsServiceImpl <M extends MyBaseMapper<T>, T> extends ServiceImpl<M,T> implements MyBaseService<T> {

}
