package com.example.cogusa;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecSWRevEx_Activity extends Activity {
	int count=0;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sec_swrev_ex_);
		Button stop = (Button) findViewById(R.id.stop);
        stop.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
            	if(count==0){
            		String str=getResources().getString(R.string.error_ex2);
            		TextView tv = (TextView) findViewById(R.id.textView2);
            		tv.setText(str);
            		tv.setVisibility(View.VISIBLE);
            		//tv.setVisibility(View.VISIBLE);
            	}
            	else if(count==1){
            		TextView tv1 = (TextView) findViewById(R.id.textView2);
            		tv1.setVisibility(View.INVISIBLE);
            		Intent intent = new Intent(SecSWRevEx_Activity.this, SWRevIntro_Activity.class);
            	    startActivity(intent);
            	}
            }
        });
        Button go = (Button) findViewById(R.id.go);
        go.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
            	if(count==0){
            		TextView tv1 = (TextView) findViewById(R.id.textView2);
            		tv1.setVisibility(View.INVISIBLE);
            		String str=getResources().getString(R.string.rev_ex2);
            		TextView tv = (TextView) findViewById(R.id.textView1);
            		tv.setText(str);            		
            		count=1;
            	}
            	else if(count==1){
            		String str=getResources().getString(R.string.error_ex1);
            		TextView tv = (TextView) findViewById(R.id.textView2);
            		tv.setText(str);
            		tv.setVisibility(View.VISIBLE);
            		
            	}
            }
        });
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.sec_swrev_ex_, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
