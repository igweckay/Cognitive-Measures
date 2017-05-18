package edu.usc.projecttalent.cognitive.numbers;

//import java.util.Timer;
//import java.util.TimerTask;

import java.util.Date;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import edu.usc.projecttalent.cognitive.MyGlobalVariables;
import edu.usc.projecttalent.cognitive.R;
//import android.widget.Toast;
//import android.widget.Toast;

public class Set3Item1Activity extends Activity {
	boolean click = false; int count=0;long ms;boolean empty=false;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_set3_item1);
		Date start = new Date();
		String s = MyGlobalVariables.getTime();
		s+="sec_ns_start:"+start.toString()+";";
		s+="nsa31_start:"+start.toString()+";";
		MyGlobalVariables.setTime(s);
		count=0;
		new CountDownTimer(60000, 1000) {

		     public void onTick(long millisUntilFinished) {
		    	 ms=millisUntilFinished;
		    	if(millisUntilFinished>=55000 && click && !empty){
		    		click = false;
		    		TextView tv = (TextView) findViewById(R.id.message);
		    			 String t = getResources().getString(R.string.msg1);
		    			 tv.setText(t);
		    			 tv.setVisibility(View.VISIBLE);
		    		 }
		    	else if(click && !empty)
		    	{
		    		click = false;
		    		TextView tv = (TextView) findViewById(R.id.message);
	        		tv.setVisibility(View.INVISIBLE);
	        		Date end = new Date();
	        		String s = MyGlobalVariables.getTime();
	        		s+="nsa31_end:"+end.toString()+";";
	        		MyGlobalVariables.setTime(s);
		    		Intent intent = new Intent(Set3Item1Activity.this, Set3Item2_Activity.class);
            	    //startActivity(intent);
					startActivityForResult(intent,1);
		    	}
		     }
		     public void onFinish() {
		         if(!click){
		        	 TextView tv = (TextView) findViewById(R.id.message);
		             	String t = getResources().getString(R.string.msg2);
		             	tv.setText(t);
		             	tv.setVisibility(View.VISIBLE);
		             	count++;
		         }
		     }
		  }.start();
		Button button = (Button) findViewById(R.id.Button09);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
            	EditText uid=(EditText) findViewById(R.id.editText1);
            	String u=uid.getText().toString();
            	u+='0';
            	uid.setText(u);
            }
        });
        button = (Button) findViewById(R.id.Button11);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
            	EditText uid=(EditText) findViewById(R.id.editText1);
            	String u=uid.getText().toString();
            	u+='9';
            	uid.setText(u);
            }
        });
        button = (Button) findViewById(R.id.Button01);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
            	EditText uid=(EditText) findViewById(R.id.editText1);
            	String u=uid.getText().toString();
            	u+='8';
            	uid.setText(u);
            }
        });
        button = (Button) findViewById(R.id.Button09);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
            	EditText uid=(EditText) findViewById(R.id.editText1);
            	String u=uid.getText().toString();
            	u+='0';
            	uid.setText(u);
            }
        });
        button = (Button) findViewById(R.id.Button02);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
            	EditText uid=(EditText) findViewById(R.id.editText1);
            	String u=uid.getText().toString();
            	u+='7';
            	uid.setText(u);
            }
        });
        button = (Button) findViewById(R.id.Button03);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
            	EditText uid=(EditText) findViewById(R.id.editText1);
            	String u=uid.getText().toString();
            	u+='6';
            	uid.setText(u);
            }
        });
        button = (Button) findViewById(R.id.Button04);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
            	EditText uid=(EditText) findViewById(R.id.editText1);
            	String u=uid.getText().toString();
            	u+='5';
            	uid.setText(u);
            }
        });
        button = (Button) findViewById(R.id.Button05);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
            	EditText uid=(EditText) findViewById(R.id.editText1);
            	String u=uid.getText().toString();
            	u+='4';
            	uid.setText(u);
            }
        });
        button = (Button) findViewById(R.id.Button06);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
            	EditText uid=(EditText) findViewById(R.id.editText1);
            	String u=uid.getText().toString();
            	u+='3';
            	uid.setText(u);
            }
        });
        button = (Button) findViewById(R.id.Button07);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
            	EditText uid=(EditText) findViewById(R.id.editText1);
            	String u=uid.getText().toString();
            	u+='2';
            	uid.setText(u);
            }
        });
        button = (Button) findViewById(R.id.Button08);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
            	EditText uid=(EditText) findViewById(R.id.editText1);
            	String u=uid.getText().toString();
            	u+='1';
            	uid.setText(u);
            }
        });
        button = (Button) findViewById(R.id.button9);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
            	EditText uid=(EditText) findViewById(R.id.editText1);
            	uid.setText("");
            }
        });
        button = (Button) findViewById(R.id.button3);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
            	click = true;count++;
            	EditText uid=(EditText) findViewById(R.id.editText1);
            	String u=uid.getText().toString();
            	String s = MyGlobalVariables.getData();
        		if (s.contains("nsa31:")){
        			int p=s.indexOf("nsa31:");
        			s = s.substring(0,p);
        		}
            	if (u.length()!=0)
            	{
            		//MyGlobalVariables g = new MyGlobalVariables();
            		s+="nsa31:"+u+";";

            	}

            	if(u.length()==0)
            	{
            		s+="nsa31:"+"-1"+";";

                		TextView tv = (TextView) findViewById(R.id.message);
                		String t = getResources().getString(R.string.msg3);
           				 tv.setText(t);
           				 tv.setVisibility(View.VISIBLE);
           				 empty=true;
            	}
            	MyGlobalVariables.setData(s);
            	if((click && count>=2)){
            		//Toast.makeText(getBaseContext(), MyGlobalVariables.getData(), Toast.LENGTH_LONG).show();
            		click = false;
            		TextView tv = (TextView) findViewById(R.id.message);
            		tv.setVisibility(View.INVISIBLE);
            		Date end = new Date();
	        		 s = MyGlobalVariables.getTime();
	        		s+="nsa31_end:"+end.toString()+";";
	        		MyGlobalVariables.setTime(s);
            		Intent intent = new Intent(Set3Item1Activity.this, Set3Item2_Activity.class);
            	    //startActivity(intent);
					startActivityForResult(intent,1);
            	}
            }
        });
	}
	@Override
	public void onBackPressed()
	{

	   //thats it
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// Check which request we're responding to
        Log.d("Set3Item1",  "onActivityResult - Set3Item1_Activity");
		if (requestCode == 1) {
			// Make sure the request was successful
			if (resultCode == RESULT_OK) {
				// The user picked a contact.
				// The Intent's data Uri identifies which contact was selected.

				// Do something with the contact here (bigger example below)
				setResult(Activity.RESULT_OK, data);
				super.finish();
			}
		}
	}

}
