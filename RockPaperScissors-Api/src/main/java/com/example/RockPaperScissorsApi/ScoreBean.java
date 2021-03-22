package com.example.RockPaperScissorsApi;

public class ScoreBean {

    private int round;
    private int oneWins;
    private int twoWins;
    private int ties;
    private String matchWinner;
    private String gameWinner;


    public ScoreBean() {
        this.round = 0;
        this.oneWins = 0;
        this.twoWins = 0;
        this.ties = 0;
        this.matchWinner = "";
        this.gameWinner = "";
    }

    public int getRound() {
        return round;
    }

    public void setRound(int round) {
        this.round = round;
    }

    public int getOneWins() {
        return oneWins;
    }

    public void setOneWins(int oneWins) {
        this.oneWins = oneWins;
    }

    public int getTwoWins() {
        return twoWins;
    }

    public void setTwoWins(int twoWins) {
        this.twoWins = twoWins;
    }

    public int getTies() {
        return ties;
    }

    public void setTies(int ties) {
        this.ties = ties;
    }

    public String getMatchWinner() {
        return matchWinner;
    }

    public void setMatchWinner(String matchWinner) {
        this.matchWinner = matchWinner;
    }

    public String getGameWinner() {
        return gameWinner;
    }

    public void setGameWinner(String matchWinner) {
        this.gameWinner = matchWinner;
    }

}
