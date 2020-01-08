package com.project.coffee.config;

import com.project.coffee.service.MemberService;
import com.project.coffee.service.PaymentService;
import com.project.coffee.service.impl.MemberServiceImpl;
import com.project.coffee.service.impl.PaymentServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {
    @Bean
    public MemberService memberService() {
        return new MemberServiceImpl();
    }

    @Bean
    PaymentService paymentService() {
        return new PaymentServiceImpl();
    }
}
