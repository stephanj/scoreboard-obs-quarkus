package com.janssen.scoreboard.domain;

public class GameInfo {

    Integer timeoutTime;

    Integer homeTeamScore;

    Integer visitingTeamScore;

    String quarter;

    Integer twentyFour;

    Integer foulsHomeTeam;

    Integer clockSeconds;

    Integer clockMinutes;

    boolean timeoutClockRunning;

    Integer timeoutsHomeTeam;

    Integer foulsAwayTeam;

    Integer timeoutsAwayTeam;

    public GameInfo() {}

    public GameInfo(Integer timeoutTime,
                    Integer homeTeamScore,
                    Integer visitingTeamScore,
                    String quarter,
                    Integer twentyFour,
                    Integer foulsHomeTeam,
                    Integer clockSeconds,
                    Integer clockMinutes,
                    boolean timeoutClockRunning,
                    Integer timeoutsHomeTeam,
                    Integer foulsAwayTeam,
                    Integer timeoutsAwayTeam) {
        this.timeoutTime = timeoutTime;
        this.homeTeamScore = homeTeamScore;
        this.visitingTeamScore = visitingTeamScore;
        this.quarter = quarter;
        this.twentyFour = twentyFour;
        this.foulsHomeTeam = foulsHomeTeam;
        this.clockSeconds = clockSeconds;
        this.clockMinutes = clockMinutes;
        this.timeoutClockRunning = timeoutClockRunning;
        this.timeoutsHomeTeam = timeoutsHomeTeam;
        this.foulsAwayTeam = foulsAwayTeam;
        this.timeoutsAwayTeam = timeoutsAwayTeam;
    }

    public Integer getTimeoutTime() {
        return timeoutTime;
    }

    public void setTimeoutTime(int timeoutTime) {
        this.timeoutTime = timeoutTime;
    }

    public Integer getHomeTeamScore() {
        return homeTeamScore;
    }

    public void setHomeTeamScore(int homeTeamScore) {
        this.homeTeamScore = homeTeamScore;
    }

    public Integer getVisitingTeamScore() {
        return visitingTeamScore;
    }

    public void setVisitingTeamScore(int visitingTeamScore) {
        this.visitingTeamScore = visitingTeamScore;
    }

    public String getQuarter() {
        return quarter;
    }

    public void setQuarter(String quarter) {
        this.quarter = quarter;
    }

    public Integer getTwentyFour() {
        return twentyFour;
    }

    public void setTwentyFour(int twentyFour) {
        this.twentyFour = twentyFour;
    }

    public Integer getFoulsHomeTeam() {
        return foulsHomeTeam;
    }

    public void setFoulsHomeTeam(int foulsHomeTeam) {
        this.foulsHomeTeam = foulsHomeTeam;
    }

    public Integer getClockSeconds() {
        return clockSeconds;
    }

    public void setClockSeconds(int clockSeconds) {
        this.clockSeconds = clockSeconds;
    }

    public Integer getClockMinutes() {
        return clockMinutes;
    }

    public void setClockMinutes(int clockMinutes) {
        this.clockMinutes = clockMinutes;
    }

    public Boolean isTimeoutClockRunning() {
        return timeoutClockRunning;
    }

    public void setTimeoutClockRunning(boolean timeoutClockRunning) {
        this.timeoutClockRunning = timeoutClockRunning;
    }

    public Integer getTimeoutsHomeTeam() {
        return timeoutsHomeTeam;
    }

    public void setTimeoutsHomeTeam(int timeoutsHomeTeam) {
        this.timeoutsHomeTeam = timeoutsHomeTeam;
    }

    public Integer getFoulsAwayTeam() {
        return foulsAwayTeam;
    }

    public void setFoulsAwayTeam(int foulsAwayTeam) {
        this.foulsAwayTeam = foulsAwayTeam;
    }

    public Integer getTimeoutsAwayTeam() {
        return timeoutsAwayTeam;
    }

    public void setTimeoutsAwayTeam(int timeoutsAwayTeam) {
        this.timeoutsAwayTeam = timeoutsAwayTeam;
    }

    @Override
    public String toString() {
        return "GameInfo{" +
            "timeoutTime=" + timeoutTime +
            ", homeTeamScore=" + homeTeamScore +
            ", visitingTeamScore=" + visitingTeamScore +
            ", quarter='" + quarter +
            ", twentyFour=" + twentyFour +
            ", foulsHomeTeam=" + foulsHomeTeam +
            ", clockSeconds=" + clockSeconds +
            ", clockMinutes=" + clockMinutes +
            ", timeoutClockRunning=" + timeoutClockRunning +
            ", TimeoutsHomeTeam=" + timeoutsHomeTeam +
            ", foulsAwayTeam=" + foulsAwayTeam +
            ", timeoutsAwayTeam=" + timeoutsAwayTeam +
            '}';
    }
}
