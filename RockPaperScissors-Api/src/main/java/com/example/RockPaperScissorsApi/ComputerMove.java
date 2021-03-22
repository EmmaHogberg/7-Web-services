package com.example.RockPaperScissorsApi;

import java.util.Random;

public class ComputerMove {

    public static String randomizeComputerMove() {
        String computerMove = "";
        Random random = new Random();
        int randomAnswer = random.nextInt(3) + 1;

        if(randomAnswer == 1) {
            computerMove = "rock";
        }
        else if(randomAnswer == 2) {
            computerMove = "scissor";
        }
        else {
            computerMove = "paper";
        }
        return computerMove;
    }
}
