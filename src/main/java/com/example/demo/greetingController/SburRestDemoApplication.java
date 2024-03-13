package com.example.demo.greetingController;

import com.example.demo.droid.Droid;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@ConfigurationPropertiesScan
public class SburRestDemoApplication {

//    public static void main(String[] args) {
//        SpringApplication.run(SburRestDemoApplication.class, args);
//    }

    @Bean
    @ConfigurationProperties(prefix = "droid")
    Droid createDroid(){
        return new Droid();
    }

}
