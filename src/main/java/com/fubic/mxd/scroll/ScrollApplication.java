package com.fubic.mxd.scroll;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ApplicationContext;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@MapperScan(basePackages = "com.fubic.mxd.scroll.mapper")
public class ScrollApplication {
    public static void main(String[] args) {
        SpringApplication.run(ScrollApplication.class, args);
    }
}
