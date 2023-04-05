package com.trybe.acc.java.programamilhas.rest;

import com.trybe.acc.java.programamilhas.exception.AcessoNaoAutorizadoException;
import com.trybe.acc.java.programamilhas.model.Lancamento;
import com.trybe.acc.java.programamilhas.result.SaldoResult;
import com.trybe.acc.java.programamilhas.service.ContaService;
import com.trybe.acc.java.programamilhas.util.TokenUtil;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

/**Classe ContaResources.*/
@Path("/conta")
@ApplicationScoped
public class ContaResources {

  @Inject
  ContaService service;

  @Inject
  TokenUtil tokenUtil;

  @GET
  @Path("/extrato")
  public List<Lancamento> buscaExtrato(@QueryParam("token") String token)
      throws AcessoNaoAutorizadoException {
    Integer idUsuario = tokenUtil.obterIdUsuario(token);
    return service.buscaExtrato(idUsuario);
  }

  @GET
  @Path("/saldo")
  public SaldoResult buscaSaldo(@QueryParam("token") String token)
      throws AcessoNaoAutorizadoException {
    Integer idUsuario = tokenUtil.obterIdUsuario(token);
    return service.buscaSaldo(idUsuario);
  }

}