package com.janssen.scoreboard.domain;

public class Team {
    private int id;
    private String name;
    private String key;
    private int score;
    private int fouls;
    private int timeout;
    private boolean mirrored;

    public Team() {
    }

    public Team(int id, String name, String key, int score, int fouls, int timeout, boolean mirrored) {
        this.id = id;
        this.name = name;
        this.key = key;
        this.score = score;
        this.fouls = fouls;
        this.timeout = timeout;
        this.mirrored = mirrored;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getFouls() {
        return fouls;
    }

    public void setFouls(int fouls) {
        this.fouls = fouls;
    }

    public int getTimeout() {
        return timeout;
    }

    public void setTimeout(int timeout) {
        this.timeout = timeout;
    }

    public boolean getMirrored() {
        return mirrored;
    }

    public void setMirrored(boolean mirrored) {
        this.mirrored = mirrored;
    }

    @Override
    public String toString() {
        return "Team{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", key='" + key + '\'' +
            ", score=" + score +
            ", fouls=" + fouls +
            ", timeout=" + timeout +
            ", mirrored=" + mirrored +
            '}';
    }
}
