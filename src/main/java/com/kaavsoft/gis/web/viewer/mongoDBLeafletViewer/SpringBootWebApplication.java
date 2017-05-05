package com.kaavsoft.gis.web.viewer.mongoDBLeafletViewer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication
public class SpringBootWebApplication extends SpringBootServletInitializer {

	/** Application main function */
    public static void main(String[] args) {
        SpringApplication.run(SpringBootWebApplication.class, args);
    }
    
    /** Spring Boot configuration */
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(SpringBootWebApplication.class);
    }
    
}