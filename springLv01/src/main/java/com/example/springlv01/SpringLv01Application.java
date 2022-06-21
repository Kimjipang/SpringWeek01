package com.example.springlv01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing  // 없으면 Timestamped 안됨.
@SpringBootApplication
public class SpringLv01Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringLv01Application.class, args);
    }

}
