package com.in28minutes.microservices.currencyexchangeservice;

import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CircuitBreakerController {

    private Logger logger = LoggerFactory.getLogger(CircuitBreakerController.class);

    @GetMapping("/sample-api")
//    @Retry(name = "sample-api", fallbackMethod = "hardcodedResponse")
    @CircuitBreaker(name = "default", fallbackMethod = "hardcodedResponse")
    public String sampleApi () {
        logger.info("Sample Api call received");

        var dummy = new RestTemplate().getForEntity("http://localhost:8080/dummy", String.class);

        return dummy.getBody();
    }

    @GetMapping("/sample-api-limited")
    @CircuitBreaker(name = "default", fallbackMethod = "hardcodedResponse")
    @RateLimiter(name = "default")
    public String sampleApiLimited () {
        logger.info("Sample Api Limited call received");
        return "Sample api limited";
    }

    @GetMapping("/sample-api-bulk")
    @Bulkhead(name = "default")
    public String sampleApiBulk () {
        logger.info("Sample Api Limited call received");
        return "Sample api limited";
    }

    public String hardcodedResponse (Exception ex) {
        return "Fallback response";
    }
}
