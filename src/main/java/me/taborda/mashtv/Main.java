package me.taborda.mashtv ;

import org.springframework.boot.SpringApplication ;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration ;
import org.springframework.context.annotation.ComponentScan ;
import org.springframework.context.annotation.Configuration ;

@ComponentScan
@Configuration
@EnableAutoConfiguration
public class Main {

    public static void main(final String[] args) throws Exception {
        SpringApplication.run(Main.class, args) ;
    }
}