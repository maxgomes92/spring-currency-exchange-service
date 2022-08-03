package com.in28minutes.microservices.currencyexchangeservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyExchangeController {

    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public CurrencyExchangeResponse getCurrencyExchange (@PathVariable String from, @PathVariable String to) {
        return new CurrencyExchangeResponse(1, from, to, 65, "8000 instance-id");
    }
}
