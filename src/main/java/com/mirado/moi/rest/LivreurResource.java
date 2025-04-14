package com.mirado.moi.rest;

import com.mirado.moi.entity.Livreur;
import com.mirado.moi.service.LivreurService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;
import java.util.List;

@Path("/livreurs")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class LivreurResource {

    @Inject
    private LivreurService service;

    @POST
    public Response create(Livreur livreur) {
        service.create(livreur);
        return Response.status(Response.Status.CREATED).entity(livreur).build();
    }

    @GET
    public List<Livreur> getAll() {
        return service.getAll();
    }

    @GET
    @Path("/{id}")
    public Response getById(@PathParam("id") Long id) {
        Livreur livreur = service.getById(id);
        if (livreur == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(livreur).build();
    }

    @PUT
    @Path("/{id}")
    public Response update(@PathParam("id") Long id, Livreur livreur) {
        Livreur existing = service.getById(id);
        if (existing == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        livreur.setId(id);
        return Response.ok(service.update(livreur)).build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id) {
        service.delete(id);
        return Response.noContent().build();
    }
}
