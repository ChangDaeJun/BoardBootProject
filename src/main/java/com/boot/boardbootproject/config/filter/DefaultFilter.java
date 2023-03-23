package com.boot.boardbootproject.config.filter;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.HiddenHttpMethodFilter;

@Component
public class DefaultFilter {
    @Bean
    public FilterRegistrationBean filterRegistrationBean(){
        FilterRegistrationBean filter = new FilterRegistrationBean();
        filter.setFilter(new HiddenHttpMethodFilter());
        filter.setName("filterRegistrationBean");
        filter.addUrlPatterns("/*");
        return filter;
    }
}
