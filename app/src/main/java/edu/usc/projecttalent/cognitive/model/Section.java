package edu.usc.projecttalent.cognitive.model;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by anind on 5/22/2017.
 */

public class Section {
    String name;
    Date start;
    ArrayList<Block> blocks;
    Date end;

    public Section(String name) {
        this.name = name;
        this.start = new Date();
        blocks = new ArrayList<>();
    }

    public void addBlock(Block block) {
        blocks.add(block);
    }

    public void endSection() {
        this.end = new Date();
    }

}
