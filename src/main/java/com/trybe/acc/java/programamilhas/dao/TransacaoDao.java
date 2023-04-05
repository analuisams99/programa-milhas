package com.trybe.acc.java.programamilhas.dao;

import com.trybe.acc.java.programamilhas.model.Pessoa;
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

  /**Método buscaUsuarioPorNome.*/
  public Pessoa buscaUsuarioPorNome(String login) {
    String hql = "SELECT p FROM Pessoa p WHERE p.login = :login";

    return entityManager.createQuery(hql, Pessoa.class)
        .setParameter("login", login)
        .getSingleResult();
  }

  /**Método buscaUsuarioPorId.*/
  public Pessoa buscaUsuarioPorId(Integer idUsuario) {
    String hql = "SELECT p FROM Pessoa p WHERE p.id = :idUsuario";

    return entityManager.createQuery(hql, Pessoa.class)
        .setParameter("idUsuario", idUsuario)
        .getSingleResult();
  }

}