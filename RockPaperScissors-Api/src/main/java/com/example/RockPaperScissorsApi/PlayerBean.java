package com.example.RockPaperScissorsApi;

public class PlayerBean {

    private final String firstPlayer;
    private final String secondPlayer;


    public PlayerBean(String firstPlayer, String secondPlayer) {
        this.firstPlayer = firstPlayer;
        this.secondPlayer = secondPlayer;
    }

    public String getFirstPlayer() {
        return firstPlayer;
    }

    public String getSecondPlayer() {
        return secondPlayer;
    }
}
