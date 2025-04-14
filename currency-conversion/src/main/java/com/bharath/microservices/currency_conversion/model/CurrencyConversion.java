package com.bharath.microservices.currency_conversion.model;

import java.math.BigDecimal;

public class CurrencyConversion {

    private Long id;
    private String currencyFrom;
    private String currencyTo;
    private BigDecimal conversionMultiple;
    private BigDecimal quantity;
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

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public String getEnvironment() {
        return environment;
    }

    public void setEnvironment(String environment) {
        this.environment = environment;
    }

    public CurrencyConversion(){

    }

    public CurrencyConversion(Long id, String currencyFrom, String currencyTo, BigDecimal conversionMultiple, BigDecimal quantity, String environment) {
        this.id = id;
        this.currencyFrom = currencyFrom;
        this.currencyTo = currencyTo;
        this.conversionMultiple = conversionMultiple;
        this.quantity = quantity;
        this.environment = environment;
    }

    @Override
    public String toString() {
        return "CurrencyConversion{" +
                "id=" + id +
                ", currencyFrom='" + currencyFrom + '\'' +
                ", currencyTo='" + currencyTo + '\'' +
                ", conversionMultiple=" + conversionMultiple +
                ", quantity=" + quantity +
                ", environment='" + environment + '\'' +
                '}';
    }
}
