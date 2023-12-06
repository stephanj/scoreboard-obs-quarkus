package com.janssen.scoreboard.service;

import com.janssen.scoreboard.domain.GameInfo;
import com.janssen.scoreboard.util.JsonInfoParser;
import io.quarkus.scheduler.Scheduled;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import org.jboss.logging.Logger;

import java.io.FileWriter;

/**
 * The schedule service.
 * This will call the Scoreboard B API every second to get the game info.
 */
@ApplicationScoped
public class ScheduleService {
    private static final Logger LOG = Logger.getLogger(ScheduleService.class);

    private Boolean running = false;

    @Inject
    @RestClient
    GameInfoService gameInfoService;

    int gameId;

    public boolean isRunning() {
        return Boolean.TRUE.equals(running);
    }

    public void startRun(int gameId) {
        this.gameId = gameId;
        running = true;
    }

    @Scheduled(every = "1s")
    void callScoreboardEverySecond() {
        LOG.debug("Running every second...");

        if (isRunning()) {
            LOG.debug("Getting game info for game id " + gameId);
            String json = gameInfoService.get(gameId);

            LOG.info(json);

            GameInfo gameInfo = JsonInfoParser.parseJson(json);

            LOG.info("Game info retrieved: " + gameInfo);

            // Write game info to disk
            writeGameInfo(gameInfo);
        }
    }

    /**
     * Write the game info to disk, this way OBS can display the info onto the stream.
     * @param gameInfo The game info.
     */
    private void writeGameInfo(GameInfo gameInfo) {
        writeValueToFile("home_score.txt", String.format("%03d", gameInfo.getHomeTeamScore()));
        writeValueToFile("visit_score.txt", String.format("%03d", gameInfo.getVisitingTeamScore()));
        writeValueToFile("quarter.txt", gameInfo.getQuarter());
        writeValueToFile("24.txt", gameInfo.getTwentyFour().toString());

        writeValueToFile("timeout-clock.txt", gameInfo.getTimeoutTime().toString());
        writeValueToFile("timeout-running.txt", gameInfo.isTimeoutClockRunning().toString());

        writeValueToFile("timeouts-home.txt", gameInfo.getTimeoutsHomeTeam().toString());
        writeValueToFile("timeouts-away.txt", gameInfo.getTimeoutsAwayTeam().toString());

        writeValueToFile("fouten-home.txt", gameInfo.getFoulsHomeTeam().toString());
        writeValueToFile("fouten-away.txt", gameInfo.getFoulsAwayTeam().toString());

        writeValueToFile("game_time.txt",
        String.format("%02d:%02d", gameInfo.getClockMinutes(), gameInfo.getClockSeconds()));
    }

    /**
     * Write a value to a file.
     * @param fileName The file name.
     * @param value The value to write.
     */
    public void writeValueToFile(String fileName, String value) {
        try (FileWriter output = new FileWriter(fileName)) {
            // Writes the string to the file
            output.write(value);
        } catch (Exception e) {
            LOG.error(e.getMessage());
        }
    }
}
