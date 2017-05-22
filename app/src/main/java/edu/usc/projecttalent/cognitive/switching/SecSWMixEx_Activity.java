package edu.usc.projecttalent.cognitive.switching;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import edu.usc.projecttalent.cognitive.R;

public class SecSWMixEx_Activity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sec_swmix_ex_);
		Button button = (Button) findViewById(R.id.next);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click

            	    Intent intent = new Intent(SecSWMixEx_Activity.this, SWMixEx1_Activity.class);
            	    startActivity(intent);
            }
        });
	}
}
