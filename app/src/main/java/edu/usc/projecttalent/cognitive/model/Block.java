package edu.usc.projecttalent.cognitive.model;

import java.util.ArrayList;

/**
 * Created by anind on 5/22/2017.
 */

public class Block {
    int number;
    ArrayList<Answer> answers;
    int score;

    public Block(int number){
        this.number = number;
        answers = new ArrayList<>();
    }

    public void addAnswer(Answer answer) {
        answers.add(answer);
    }

    public void endBlock(int score) {
        this.score = score;
    }
}
