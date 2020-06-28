package com.example.bodymanagement.Config;

import com.example.bodymanagement.BodymanagementApplication;
import org.springframework.context.annotation.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;

@Configuration
public class LogConfig  {
    private static final Logger LOG = LoggerFactory.getLogger(LogConfig.class);

    @Bean
    public BodymanagementApplication logMethod() {
        LOG.info("==========print log==========");
        return new BodymanagementApplication();
    }
}
