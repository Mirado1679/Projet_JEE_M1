package com.mirado.moi.rest;

import com.mirado.moi.entity.User;
import com.mirado.moi.service.UserService;
import com.mirado.moi.util.TokenUtils;
import com.mirado.moi.dto.AuthResponse;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/users")
public class UserResource {

    @Inject
    private UserService userService;

    @POST
    @Path("/register")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response register(User user) {
        try {
            User createdUser = userService.register(user);
            String token = TokenUtils.createToken(createdUser.getEmail());
            return Response.status(Response.Status.CREATED)
                    .entity(new AuthResponse(token))
                    .build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(e.getMessage())
                    .build();
        }
    }

    @POST
    @Path("/login")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response login(User user) {
        try {
            User existingUser = userService.login(user.getEmail(), user.getPassword());
            String token = TokenUtils.createToken(existingUser.getEmail());
            return Response.ok(new AuthResponse(token)).build();
        } catch (Exception e) {
            return Response.status(Response.Status.UNAUTHORIZED)
                    .entity(e.getMessage())
                    .build();
        }
    }
}
