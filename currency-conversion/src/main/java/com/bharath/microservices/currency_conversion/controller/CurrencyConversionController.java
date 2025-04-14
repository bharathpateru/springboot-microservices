package com.bharath.microservices.currency_conversion.controller;

import com.bharath.microservices.currency_conversion.dto.CurrencyExchangeProxy;
import com.bharath.microservices.currency_conversion.model.CurrencyConversion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@RestController
public class CurrencyConversionController {

    @Autowired
    CurrencyExchangeProxy proxy;

    @GetMapping("/currency-conversion/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConversion getConversionvalue(
            @PathVariable String from,
            @PathVariable String to,
            @PathVariable BigDecimal quantity
    ){

        Map<String, String> uriTemplateVariables = new HashMap<>();
        uriTemplateVariables.put("from", from);
        uriTemplateVariables.put("to", to);

        ResponseEntity<CurrencyConversion> currencyConversionResponseEntity = new RestTemplate().getForEntity("http://localhost:8000/currency-exchange/from/USD/to/INR", CurrencyConversion.class, uriTemplateVariables);
        CurrencyConversion currencyConversion = currencyConversionResponseEntity.getBody();

        return new CurrencyConversion(currencyConversion.getId(),
                currencyConversion.getCurrencyFrom(),
                currencyConversion.getCurrencyTo(),
                currencyConversion.getConversionMultiple(),
                quantity.multiply(currencyConversion.getConversionMultiple()),
                currencyConversion.getEnvironment()+" "+"RestTemplate "
                );
    }

    @GetMapping("/currency-conversion-feign/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConversion getConversionvalueFeign(
            @PathVariable String from,
            @PathVariable String to,
            @PathVariable BigDecimal quantity
    ){


        CurrencyConversion currencyConversion = proxy.retrieveExchangeValue(from, to).getBody();

        return new CurrencyConversion(currencyConversion.getId(),
                currencyConversion.getCurrencyFrom(),
                currencyConversion.getCurrencyTo(),
                currencyConversion.getConversionMultiple(),
                quantity.multiply(currencyConversion.getConversionMultiple()),
                currencyConversion.getEnvironment()+" "+"FeignClient"
        );
    }

}
