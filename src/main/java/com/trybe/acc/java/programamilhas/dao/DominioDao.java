package com.trybe.acc.java.programamilhas.dao;

import com.trybe.acc.java.programamilhas.model.Parceiro;
import com.trybe.acc.java.programamilhas.model.Produto;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;

/**Classe DominioDao.*/
@ApplicationScoped
public class DominioDao {

  @Inject
  EntityManager entityManager;

  public List<Parceiro> getParceiros() {
    String hql = "SELECT p FROM Parceiro p";
    return entityManager.createQuery(hql, Parceiro.class).getResultList();
  }

  public List<Produto> getProdutos() {
    String hql = "SELECT p FROM Produto p";
    return entityManager.createQuery(hql, Produto.class).getResultList();
  }

}