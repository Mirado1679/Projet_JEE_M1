package com.mirado.moi.rest;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;

import com.mirado.moi.entity.Plat;
import com.mirado.moi.service.PlatService;

@Path("/plats")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PlatResource {

    @Inject
    private PlatService service;

    @POST
    public Response create(Plat plat) {
        service.create(plat);
        return Response.status(Response.Status.CREATED).build();
    }

    @GET
    public List<Plat> getAll() {
        return service.getAll();
    }

    @GET
    @Path("/{id}")
    public Plat getById(@PathParam("id") Long id) {
        return service.getById(id);
    }

    @PUT
    public Plat update(Plat plat) {
        return service.update(plat);
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id) {
        service.delete(id);
        return Response.noContent().build();
    }
}