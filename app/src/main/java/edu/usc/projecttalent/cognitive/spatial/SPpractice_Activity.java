package edu.usc.projecttalent.cognitive.spatial;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.databinding.DataBindingUtil;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.LinkedList;
import java.util.Queue;

import edu.usc.projecttalent.cognitive.R;
import edu.usc.projecttalent.cognitive.databinding.ActivitySppracticeBinding;
import edu.usc.projecttalent.cognitive.reasoning.ARExample;

public class SPpractice_Activity extends Activity {

    Queue<ARExample> mQueue;
    Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Resources res = getResources();

        mQueue = new LinkedList<>();
        mContext = this;
        TypedArray options = res.obtainTypedArray(R.array.sp_ex_1);

        mQueue.add(new ARExample(getString(R.string.sp_1_instr), options, getString(R.string.sp_1_sol), false));

        options = res.obtainTypedArray(R.array.sp_ex_2);
        mQueue.add(new ARExample(getString(R.string.sp_2_instr), options, getString(R.string.sp_next), false));

        final ActivitySppracticeBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_sppractice_);
        binding.setItem(mQueue.remove());

        Button button = (Button) findViewById(R.id.next);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(!mQueue.isEmpty())
                    binding.setItem(mQueue.remove());
                else
                    startActivityForResult(new Intent(mContext, SPIntro_Activity.class), 1);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 1) {
            if (resultCode == RESULT_OK) {
                setResult(Activity.RESULT_OK, data);
                super.finish();
            }
        }
    }
}
