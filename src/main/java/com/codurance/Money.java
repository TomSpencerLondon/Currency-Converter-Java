package com.codurance;
import java.math.BigDecimal;
import java.math.RoundingMode;

import static java.math.RoundingMode.HALF_EVEN;

public class Money {
  private static final String DOLLAR = "USD";
  private static final String EURO = "EUR";
  private static RoundingMode ROUNDING_MODE = HALF_EVEN;
  private static int DECIMALS = 2;
  private BigDecimal amount;
  private String currency;

  public Money(){}

  public static Money valueOf(BigDecimal amount, String currency){
    return new Money(amount, currency);
  }

  private Money(BigDecimal amount, String currency){
    this.amount = amount;
    this.currency = currency;
  }

  public Money multiply(BigDecimal factor){
    return Money.valueOf(rounded(this.amount.multiply(factor)),
            this.currency.equals(DOLLAR) ? EURO : DOLLAR);
  }

  private BigDecimal rounded(BigDecimal amount){
    return amount.setScale(DECIMALS, ROUNDING_MODE);
  }

  public BigDecimal getAmount(){
    return amount;
  }

  public String getCurrency(){
    return currency;
  }

}
