package edu.usc.projecttalent.cognitive.switching;

import java.util.Date;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import edu.usc.projecttalent.cognitive.MyGlobalVariables;
import edu.usc.projecttalent.cognitive.R;

public class SWsetNorm1_Activity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_swset_norm1_);
		Date start = new Date();
   		String s = MyGlobalVariables.getData();
   		s+="swset3_start:"+start.toString()+";";
   		MyGlobalVariables.setData(s);
		Button button = (Button) findViewById(R.id.button2);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click

            	    Intent intent = new Intent(SWsetNorm1_Activity.this, SWset31_Activity.class);
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
