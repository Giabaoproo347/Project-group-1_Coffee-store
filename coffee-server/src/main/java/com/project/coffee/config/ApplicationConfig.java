package com.project.coffee.config;

import com.project.coffee.service.*;
import com.project.coffee.service.impl.*;
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
    @Bean
    public MemberService memberService() {
        return new MemberServiceImpl();
    }

    @Bean
    public PaymentService paymentService() {
        return new PaymentServiceImpl();
    }

    @Bean
    public CategoriesService categoriesService() {
        return new CategoriesServiceImpl();
    }

    @Bean
    public ProductService productService() {
        return new ProductServiceImpl();
    }

    @Bean
    public PromotionService promotionService() {
        return new PromotionServiceImpl();
    }
}
