package com.mirado.moi.rest;

import com.mirado.moi.util.TokenUtils;
import io.jsonwebtoken.Claims;
import jakarta.annotation.Priority;
import jakarta.ws.rs.Priorities;
import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.container.ContainerRequestFilter;
import jakarta.ws.rs.ext.Provider;
import jakarta.ws.rs.core.Response;

@Provider
@Priority(Priorities.AUTHENTICATION)
public class filter implements ContainerRequestFilter {

    @Override
    public void filter(ContainerRequestContext requestContext) {
        // Afficher le chemin pour déboguer
        String path = requestContext.getUriInfo().getPath();
        System.out.println("Path intercepté: " + path);

        // Exclure les endpoints publics en vérifiant si le chemin se termine par
        // "register" ou "login"
        if (path.endsWith("register") || path.endsWith("login")) {
            System.out.println("Endpoint public, passage sans vérification du token.");
            return;
        }

        // Lire le header Authorization
        String authHeader = requestContext.getHeaderString("Authorization");
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            throw new WebApplicationException(
                    Response.status(Response.Status.UNAUTHORIZED)
                            .entity("Token manquant")
                            .build());
        }

        // Extraire et valider le token
        String token = authHeader.substring("Bearer ".length());
        Claims claims = TokenUtils.validateToken(token);
        if (claims == null) {
            throw new WebApplicationException(
                    Response.status(Response.Status.UNAUTHORIZED)
                            .entity("Token invalide ou expiré")
                            .build());
        }

        // (Optionnel) Vous pouvez stocker ici des infos supplémentaires dans le
        // contexte
    }
}
