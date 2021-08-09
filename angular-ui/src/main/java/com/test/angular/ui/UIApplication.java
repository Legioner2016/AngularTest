package com.test.angular.ui;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * Simple springboot web application to start angular ui 
 * (static html with embeded angular builded script - angular "out of the box" needed 
 * several builds for every language) 
 * 
 * By the way - i am thinking now - why tomcat, not node or pure apache?
 * (spring boot automatics) 
 * 
 * @author legioner
 *
 */
@SpringBootApplication
public class UIApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(UIApplication.class);
    }

	public static void main(String[] args) {
		SpringApplication.run(UIApplication.class, args);
	}

	
}



