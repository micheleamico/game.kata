package com.goose.game.kata.oggettiGioco;

public class Player {
    String name;

    Integer position;
    Integer positionDie;

    public Player(String name) {
        this.name = name;
        position =0;
        positionDie =0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    public Integer getPositionDie() {
        return positionDie;
    }

    public void setPositionDie(Integer positionDie) {
        this.positionDie = positionDie;
    }
}
