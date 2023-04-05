package com.trybe.acc.java.programamilhas.dao;

import com.trybe.acc.java.programamilhas.model.Lancamento;
import com.trybe.acc.java.programamilhas.result.SaldoResult;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
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

  /**Busca os saldos dos usuários.*/
  public List<SaldoResult> buscarSaldos() {
    String hql = "SELECT l.usuario.id, l.usuario.login, "
        + "SUM(l.valor) AS saldo "
        + "FROM Lancamento l "
        + "GROUP BY l.usuario.id";

    TypedQuery<Object[]> query = entityManager.createQuery(hql, Object[].class);

    List<SaldoResult> results = new ArrayList<SaldoResult>();

    for (Object[] row : query.getResultList()) {
      Integer userId = (Integer) row[0];
      String login = (String) row[1];
      Long saldo = (Long) row[2];
      results.add(new SaldoResult(userId, login, saldo.intValue()));
    }

    return results;
  }

}