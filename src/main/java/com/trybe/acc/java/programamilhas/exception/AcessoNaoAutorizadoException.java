package com.trybe.acc.java.programamilhas.exception;

/**Classe AcessoNaoAutorizadoException.*/
public class AcessoNaoAutorizadoException extends Exception {

  private static final long serialVersionUID = 1L;

  public AcessoNaoAutorizadoException() {
    super("Acesso não autorizado.");
  }

}
