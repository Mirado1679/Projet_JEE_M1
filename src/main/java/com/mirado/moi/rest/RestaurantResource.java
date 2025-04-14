package com.mirado.moi.rest;

import com.mirado.moi.entity.Restaurant;
import com.mirado.moi.service.RestaurantService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/restaurants")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class RestaurantResource {

    @Inject
    private RestaurantService service;

    @POST
    public Response create(Restaurant restaurant) {
        service.create(restaurant);
        return Response.status(Response.Status.CREATED).build();
    }

    @GET
    public List<Restaurant> getAll() {
        return service.getAll();
    }

    @GET
    @Path("/{id}")
    public Restaurant getById(@PathParam("id") Long id) {
        return service.get(id);
    }

    @PUT
    public Restaurant update(Restaurant restaurant) {
        return service.update(restaurant);
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id) {
        service.delete(id);
        return Response.noContent().build();
    }
}
