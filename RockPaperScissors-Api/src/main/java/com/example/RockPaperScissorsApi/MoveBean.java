package com.example.RockPaperScissorsApi;

public class MoveBean {

    private final String firstPlayerMove;
    private final String secondPlayerMove;


    public MoveBean(String firstPlayerMove, String secondPlayerMove) {
        this.firstPlayerMove = firstPlayerMove;
        this.secondPlayerMove = secondPlayerMove;
    }

    public String getFirstPlayerMove() {
        return firstPlayerMove;
    }

    public String getSecondPlayerMove() {
        return secondPlayerMove;
    }

}
