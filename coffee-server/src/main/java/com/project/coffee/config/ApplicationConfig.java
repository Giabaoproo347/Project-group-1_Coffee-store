package com.project.coffee.config;

import com.project.coffee.service.OrderDetailService;
import com.project.coffee.service.OrderService;
import com.project.coffee.service.impl.OrderDetailServiceImpl;
import com.project.coffee.service.impl.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {
    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl();
    }
    @Bean
    public OrderDetailService orderDetailService() {
        return new OrderDetailServiceImpl();
    }
}
