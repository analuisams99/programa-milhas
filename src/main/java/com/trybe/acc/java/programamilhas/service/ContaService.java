package com.trybe.acc.java.programamilhas.service;

import com.trybe.acc.java.programamilhas.dao.ContaDao;
import com.trybe.acc.java.programamilhas.model.Lancamento;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

/**Classe ContaService.*/
@ApplicationScoped
public class ContaService {

  @Inject
  ContaDao contaDao;

  public List<Lancamento> buscaExtrato(Integer idUsuario) {
    return contaDao.buscaExtrato(idUsuario);
  }

}