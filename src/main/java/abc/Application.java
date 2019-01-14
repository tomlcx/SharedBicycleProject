package com.abc.tyc;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;


//@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
//@MapperScan("com.abc.tyc.mapper")
//@EnableScheduling
@EnableAsync
@MapperScan("com.abc.tyc.mapper")
@SpringBootApplication()
@ComponentScan(basePackages = {"com.abc.*"} )
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
