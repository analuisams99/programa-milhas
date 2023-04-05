package com.trybe.acc.java.programamilhas.rest;

import com.trybe.acc.java.programamilhas.model.Parceiro;
import com.trybe.acc.java.programamilhas.service.DominioService;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**Classe DominioResource.*/
@Path("/dominio")
@ApplicationScoped
public class DominioResource {

  @Inject
  DominioService service;

  @GET
  @Path("/parceiro")
  public List<Parceiro> getParceiros() {
    return service.getParceiros();
  }

}
