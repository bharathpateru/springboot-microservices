package com.bharath.microservices.currency_exchange.controller;

import com.bharath.microservices.currency_exchange.model.CurrencyExchange;
import com.bharath.microservices.currency_exchange.service.CurrencyExchangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyExchangeController {

    @Autowired
    CurrencyExchangeService service;

    @Autowired
    Environment environment;

    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public ResponseEntity<CurrencyExchange> retrieveExchangeValue(@PathVariable String from, @PathVariable String to){
        CurrencyExchange currencyExchange = service.retriveExchangeValue(from,to);
        currencyExchange.setEnvironment(environment.getProperty("local.server.port"));
        return new ResponseEntity<>(currencyExchange, HttpStatus.OK);
    }

}
