package com.janssen.scoreboard.util;

import com.janssen.scoreboard.domain.GameInfo;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class JsonInfoParserTest {

    @Test
    void testParser() {
        String json = "{\"TT\":16,\"A\":100,\"Q\":\"1st\",\"24\":22,\"B\":99,\"FH\":2,\"s\":42,\"T\":false,\"TH\":3,\"FA\":5,\"m\":5,\"TA\":1}";
        GameInfo stats = JsonInfoParser.parseJson(json);
        // Now, stats contains your parsed data
        System.out.println(stats);
        assertNotNull(stats);

        assertNotNull(stats.getQuarter());
        assertEquals("1st", stats.getQuarter());

        assertNotNull(stats.getClockSeconds());
        assertEquals(42, stats.getClockSeconds());

        assertNotNull(stats.getClockMinutes());
        assertEquals(5, stats.getClockMinutes());

        assertNotNull(stats.getFoulsAwayTeam());
        assertEquals(5, stats.getFoulsAwayTeam());

        assertNotNull(stats.getFoulsHomeTeam());
        assertEquals(2, stats.getFoulsHomeTeam());

        assertNotNull(stats.getHomeTeamScore());
        assertEquals(100, stats.getHomeTeamScore());

        assertNotNull(stats.isTimeoutClockRunning());
        assertEquals(false, stats.isTimeoutClockRunning());

        assertNotNull(stats.getTimeoutsAwayTeam());
        assertEquals(1, stats.getTimeoutsAwayTeam());

        assertNotNull(stats.getTimeoutsHomeTeam());
        assertEquals(3, stats.getTimeoutsHomeTeam());

        assertNotNull(stats.getTwentyFour());
        assertEquals(22, stats.getTwentyFour());

        assertNotNull(stats.getVisitingTeamScore());
        assertEquals(99, stats.getVisitingTeamScore());

        assertNotNull(stats.getTimeoutTime());
        assertEquals(16, stats.getTimeoutTime());
    }
}
