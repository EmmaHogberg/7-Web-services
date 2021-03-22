package com.example.RockPaperScissorsApi;

public class PlayerBean {

    private String firstPlayer;
    private String secondPlayer;


    public PlayerBean(String firstPlayer, String secondPlayer) {
        this.firstPlayer = firstPlayer;
        this.secondPlayer = secondPlayer;
    }

    public String getFirstPlayer() {
        return firstPlayer;
    }

    public void setFirstPlayer(String firstPlayer) {
        this.firstPlayer = firstPlayer;
    }

    public String getSecondPlayer() {
        return secondPlayer;
    }

    public void setSecondPlayer(String secondPlayer) {
        this.secondPlayer = secondPlayer;
    }
}
