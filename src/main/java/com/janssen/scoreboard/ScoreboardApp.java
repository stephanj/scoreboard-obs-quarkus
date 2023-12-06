package com.janssen.scoreboard;

import com.janssen.scoreboard.domain.Game;
import com.janssen.scoreboard.service.GameListService;
import com.janssen.scoreboard.service.ScheduleService;
import com.janssen.scoreboard.util.JsonGameParser;
import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.QuarkusApplication;
import jakarta.inject.Inject;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.jboss.logging.Logger;

import java.util.List;

/**
 * The scoreboard app.
 * This will call the Scoreboard B API to get the list of games and start the schedule service.
 */
public class ScoreboardApp implements QuarkusApplication {

    private static final Logger LOG = Logger.getLogger(ScoreboardApp.class);

    @Inject
    @RestClient
    GameListService gameListService;

    @Inject
    ScheduleService scheduleService;

    void init() {
        LOG.info("Getting game list...");
        try {
            getCurrentGame();
        } catch (Exception e) {
            LOG.error("Error getting game list, stopping app!");
            LOG.error(e.getMessage());
            System.exit(1);
        }
    }

    private void getCurrentGame() {
        String json = gameListService.get();

        LOG.info("Game list retrieved: " + json);
        List<Game> games = JsonGameParser.parseJson(json);

        if (!games.isEmpty()) {
            int gameId = games.get(0).getId();
            LOG.info("Start game listener for id: " + gameId);
            scheduleService.startRun(gameId);
        } else {
            LOG.info("No games found");
        }
    }

    @Override
    public int run(String... args) {
        init();
        Quarkus.waitForExit();
        return 0;
    }
}
