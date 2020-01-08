package com.project.coffee.config;

import com.project.coffee.service.CategoriesService;
import com.project.coffee.service.ProductService;
import com.project.coffee.service.PromotionService;
import com.project.coffee.service.impl.CategoriesServiceImpl;
import com.project.coffee.service.impl.ProductServiceImpl;
import com.project.coffee.service.impl.PromotionServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {
    @Bean
    public CategoriesService categoriesService(){
        return new CategoriesServiceImpl() ;
    }
    @Bean
    public ProductService productService(){
        return new ProductServiceImpl();
    }
    @Bean
    public PromotionService promotionService(){
        return new PromotionServiceImpl();
    }
}
