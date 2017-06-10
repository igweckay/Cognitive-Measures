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

    ARExample(String instructions, TypedArray options, String details, boolean answer, int ansOption) {
        this.instructions = instructions;
        this.options = options;
        this.details = details;
        this.answer = answer;
        this.ansOption = ansOption;
    }

    @SuppressWarnings("ResourceType")
    ARExample(TypedArray options) {
        this.options = options;
        this.ansOption = options.getInt(6, -1);
    }

    @BindingAdapter({"bind:imageUrl"})
    public static void loadImage(ImageView view, int imageUrl) {
        view.setImageResource(imageUrl);
    }
}
