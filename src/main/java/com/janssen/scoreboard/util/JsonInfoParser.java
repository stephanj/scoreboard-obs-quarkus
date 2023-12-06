package com.janssen.scoreboard.util;

import com.janssen.scoreboard.domain.GameInfo;

public class JsonInfoParser {

    public static GameInfo parseJson(String json) {
        GameInfo gameInfo = new GameInfo();
        json = json.substring(1, json.length() - 1); // Remove curly braces

        String[] keyValuePairs = json.split(",");

        for (String pair : keyValuePairs) {
            String[] entry = pair.split(":");
            String key = entry[0].replace("\"", "").trim();
            String value = entry[1].replace("\"", "").trim();

            switch (key) {
                case "TT":
                    gameInfo.setTimeoutTime(Integer.parseInt(value));
                    break;
                case "A":
                    gameInfo.setHomeTeamScore(Integer.parseInt(value));
                    break;
                case "B":
                    gameInfo.setVisitingTeamScore(Integer.parseInt(value));
                    break;
                case "Q":
                    gameInfo.setQuarter(value);
                    break;
                case "24":
                    gameInfo.setTwentyFour(Integer.parseInt(value));
                    break;
                case "FH":
                    gameInfo.setFoulsHomeTeam(Integer.parseInt(value));
                    break;
                case "m":
                    gameInfo.setClockMinutes(Integer.parseInt(value));
                    break;
                case "T":
                    gameInfo.setTimeoutClockRunning(Boolean.parseBoolean(value));
                    break;
                case "TH":
                    gameInfo.setTimeoutsHomeTeam(Integer.parseInt(value));
                    break;
                case "FA":
                    gameInfo.setFoulsAwayTeam(Integer.parseInt(value));
                    break;
                case "TA":
                    gameInfo.setTimeoutsAwayTeam(Integer.parseInt(value));
                    break;
                default:
                    gameInfo.setClockSeconds(Integer.parseInt(value));
            }
        }

        return gameInfo;
    }
}

