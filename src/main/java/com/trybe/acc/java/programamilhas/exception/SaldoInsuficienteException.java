package com.trybe.acc.java.programamilhas.exception;

/**Classe SaldoInsuficienteException.*/
public class SaldoInsuficienteException extends Exception {

  private static final long serialVersionUID = 1L;

  public SaldoInsuficienteException() {
    super("Saldo insuficiente.");
  }

}
