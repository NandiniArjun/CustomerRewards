package com.sky.customer;
//user defined exception
public class TechnicalFailureException extends Exception {
  public TechnicalFailureException(String message) {
        super(message);
    }
}
