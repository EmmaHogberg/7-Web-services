package com.example.RockPaperScissorsApi;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RockPaperScissorsApiController {

    PlayerBean playerBean;
    MoveBean moveBean;
    ScoreBean scoreBean = new ScoreBean();

    // Set player name and single or multi play
    @RequestMapping(value = "/start", method = RequestMethod.POST)
    public String start(String firstPlayer, String secondPlayer) {

        playerBean = new PlayerBean(firstPlayer, secondPlayer);

        if (playerBean.getSecondPlayer().equals("Computer") || playerBean.getSecondPlayer().equals("computer")) {
            return "Welcome " + firstPlayer + "<p>Start the game at http://localhost:8080/start/single-play?move= </p> " +
                    "<p> and choose rock / paper / scissor</p>";
        }
        else {
            return "Welcome " + firstPlayer + " and " + secondPlayer +
                    "<p>Start the game at http://localhost:8080/start/multi-play? with parameters \"first\" and \"second\"</p> " +
                    "<p>and choose rock / paper / scissor for each one</p>";
        }
    }



    // Get move in single play
    @RequestMapping(value = "/start/single-play", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public String singlePlay(String move) {

        moveBean = new MoveBean(move, ComputerMove.randomizeComputerMove());
        updateGameScore();
        String pattern = "{ \"round\":%s, \"firstPlayer\":{\"name\": \"%s\",\"played\": \"%s\"}, " +
                "\"secondPlayer\":{\"name\": \"%s\", \"played\":\"%s\"},\"matchWinner\":\"%s\"}";
        return String.format(pattern, scoreBean.getRound(), playerBean.getFirstPlayer(), moveBean.getFirstPlayerMove(),
                playerBean.getSecondPlayer(), moveBean.getSecondPlayerMove(), scoreBean.getMatchWinner());
    }



    // Get moves in multi play
    @GetMapping(value = "/start/multi-play", produces = MediaType.APPLICATION_JSON_VALUE)
    public String multiPlay(@RequestParam String first, @RequestParam String second) {

        moveBean = new MoveBean(first, second);
        updateGameScore();

        String pattern = "{ \"round\":%s, \"firstPlayer\":{\"name\": \"%s\",\"played\": \"%s\"}, " +
                "\"secondPlayer\":{\"name\": \"%s\", \"played\":\"%s\"},\"matchWinner\":\"%s\"}";
        return String.format(pattern, scoreBean.getRound(), playerBean.getFirstPlayer(), moveBean.getFirstPlayerMove(),
                playerBean.getSecondPlayer(), moveBean.getSecondPlayerMove(), scoreBean.getMatchWinner());
    }

    // Update game score
    private void updateGameScore() {
        PlayOperator.setGameScore(moveBean, scoreBean, playerBean);
    }

    @RequestMapping(value = "/score", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public String getScoreBean() {
        String pattern = "{ \"round\":%s, \"firstPlayer\":{\"name\": \"%s\", \"wins\":%s}, \"secondPlayer\":{\"name\": \"%s\", \"wins\":%s}," +
                "\"ties\":%s, \"gameWinner\":\"%s\"}";
        return String.format(pattern, scoreBean.getRound(), playerBean.getFirstPlayer(),
                scoreBean.getOneWins(), playerBean.getSecondPlayer(),
                scoreBean.getTwoWins(), scoreBean.getTies(), scoreBean.getGameWinner());
    }
}
