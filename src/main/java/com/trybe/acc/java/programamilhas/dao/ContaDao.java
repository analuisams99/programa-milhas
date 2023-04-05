package com.trybe.acc.java.programamilhas.dao;

import com.trybe.acc.java.programamilhas.model.Lancamento;
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

}