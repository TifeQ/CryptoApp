package com.example.andriod.crptoapp;

/**
 * Created by Boluwatife on 10/31/2017.
 */




public class CurrencyList {
    private String Country,Currency, countryCode;

    public CurrencyList(String country, String countryCode, String currency) {
        Country = country;
        Currency = currency;
        this.countryCode = countryCode;
    }

    public String getCountry() {
        return Country;
    }

    public String getCurrency() {
        return Currency;
    }

    public String getCountryCode() {
        return countryCode;
    }
}

