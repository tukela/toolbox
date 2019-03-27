package com.hl.kit.config.Listener;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.context.event.ApplicationStartingEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @author: honglei
 * @Date: 2019/3/26 17:34
 * @Version: 1.0
 * @See:
 * @Description:
 */
@Component
public class AppStartingListener implements ApplicationListener<ApplicationStartingEvent> {

@Override
public void onApplicationEvent(ApplicationStartingEvent applicationStartingEvent) {
        SpringApplication application = applicationStartingEvent.getSpringApplication();
        application.setBannerMode(Banner.Mode.LOG);
        System.out.println("--------- 执行AppStartingListener----------");
        }
}
