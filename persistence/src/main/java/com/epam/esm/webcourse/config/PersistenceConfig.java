package com.epam.esm.webcourse.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EntityScan(basePackages = "com.epam.esm.webcourse")
@EnableJpaRepositories(basePackages = "com.epam.esm.webcourse")
public class PersistenceConfig {
}
