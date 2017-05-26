package edu.usc.projecttalent.cognitive.numbers;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import edu.usc.projecttalent.cognitive.R;

public class SecNS_Activity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sec_ns_);
        LinearLayout numPad = (LinearLayout) findViewById(R.id.numpad);
        final EditText answer= (EditText) findViewById(R.id.answer);
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

        (findViewById(R.id.button3)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
    			Intent intent = new Intent(SecNS_Activity.this, SecNSEx1AActivity.class);
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
