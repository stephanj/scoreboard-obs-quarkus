package com.janssen.scoreboard.util;

import com.janssen.scoreboard.domain.Game;

import java.util.ArrayList;
import java.util.List;

public class JsonGameParser {

    private JsonGameParser() {
    }

    public static List<Game> parseJson(String json) {
        List<Game> games = new ArrayList<>();

        json = json.substring(1, json.length() - 1); // Remove the square brackets
        String[] objects = json.split("\\},\\{"); // Split by objects

        for (String object : objects) {
            games.add(parseGameObject(object));
        }

        return games;
    }

    private static Game parseGameObject(String jsonObject) {
        Game game = new Game();
        String[] fields = jsonObject.split(",");

        for (String field : fields) {
            String[] keyValue = field.split(":");
            String key = keyValue[0].replaceAll("[\"{}]", "").trim();
            String value = keyValue[1].replaceAll("[\"{}]", "").trim();

            if (key.equals("id")) {
                game.setId(Integer.parseInt(value));
            }
        }

        return game;
    }
}
