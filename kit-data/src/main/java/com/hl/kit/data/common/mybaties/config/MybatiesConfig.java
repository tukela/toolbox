package com.hl.kit.data.common.mybaties.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author: honglei
 * @Date: 2019/3/27 14:02
 * @Version: 1.0
 * @See:
 * @Description:
 */
@Configuration
@MapperScan("com.hl.kit.data")
public class MybatiesConfig {
}
