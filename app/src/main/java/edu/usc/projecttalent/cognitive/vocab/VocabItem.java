package edu.usc.projecttalent.cognitive.vocab;

import java.util.ArrayList;

/**
 * Created by anind on 5/17/2017.
 */

public class VocabItem {
    public String question;
    public String[] options;

    public VocabItem(String question, String[] options) {
        this.question = question;
        this.options = options;
    }
}
