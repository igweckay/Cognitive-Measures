package edu.usc.projecttalent.cognitive.spatial;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.LinkedList;
import java.util.Queue;

import edu.usc.projecttalent.cognitive.R;
import edu.usc.projecttalent.cognitive.databinding.ActivitySppracticeBinding;
import edu.usc.projecttalent.cognitive.reasoning.ARExample;

public class SPSampleActivity extends Activity {

    Queue<ARExample> mQueue;
    Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sppractice_);

        Resources r = getResources();
        mQueue = new LinkedList<>();
        mContext = this;

        TypedArray arr = r.obtainTypedArray(R.array.sp_ex_3);

        mQueue.add(new ARExample(getString(R.string.sp_3_instr), arr, getString(R.string.sp_next), false));
        mQueue.add(new ARExample(getString(R.string.sp_3_sol), arr, getString(R.string.sp_begin), true));

        final ActivitySppracticeBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_sppractice_);
        binding.setItem(mQueue.remove());

        Button next = (Button) findViewById(R.id.next);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!mQueue.isEmpty())
                    binding.setItem(mQueue.remove());
                else
                    startActivityForResult(new Intent(mContext, SP31_Activity.class), 1);

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
