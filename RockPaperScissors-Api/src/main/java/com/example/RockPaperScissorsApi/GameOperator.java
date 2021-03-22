package com.example.RockPaperScissorsApi;


public class GameOperator {

    // Method for returning who won the game
    public static void setGameScore(MoveBean moveBean, ScoreBean scoreBean, PlayerBean playerBean) {

        String firstPlayerMove = moveBean.getFirstPlayerMove();
        String secondPlayerMove = moveBean.getSecondPlayerMove();

        int oneWins = 0;
        int twoWins = 0;
        int ties = 0;


        // Increase rounds
        int round = scoreBean.getRound();
        round++;
        scoreBean.setRound(round);


        // Analyze the result of the players' moves
        switch (firstPlayerMove) {
            case "rock":
                switch (secondPlayerMove) {
                    case "rock":
                        ties = scoreBean.getTies();
                        ties++;
                        scoreBean.setTies(ties);
                        scoreBean.setMatchWinner("draw");
                        break;
                    case "paper":
                        twoWins = scoreBean.getTwoWins();
                        twoWins++;
                        scoreBean.setTwoWins(twoWins);
                        scoreBean.setMatchWinner(playerBean.getSecondPlayer());
                        break;
                    case "scissor":
                        oneWins = scoreBean.getOneWins();
                        oneWins++;
                        scoreBean.setOneWins(oneWins);
                        scoreBean.setMatchWinner(playerBean.getFirstPlayer());
                        break;
                }
                break;

            case "paper":
                switch (secondPlayerMove) {
                    case "rock":
                        oneWins = scoreBean.getOneWins();
                        oneWins++;
                        scoreBean.setOneWins(oneWins);
                        scoreBean.setMatchWinner(playerBean.getFirstPlayer());
                        break;
                    case "paper":
                        ties = scoreBean.getTies();
                        ties++;
                        scoreBean.setTies(ties);
                        scoreBean.setMatchWinner("draw");
                        break;
                    case "scissor":
                        twoWins = scoreBean.getTwoWins();
                        twoWins++;
                        scoreBean.setTwoWins(twoWins);
                        scoreBean.setMatchWinner(playerBean.getSecondPlayer());

                        break;
                }
                break;

            case "scissor":
                switch (secondPlayerMove) {
                    case "rock":
                        twoWins = scoreBean.getTwoWins();
                        twoWins++;
                        scoreBean.setTwoWins(twoWins);
                        scoreBean.setMatchWinner(playerBean.getSecondPlayer());
                        break;
                    case "paper":
                        oneWins = scoreBean.getOneWins();
                        oneWins++;
                        scoreBean.setOneWins(oneWins);
                        scoreBean.setMatchWinner(playerBean.getFirstPlayer());
                        break;
                    case "scissor":
                        ties = scoreBean.getTies();
                        ties++;
                        scoreBean.setTies(ties);
                        scoreBean.setMatchWinner("draw");
                        break;
                }
                break;
        }


        // Set Game winner
        if (oneWins > twoWins) {
            scoreBean.setGameWinner(playerBean.getFirstPlayer());
        } else if (oneWins < twoWins) {
            scoreBean.setGameWinner(playerBean.getSecondPlayer());
        }
        else {
            scoreBean.setGameWinner("draw");
        }

    }
}
