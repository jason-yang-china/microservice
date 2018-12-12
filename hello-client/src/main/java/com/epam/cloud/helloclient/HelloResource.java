package com.epam.cloud.helloclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/hello/client")
public class HelloResource {
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping
    public String hello() {
        String url = "http://hello-server/hello/server";
        return restTemplate.getForObject(url, String.class);
    }

    @LoadBalanced
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

}
