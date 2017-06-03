package edu.usc.projecttalent.cognitive.numbers;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.google.gson.Gson;

import edu.usc.projecttalent.cognitive.R;
import edu.usc.projecttalent.cognitive.databinding.ActivitySecNsBinding;

public class SecNS_Activity extends Activity {

    NSExample mExample;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
        final Context mContext = this;

        final boolean showSecond = getIntent().getBooleanExtra("second", false);
        mExample = new Gson().fromJson(getString(showSecond ? R.string.ns_example2 : R.string.ns_example1), NSExample.class);

        ActivitySecNsBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_sec_ns_);
        binding.setItem(mExample);

        LinearLayout series = (LinearLayout) findViewById(R.id.series);
        LinearLayout numPad = (LinearLayout) findViewById(R.id.numpad);
        final EditText answer= (EditText) findViewById(R.id.answer);

        series.removeView(answer);
        series.addView(answer, mExample.ansPosition);

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                answer.append(((Button)v).getText());
            }
        };
        for(int i=0; i<numPad.getChildCount(); i++) {
            (numPad.getChildAt(i)).setOnClickListener(listener);
        }

        (findViewById(R.id.undo)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                int length = answer.length();
            	if (length > 0)
            	    answer.getText().delete(length-1, length);
            }
        });

        (findViewById(R.id.next)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
    			Intent intent = new Intent(mContext, SecNSEx1AActivity.class);
                intent.putExtra("example", mExample);
				startActivityForResult(intent, 1);
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

	@Override
	public void onBackPressed() {}
}
