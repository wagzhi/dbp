package com.wg.dbp;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(scanBasePackages = {"com.wg.dbp"})
@MapperScan("com.wg.dbp.dao")
public class DbpWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(DbpWebApplication.class, args);
    }

}
