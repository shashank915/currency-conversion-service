package com.example.currencyconversionservice.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CurrencyConversionBean {

    private Long id;
    private String fromCurrency;
    private String toCurrency;
    private double rate;
    private double quantity;
    private double totalCalculatedAmount;
    private int port;
}
