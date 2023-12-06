package com.janssen.scoreboard.util;

import com.janssen.scoreboard.domain.Game;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class JsonGameParserTest {

    @Test
    void testParserOfOneGame() {
        String json = """
        [{"id":14,"createdOn":"2023-12-06T16:31:47.232+00:00","userName":"na","teamA":{"id":12,"name":"2","key":"A","score":0,"fouls":0,"timeOut":0,"mirrored":true},"teamB":{"id":13,"name":"1","key":"B","score":0,"fouls":0,"timeOut":0,"mirrored":true},"gameType":"BASKET","ageCategory":"SENIOREN","quarter":1,"clock":522,"court":"B","mirrored":true}]
        """;

        List<Game> games = JsonGameParser.parseJson(json);

        System.out.println(games);
        assertNotNull(games);

        System.out.println(games.get(0));
        assertNotNull(games.get(0));

        System.out.println(games.get(0).getId());
        assertEquals(14, games.get(0).getId());
    }

    @Test
    void testParserOfMultipleGame() {
        String json = """
        [{"id":14,"createdOn":"2023-12-06T16:31:47.232+00:00","userName":"na","teamA":{"id":12,"name":"2","key":"A","score":0,"fouls":0,"timeOut":0,"mirrored":true},"teamB":{"id":13,"name":"1","key":"B","score":0,"fouls":0,"timeOut":0,"mirrored":true},"gameType":"BASKET","ageCategory":"SENIOREN","quarter":1,"clock":522,"court":"B","mirrored":true},{"id":15,"createdOn":"2023-12-06T16:31:47.232+00:00","userName":"na","teamA":{"id":12,"name":"2","key":"A","score":0,"fouls":0,"timeOut":0,"mirrored":true},"teamB":{"id":13,"name":"1","key":"B","score":0,"fouls":0,"timeOut":0,"mirrored":true},"gameType":"BASKET","ageCategory":"SENIOREN","quarter":1,"clock":522,"court":"B","mirrored":true},{"id":16,"createdOn":"2023-12-06T16:31:47.232+00:00","userName":"na","teamA":{"id":12,"name":"2","key":"A","score":0,"fouls":0,"timeOut":0,"mirrored":true},"teamB":{"id":13,"name":"1","key":"B","score":0,"fouls":0,"timeOut":0,"mirrored":true},"gameType":"BASKET","ageCategory":"SENIOREN","quarter":1,"clock":522,"court":"B","mirrored":true}]]
        """;

        List<Game> games = JsonGameParser.parseJson(json);

        System.out.println(games);
        assertNotNull(games);

        assertEquals(3, games.size());

        assertNotNull(games.get(0));

        assertEquals(14, games.get(0).getId());
    }
}
