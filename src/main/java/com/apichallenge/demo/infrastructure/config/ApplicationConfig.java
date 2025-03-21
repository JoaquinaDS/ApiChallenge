package com.apichallenge.demo.infrastructure.config;

import com.apichallenge.demo.application.exceptions.CustomResponseEntityExceptionHandler;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({ RepositoryConfig.class, ServiceConfig.class, CustomResponseEntityExceptionHandler.class })
public class ApplicationConfig {
}