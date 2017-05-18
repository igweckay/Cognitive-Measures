package edu.usc.projecttalent.cognitive.switching;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import edu.usc.projecttalent.cognitive.R;

public class SecSWMixedIntro_Activity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sec_swmixed_intro_);
		Button button = (Button) findViewById(R.id.button2);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click

            	    Intent intent = new Intent(SecSWMixedIntro_Activity.this, SecSWMixEx_Activity.class);
            	    startActivity(intent);
            }
        });
	}
	@Override
	public void onBackPressed()
	{

	   //thats it
	}
}
