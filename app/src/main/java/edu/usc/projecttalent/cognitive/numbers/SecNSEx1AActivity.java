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

import edu.usc.projecttalent.cognitive.R;
import edu.usc.projecttalent.cognitive.databinding.ActivitySecNsex1ABinding;

public class SecNSEx1AActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

        final NSExample example = (NSExample) getIntent().getExtras().get("example");
        final Context mContext = this;

        ActivitySecNsex1ABinding binding = DataBindingUtil.setContentView(this, R.layout.activity_sec_nsex1_a);
        binding.setItem(example);

        LinearLayout series = (LinearLayout) findViewById(R.id.series);
        final EditText answer= (EditText) findViewById(R.id.answer);
        series.removeView(answer);
        series.addView(answer, example.ansPosition);

		Button button = (Button) findViewById(R.id.next);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent;
                if(example.id == 1) {
                    intent = new Intent(mContext, SecNS_Activity.class);
                    intent.putExtra("second", true);
                } else {
                    intent = new Intent(mContext, SecNSIntro_Activity.class);
                }
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

}
