/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mirado.moi.rest;

/**
 *
 * @author Tsiory
 */
import com.mirado.moi.entity.Personne;
import com.mirado.moi.service.PersonneService;
import jakarta.ejb.EJB;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import java.util.List;

@Path("personnes")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PersonneResource {

    @EJB
    PersonneService service;

    @GET
    public List<Personne> getAll() {
        return service.lister();
    }

    @POST
    public void ajouter(Personne p) {
        service.ajouter(p);
    }
}
