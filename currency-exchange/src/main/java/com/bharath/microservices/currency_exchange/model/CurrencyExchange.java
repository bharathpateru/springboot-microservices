package com.bharath.microservices.currency_exchange.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.math.BigDecimal;

@Entity
public class CurrencyExchange {
    @Id
    private Long id;
    @Column
    private String currencyFrom;
    @Column
    private String currencyTo;
    @Column
    private BigDecimal conversionMultiple;

    private String environment;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCurrencyFrom() {
        return currencyFrom;
    }

    public void setCurrencyFrom(String currencyFrom) {
        this.currencyFrom = currencyFrom;
    }

    public String getCurrencyTo() {
        return currencyTo;
    }

    public void setCurrencyTo(String currencyTo) {
        this.currencyTo = currencyTo;
    }

    public BigDecimal getConversionMultiple() {
        return conversionMultiple;
    }

    public void setConversionMultiple(BigDecimal conversionMultiple) {
        this.conversionMultiple = conversionMultiple;
    }

    public String getEnvironment() {
        return environment;
    }

    public void setEnvironment(String environment) {
        this.environment = environment;
    }

    public CurrencyExchange(){

    }

    public CurrencyExchange(Long id, String currencyFrom, String currencyTo, BigDecimal conversionMultiple, String environment) {
        this.id = id;
        this.currencyFrom = currencyFrom;
        this.currencyTo = currencyTo;
        this.conversionMultiple = conversionMultiple;
        this.environment = environment;
    }

    @Override
    public String toString() {
        return "CurrencyExchange{" +
                "id=" + id +
                ", currencyFrom='" + currencyFrom + '\'' +
                ", currencyTo='" + currencyTo + '\'' +
                ", conversionMultiple=" + conversionMultiple +
                ", environment='" + environment + '\'' +
                '}';
    }
}
