package edu.usc.projecttalent.cognitive.switching;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import edu.usc.projecttalent.cognitive.R;

public class SecSWMixEx4_Activity extends Activity {
	int count=0;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sec_swmix_ex4_);
		Button stop = (Button) findViewById(R.id.stop);
        stop.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
            	if(count==0){
            		TextView tv1 = (TextView) findViewById(R.id.textView2);
            		tv1.setVisibility(View.INVISIBLE);
            		String str=getResources().getString(R.string.red);
            		TextView tv = (TextView) findViewById(R.id.textView1);
            		tv.setText(str);
            		count=1;

            		//tv.setVisibility(View.VISIBLE);
            	}
            	else if(count==1){
            		String str=getResources().getString(R.string.error_ex2);
            		TextView tv = (TextView) findViewById(R.id.textView2);
            		tv.setText(str);
            		tv.setVisibility(View.VISIBLE);

            	}
            }
        });
        Button go = (Button) findViewById(R.id.go);
        go.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
            	if(count==0){
            		String str=getResources().getString(R.string.error_ex1);
            		TextView tv = (TextView) findViewById(R.id.textView2);
            		tv.setText(str);
            		tv.setVisibility(View.VISIBLE);
            	}
            	else if(count==1){
            		TextView tv1 = (TextView) findViewById(R.id.textView2);
            		tv1.setVisibility(View.INVISIBLE);
            		Intent intent = new Intent(SecSWMixEx4_Activity.this, SWMixIntro_Activity.class);
            	    startActivity(intent);

            	}
            }
        });
	}
}
