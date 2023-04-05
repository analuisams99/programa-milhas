package com.trybe.acc.java.programamilhas.dao;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;

/**Classe TransacaoDao.*/
@ApplicationScoped
public class TransacaoDao {

  @Inject
  EntityManager entityManager;

  /**Método buscaSaldoUsuario. */
  public Integer buscaSaldoUsuario(Integer idUsuario) {
    String hql = "SELECT SUM(l.valor) "
        + "FROM Lancamento l WHERE l.usuario.id = :idUsuario";

    Long result =  entityManager.createQuery(hql, Long.class)
        .setParameter("idUsuario", idUsuario)
        .getSingleResult();

    return result.intValue();
  }

}