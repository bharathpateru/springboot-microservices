package com.bharath.microservices.currency_exchange.repo;

import com.bharath.microservices.currency_exchange.model.CurrencyExchange;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface CurrencyExchangeRepository extends JpaRepository<CurrencyExchange, Long> {

  CurrencyExchange findByCurrencyFromAndCurrencyTo(String from, String to);
}
