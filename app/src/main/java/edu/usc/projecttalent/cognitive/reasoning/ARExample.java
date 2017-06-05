package edu.usc.projecttalent.cognitive.reasoning;

import android.content.res.TypedArray;
import android.databinding.BindingAdapter;
import android.widget.ImageView;

/**
 * Created by anind on 6/4/2017.
 */

public class ARExample {
    public String instructions;
    public TypedArray options;
    public String details;
    public boolean answer;
    public int ansOption;

    public ARExample(String instructions, TypedArray arr, String details, boolean answer, int ansOption) {
        this.instructions = instructions;
        options = arr;
        this.details = details;
        this.answer = answer;
        this.ansOption = ansOption;
    }

    @BindingAdapter({"bind:imageUrl"})
    public static void loadImage(ImageView view, int imageUrl) {
        view.setImageResource(imageUrl);
    }
}
