package com.codurance;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class MoneyTest {
    @Test
    void convert_EURO_TO_DOLLAR() {
        final Money moneyInEuros = Money.valueOf(
                new BigDecimal("67.89"),
                "EUR");

        final Money moneyInDollar = moneyInEuros
                .multiply(new BigDecimal("1.454706142288997"));
        assertEquals(new BigDecimal("98.76"),
                moneyInDollar.getAmount());
    }

    @Test
    void convert_DOLLAR_TO_EURO() {
        final Money moneyInDollar = Money.valueOf(
                new BigDecimal("98.76"),
                "USD"
        );
        final Money moneyInEuros = moneyInDollar
                .multiply(new BigDecimal("0.6874240583232078"));
        assertEquals(new BigDecimal("67.89"),
                moneyInEuros.getAmount());
    }
}