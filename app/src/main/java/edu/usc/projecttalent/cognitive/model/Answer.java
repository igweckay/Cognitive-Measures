package edu.usc.projecttalent.cognitive.model;

import java.util.Date;

/**
 * Created by anind on 5/22/2017.
 */

public class Answer {
    Date start;
    int user_ans;
    int actual;
    Date end;

    public Answer() {
        this.start = new Date();
    }

    public void endAnswer(int user_ans, int actual) {
        this.user_ans = user_ans;
        this.actual = actual;
        this.end = new Date();
    }
}
