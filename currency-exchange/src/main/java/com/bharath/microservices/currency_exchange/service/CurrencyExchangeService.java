package com.bharath.microservices.currency_exchange.service;

import com.bharath.microservices.currency_exchange.model.CurrencyExchange;
import com.bharath.microservices.currency_exchange.repo.CurrencyExchangeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CurrencyExchangeService {

    @Autowired
    CurrencyExchangeRepository repository;

    public CurrencyExchange retriveExchangeValue(String from, String to){
        return repository.findByCurrencyFromAndCurrencyTo(from, to);
    }

}
