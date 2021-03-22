package com.example.RockPaperScissorsApi;

public class MoveBean {

    private String firstPlayerMove;
    private String secondPlayerMove;


    public MoveBean() {
        this.firstPlayerMove = "";
        this.secondPlayerMove = "";
    }

    public MoveBean(String firstPlayerMove, String secondPlayerMove) {
        this.firstPlayerMove = firstPlayerMove;
        this.secondPlayerMove = secondPlayerMove;
    }

    public String getFirstPlayerMove() {
        return firstPlayerMove;
    }

    public void setFirstPlayerMove(String firstPlayerMove) {
        this.firstPlayerMove = firstPlayerMove;
    }

    public String getSecondPlayerMove() {
        return secondPlayerMove;
    }

    public void setSecondPlayerMove(String secondPlayerMove) {
        this.secondPlayerMove = secondPlayerMove;
    }
}
