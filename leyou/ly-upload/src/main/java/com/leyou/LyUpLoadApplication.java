package com.leyou;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class LyUpLoadApplication {
    public static void main(String[] args) {
        SpringApplication.run(LyUpLoadApplication.class,args);
    }
}
