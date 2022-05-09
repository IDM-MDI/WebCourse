package com.epam.esm.webcourse.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.epam.esm.webcourse")
public class WebCourseApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebCourseApplication.class, args);
    }

}
