package com.trybe.acc.java.programamilhas.dao;

import com.trybe.acc.java.programamilhas.model.Lancamento;
import com.trybe.acc.java.programamilhas.result.SaldoResult;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;

/**Classe ContaDao.*/
@ApplicationScoped
public class ContaDao {

  @Inject
  EntityManager entityManager;

  /**Método buscaExtrato.*/
  public List<Lancamento> buscaExtrato(Integer idUsuario) {
    String hql = "SELECT l FROM Lancamento l WHERE l.usuario.id = :idUsuario";

    return entityManager.createQuery(hql, Lancamento.class)
        .setParameter("idUsuario", idUsuario)
        .getResultList();
  }

  /**Método buscaSaldo.*/
  public SaldoResult buscaSaldo(Integer idUsuario) {
    String hql = "SELECT l.usuario.id, l.usuario.login, "
        + "SUM(l.valor) AS saldo "
        + "FROM Lancamento l "
        + "WHERE l.usuario.id = :idUsuario ";

    Object[] row = entityManager.createQuery(hql, Object[].class)
        .setParameter("idUsuario", idUsuario)
        .getSingleResult();

    Integer userId = (Integer) row[0];
    String login = (String) row[1];
    Long saldo = (Long) row[2];

    return new SaldoResult(userId, login, saldo.intValue());
  }

}