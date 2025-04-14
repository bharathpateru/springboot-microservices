package com.bharath.microservices.circuit_breaker.controller;

import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class MyController {

    private Logger log = LoggerFactory.getLogger(getClass());
    @GetMapping("sample-api")
    //@Retry(name = "sample-api", fallbackMethod = "onFailureExecutethisMethod")
    //@CircuitBreaker(name = "sample-api", fallbackMethod = "onFailureExecutethisMethod")
    //@RateLimiter(name = "default", fallbackMethod = "onFailureExecutethisMethod")
    @Bulkhead(name = "sample-api", fallbackMethod = "onFailureExecutethisMethod")
    public String sampleAPI(){
        log.info("Sample API call received");
        //ResponseEntity<String> stringResponseEntity = new RestTemplate().getForEntity("http://localhost:8080/some-dummy-url", String.class);
        return "stringResponseEntity.getBody()";
    }

    public String onFailureExecutethisMethod(Exception ex){
        return "Service is down currently";
    }

}
