package com.janssen.scoreboard.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

/**
 * The game list service.
 * This will call the Scoreboard B API to get the list of games.
 */
@ApplicationScoped
@RegisterRestClient
public interface GameListService {

    @GET
    @Produces("application/json")
    @Path("api/game/list")
    String get();
}
