package com.janssen.scoreboard.domain;

public class Game {
    private Integer id;

    public Game() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Game{" +
            "id=" + id +
            '}';
    }
}
