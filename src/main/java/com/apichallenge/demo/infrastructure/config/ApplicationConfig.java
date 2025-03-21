package com.apichallenge.demo.infrastructure.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({ ControllerConfig.class, RepositoryConfig.class, ServiceConfig.class })
public class ApplicationConfig {
}
