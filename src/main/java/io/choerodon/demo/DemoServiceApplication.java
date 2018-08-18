package io.choerodon.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

import io.choerodon.resource.annoation.EnableChoerodonResourceServer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableEurekaClient
@EnableChoerodonResourceServer
@RestController
@ConfigurationProperties(prefix = "person")
public class DemoServiceApplication {
    public static void main(String[] args){
        SpringApplication.run(DemoServiceApplication.class, args);
    }

    @Value("${person.name}")
    private String name;

    @Value("${person.employeeNo}")
    private String employeeNo;

    @GetMapping("/hello")
    public String hello() {
        return "hello , "+name+" , "+employeeNo;
    }
}

