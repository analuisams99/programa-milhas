package com.trybe.acc.java.programamilhas.dao;

import com.trybe.acc.java.programamilhas.model.Lancamento;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

/**Classe AdminDao - responsável pela persistência dos dados para o administrador.*/
@ApplicationScoped
public class AdminDao {

  @Inject
  EntityManager entityManager;

  @Transactional
  public void adicionaCredito(Lancamento lancamento) {
    entityManager.persist(lancamento);
    return;
  }

  @Transactional
  public void efetuaResgate(Lancamento lancamento) {
    entityManager.persist(lancamento);
    return;
  }

}