package com.janssen.scoreboard.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

/**
 * The game info service.
 * This will call the Scoreboard B API to get the game info.
 */
@ApplicationScoped
@RegisterRestClient
public interface GameInfoService {
    @GET
    @Produces("application/json")
    @Path("api/game/info/{gameId}")
    String get(@PathParam("gameId") Integer gameId);
}
