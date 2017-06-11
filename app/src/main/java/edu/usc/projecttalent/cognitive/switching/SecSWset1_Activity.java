package edu.usc.projecttalent.cognitive.switching;

import java.util.Date;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import edu.usc.projecttalent.cognitive.MyGlobalVariables;
import edu.usc.projecttalent.cognitive.R;
import edu.usc.projecttalent.cognitive.spatial.SPpractice_Activity;

public class SecSWset1_Activity extends Activity {
	String[] seq={"GREEN","RED","GREEN","RED","RED","GREEN","RED","GREEN","RED","GREEN"};int i=0,score=0,miss=0;
	boolean[] click={false,false,false,false,false,false,false,false,false,false};CountDownTimer n;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sec_swset1_);
		Date start = new Date();
   		String s = MyGlobalVariables.getData();
   		s+="sec_sw_start:"+start.toString()+";";
   		s+="swset1_start:"+start.toString()+";";
   		MyGlobalVariables.setData(s);
		TextView tv = (TextView) findViewById(R.id.question_color);
		tv.setText(seq[i]);
		n = new CountDownTimer(12000, 1000) {

		     public void onTick(long millisUntilFinished) {
		    	if(millisUntilFinished<=5000 && !click[i]){
		    		TextView tv = (TextView) findViewById(R.id.error);
		    			 String t = getResources().getString(R.string.alert_error);
		    			 tv.setText(t);
		    			 tv.setVisibility(View.VISIBLE);

		    		 }
		     }
		     public void onFinish() {
		         if(!click[i]){
		        	 Button btn = (Button) findViewById(R.id.stop);
		        	 btn.setVisibility(View.INVISIBLE);
		        	 btn = (Button) findViewById(R.id.go);
		        	 btn.setVisibility(View.INVISIBLE);
		        	 TextView tv = (TextView) findViewById(R.id.question_color);
		             tv.setVisibility(View.INVISIBLE);

		        	 tv = (TextView) findViewById(R.id.error);
		             String t = getResources().getString(R.string.miss_error);
		             tv.setText(t);
		             tv.setVisibility(View.VISIBLE);
		             btn = (Button) findViewById(R.id.next);
		             btn.setVisibility(View.VISIBLE);

		         }
		     }
		  };
		  n.start();
		  Button button1 = (Button) findViewById(R.id.stop);
		  button1.setOnClickListener(new View.OnClickListener() {
	            public void onClick(View v) {
	                // Perform action on click
	            		click[i] = true;miss=0;
	            		if(seq[i].equalsIgnoreCase("RED"))score++;
	            		if(i==seq.length-1){
	            			String s = MyGlobalVariables.getData();
	                   		if (s.contains("swset1:")){
	                   			int p=s.indexOf("swset1:");
	                   			s = s.substring(0,p);
	                   		}
	                   		s+="swset1:"+Integer.toString(score)+";";
	                   		MyGlobalVariables.setData(s);
	                   		Date end = new Date();
	                   		s = MyGlobalVariables.getData();
	                   		s+="swset1_end:"+end.toString()+";";
	                   		MyGlobalVariables.setData(s);
	            			Intent intent = new Intent(SecSWset1_Activity.this, SecSWReverseIntro_Activity.class);
		            	    startActivity(intent);
	            		}
	            		else {

		            		 i++;
		            		 TextView tv = (TextView) findViewById(R.id.error);
				             tv.setVisibility(View.INVISIBLE);
				             Button btn = (Button) findViewById(R.id.next);
				             btn.setVisibility(View.INVISIBLE);
				             btn = (Button) findViewById(R.id.button1);
				             btn.setVisibility(View.INVISIBLE);
				             btn = (Button) findViewById(R.id.next);
				             btn.setVisibility(View.INVISIBLE);


		            		 btn = (Button) findViewById(R.id.stop);
				        	 btn.setVisibility(View.VISIBLE);
				        	 btn = (Button) findViewById(R.id.go);
				        	 btn.setVisibility(View.VISIBLE);
		            		 tv = (TextView) findViewById(R.id.question_color);
		            		 tv.setText(seq[i]);
		            		 tv.setVisibility(View.VISIBLE);
		            		 n.cancel();
		            		 n.start();
	            		}
	            }
	        });
		  Button button2 = (Button) findViewById(R.id.go);
		  button2.setOnClickListener(new View.OnClickListener() {
	            public void onClick(View v) {
	                // Perform action on click
	            		click[i] = true;miss=0;
	            		if(seq[i].equalsIgnoreCase("GREEN"))score++;
	            		if(i==seq.length-1){
	            			String s = MyGlobalVariables.getData();
	                   		if (s.contains("swset1:")){
	                   			int p=s.indexOf("swset1:");
	                   			s = s.substring(0,p);
	                   		}
	                   		s+="swset1:"+Integer.toString(score)+";";
	                   		MyGlobalVariables.setData(s);
	                   		Date end = new Date();
	                   		s = MyGlobalVariables.getData();
	                   		s+="swset1_end:"+end.toString()+";";
	                   		MyGlobalVariables.setData(s);
	            			Intent intent = new Intent(SecSWset1_Activity.this, SecSWReverseIntro_Activity.class);
		            	    startActivity(intent);
	            		}
	            		else {

		            		i++;
		            		TextView tv = (TextView) findViewById(R.id.error);
				             tv.setVisibility(View.INVISIBLE);
				             Button btn = (Button) findViewById(R.id.next);
				             btn.setVisibility(View.INVISIBLE);
				             btn = (Button) findViewById(R.id.button1);
				             btn.setVisibility(View.INVISIBLE);
				             btn = (Button) findViewById(R.id.next);
				             btn.setVisibility(View.INVISIBLE);


		            		 btn = (Button) findViewById(R.id.stop);
				        	 btn.setVisibility(View.VISIBLE);
				        	 btn = (Button) findViewById(R.id.go);
				        	 btn.setVisibility(View.VISIBLE);
		            		tv = (TextView) findViewById(R.id.question_color);
		            		tv.setText(seq[i]);
		            		tv.setVisibility(View.VISIBLE);
		            		n.cancel();
		            		n.start();
	            		}

	            }
	        });
		  Button btn = (Button) findViewById(R.id.next);
		  btn.setOnClickListener(new View.OnClickListener() {
	            public void onClick(View v) {
	                // Perform action on click
	            		miss++;
	            		if(miss==5){

	            			Button btn = (Button) findViewById(R.id.stop);
		   		        	 btn.setVisibility(View.INVISIBLE);
		   		        	 btn = (Button) findViewById(R.id.go);
		   		        	 btn.setVisibility(View.INVISIBLE);
		   		        	btn = (Button) findViewById(R.id.next);
		   		        	 btn.setVisibility(View.INVISIBLE);
		   		        	 TextView tv = (TextView) findViewById(R.id.question_color);
		   		             tv.setVisibility(View.INVISIBLE);


		   		             tv = (TextView) findViewById(R.id.error);
		   		             String t = getResources().getString(R.string.quit_error);
		   		             tv.setText(t);
				             tv.setVisibility(View.VISIBLE);
				             btn = (Button) findViewById(R.id.button1);
				             btn.setVisibility(View.VISIBLE);
				             btn = (Button) findViewById(R.id.next);
				             btn.setVisibility(View.VISIBLE);
	            		}
	            		else {
	            			if(i==seq.length-1){
	            				String s = MyGlobalVariables.getData();
		                   		if (s.contains("swset1:")){
		                   			int p=s.indexOf("swset1:");
		                   			s = s.substring(0,p);
		                   		}
		                   		s+="swset1:"+Integer.toString(score)+";";
		                   		MyGlobalVariables.setData(s);
		                   		Date end = new Date();
		                   		s = MyGlobalVariables.getData();
		                   		s+="swset1_end:"+end.toString()+";";
		                   		MyGlobalVariables.setData(s);
	                			Intent intent = new Intent(SecSWset1_Activity.this, SecSWReverseIntro_Activity.class);
	    	            	    startActivity(intent);
	                		}
	            			else{
			            		i++;
			            		TextView tv = (TextView) findViewById(R.id.error);
					             tv.setVisibility(View.INVISIBLE);
					             Button btn = (Button) findViewById(R.id.next);
					             btn.setVisibility(View.INVISIBLE);
					             btn = (Button) findViewById(R.id.button1);
					             btn.setVisibility(View.INVISIBLE);
					             btn = (Button) findViewById(R.id.next);
					             btn.setVisibility(View.INVISIBLE);


			            		 btn = (Button) findViewById(R.id.stop);
					        	 btn.setVisibility(View.VISIBLE);
					        	 btn = (Button) findViewById(R.id.go);
					        	 btn.setVisibility(View.VISIBLE);
			            		tv = (TextView) findViewById(R.id.question_color);
			            		tv.setText(seq[i]);
			            		tv.setVisibility(View.VISIBLE);
			            		n.cancel();
			            		n.start();
	            			}
	            		}
	            }
	        });
		  btn = (Button) findViewById(R.id.next);
		  btn.setOnClickListener(new View.OnClickListener() {
	            public void onClick(View v) {
	                // Perform action on click
	            	if(i==seq.length-1){
	            		String s = MyGlobalVariables.getData();
                   		if (s.contains("swset1:")){
                   			int p=s.indexOf("swset1:");
                   			s = s.substring(0,p);
                   		}
                   		s+="swset1:"+Integer.toString(score)+";";
                   		MyGlobalVariables.setData(s);
                   		Date end = new Date();
                   		s = MyGlobalVariables.getData();
                   		s+="swset1_end:"+end.toString()+";";
                   		MyGlobalVariables.setData(s);
            			Intent intent = new Intent(SecSWset1_Activity.this, SecSWReverseIntro_Activity.class);
	            	    startActivity(intent);
            		}
            		else {

	            		i++;
	            		TextView tv = (TextView) findViewById(R.id.error);
			             tv.setVisibility(View.INVISIBLE);
			             Button btn = (Button) findViewById(R.id.next);
			             btn.setVisibility(View.INVISIBLE);
			             btn = (Button) findViewById(R.id.button1);
			             btn.setVisibility(View.INVISIBLE);
			             btn = (Button) findViewById(R.id.next);
			             btn.setVisibility(View.INVISIBLE);


	            		 btn = (Button) findViewById(R.id.stop);
			        	 btn.setVisibility(View.VISIBLE);
			        	 btn = (Button) findViewById(R.id.go);
			        	 btn.setVisibility(View.VISIBLE);
	            		tv = (TextView) findViewById(R.id.question_color);
	            		tv.setText(seq[i]);
	            		tv.setVisibility(View.VISIBLE);
	            		n.cancel();
	            		n.start();
            		}
	            }
	        });
		  btn = (Button) findViewById(R.id.button1);
		  btn.setOnClickListener(new View.OnClickListener() {
	            public void onClick(View v) {
	                // Perform action on click

	            		String s = MyGlobalVariables.getData();
                   		if (s.contains("swset1:")){
                   			int p=s.indexOf("swset1:");
                   			s = s.substring(0,p);
                   		}
                   		s+="swset1:"+Integer.toString(score)+";";
                   		MyGlobalVariables.setData(s);
                   		Date end = new Date();
                   		s = MyGlobalVariables.getData();
                   		s+="swset1_end:"+end.toString()+";";
                   		MyGlobalVariables.setData(s);
            			Intent intent = new Intent(SecSWset1_Activity.this, SPpractice_Activity.class);
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
