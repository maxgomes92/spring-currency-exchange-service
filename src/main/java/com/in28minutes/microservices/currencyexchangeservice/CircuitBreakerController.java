package com.in28minutes.microservices.currencyexchangeservice;

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
    @Retry(name = "sample-api", fallbackMethod = "hardcodedResponse")
    public String sampleApi () {
        logger.info("Sample Api call received");

        var dummy = new RestTemplate().getForEntity("http://localhost:8080/dummy", String.class);

        return dummy.getBody();
    }

    public String hardcodedResponse (Exception ex) {
        return "Fallback response";
    }
}