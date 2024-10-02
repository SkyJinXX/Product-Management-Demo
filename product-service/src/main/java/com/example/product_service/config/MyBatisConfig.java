//package com.example.product_service.config;
//
//import com.example.product_service.mapper.ProductMapper;
//import org.apache.ibatis.session.SqlSessionFactory;
//import org.mybatis.spring.mapper.MapperFactoryBean;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class MyBatisConfig {
//
//    @Bean
//    public MapperFactoryBean<ProductMapper> productMapper(SqlSessionFactory sqlSessionFactory) {
//        MapperFactoryBean<ProductMapper> factoryBean = new MapperFactoryBean<>(ProductMapper.class);
//        factoryBean.setSqlSessionFactory(sqlSessionFactory);
//        return factoryBean;
//    }
//}
