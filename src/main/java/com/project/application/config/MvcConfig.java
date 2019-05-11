package com.project.application.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/home").setViewName("home");
        registry.addViewController("/").setViewName("home");
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/manage").setViewName("manage");
        registry.addViewController("/edit").setViewName("edit");
        registry.addViewController("/detail").setViewName("detail");
        registry.addViewController("/applylist").setViewName("applylist");
        registry.addViewController("/apply").setViewName("apply");

    }

}