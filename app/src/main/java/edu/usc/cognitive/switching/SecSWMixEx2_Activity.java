package edu.usc.cognitive.switching;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import edu.usc.cognitive.R;

public class SecSWMixEx2_Activity extends Activity {
	int count=0;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sec_swmix_ex2_);
		Button stop = (Button) findViewById(R.id.stop);
        stop.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
            	if(count==0){
            		TextView tv1 = (TextView) findViewById(R.id.textView2);
            		tv1.setVisibility(View.INVISIBLE);
            		String str=getResources().getString(R.string.mix_ex5);
            		TextView tv = (TextView) findViewById(R.id.textView1);
            		tv.setText(str);
            		count=1;

            		//tv.setVisibility(View.VISIBLE);
            	}
            	else if(count==1 || count==2){
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
            		String str=getResources().getString(R.string.mix_ex6);
            		TextView tv = (TextView) findViewById(R.id.textView1);
            		tv.setText(str);
            		count=2;
            	}
            	else if(count==2){
            		TextView tv1 = (TextView) findViewById(R.id.textView2);
            		tv1.setVisibility(View.INVISIBLE);
            		Intent intent = new Intent(SecSWMixEx2_Activity.this, SWTransit_Activity.class);
            	    startActivity(intent);
            	}
            }
        });
	}
}
