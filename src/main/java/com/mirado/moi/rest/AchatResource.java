package com.mirado.moi.rest;

import com.mirado.moi.dto.AchatDTO;
import com.mirado.moi.dto.AchatResponseDto;
import com.mirado.moi.entity.Achat;
import com.mirado.moi.service.AchatService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/achats")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AchatResource {

    @Inject
    private AchatService service;

    @POST
    public Response create(AchatDTO dto) {
        service.createFromDto(dto);
        return Response.status(Response.Status.CREATED).build();
    }

    @GET
    public List<AchatResponseDto> getAll() {
        return service.getAllAsDto();
    }

    @GET
    @Path("/{id}")
    public Achat getById(@PathParam("id") Long id) {
        return service.getById(id);
    }

    @PUT
    public Achat update(Achat achat) {
        return service.update(achat);
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id) {
        service.delete(id);
        return Response.noContent().build();
    }
}
