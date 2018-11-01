package org.superbiz.struts;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.web.filter.RequestContextFilter;

@SpringBootApplication
public class Application {

    public static void main(String... args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public FilterRegistrationBean struts2FilterRegistrationBean() {
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.setFilter(new org.apache.struts2.dispatcher.FilterDispatcher());
        registrationBean.addUrlPatterns("/*");
        registrationBean.addInitParameter("actionPackages", "com.lq");
        registrationBean.setName("struts2");
        registrationBean.setOrder(0);
        return registrationBean;
    }

    @Bean
    public FilterRegistrationBean strutsCleanUpFilterRegistrationBean() {
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.setFilter(new org.apache.struts2.dispatcher.ActionContextCleanUp());
        registrationBean.addUrlPatterns("/*");
        registrationBean.setName("struts-cleanup");
        registrationBean.setOrder(1);
        return registrationBean;
    }

    @Bean
    public FilterRegistrationBean sitemeshFilterRegistationBean() {
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.setFilter(new com.opensymphony.module.sitemesh.filter.PageFilter());
        registrationBean.addUrlPatterns("/*");
        registrationBean.setName("sitemesh");
        registrationBean.setOrder(2);
        return registrationBean;
    }
}
