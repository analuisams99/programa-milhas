package com.trybe.acc.java.programamilhas.service;

import com.trybe.acc.java.programamilhas.dao.PessoaDao;
import com.trybe.acc.java.programamilhas.dto.LoginDto;
import com.trybe.acc.java.programamilhas.exception.AcessoNaoAutorizadoException;
import com.trybe.acc.java.programamilhas.result.MensagemResult;
import com.trybe.acc.java.programamilhas.util.HashUtil;
import com.trybe.acc.java.programamilhas.util.TokenUtil;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

/**Classe PessoaService.*/
@ApplicationScoped
public class PessoaService {

  @Inject
  PessoaDao pessoaDao;

  @Inject
  HashUtil hashUtil;

  @Inject
  TokenUtil tokenUtil;

  /**Método de salvar uma pessoa. */
  public MensagemResult salvar(LoginDto login)
      throws InvalidKeySpecException, NoSuchAlgorithmException {
    String hash = hashUtil.hash(login.getSenha());
    pessoaDao.salvar(login.getLogin(), hash);
    return new MensagemResult("Pessoa cadastrada com sucesso!");  
  }
  
  /**Método de deletar uma pessoa.*/
  public MensagemResult deletar(String token) throws AcessoNaoAutorizadoException {
    Integer id = tokenUtil.obterIdUsuario(token);
    pessoaDao.deletar(id);
    return new MensagemResult("Pessoa deletada com sucesso!");
  }

}