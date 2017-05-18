package edu.usc.projecttalent.cognitive.reasoning;

import java.util.Date;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import edu.usc.projecttalent.cognitive.FinishActivity;
import edu.usc.projecttalent.cognitive.ImageDecoder;
import edu.usc.projecttalent.cognitive.MyGlobalVariables;
import edu.usc.projecttalent.cognitive.R;

public class AR22_Activity extends Activity {
	boolean[] selected={false,false,false,false,false};
	boolean click = false; int count=0;long ms;boolean empty=false, exit = false;
	ImageView img1,img2,img3,img4,img5;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_ar22_);
		Date start = new Date();
		String s = MyGlobalVariables.getTime();
		s+="ar22_start:"+start.toString()+";";
		MyGlobalVariables.setTime(s);
		ImageView myImage = (ImageView) findViewById(R.id.question_image);
	    myImage.setImageBitmap(ImageDecoder.decodeImage(getResources(),R.drawable.ar_3_main,myImage.getLayoutParams().width,myImage.getLayoutParams().height));

	    myImage = (ImageView) findViewById(R.id.imageView1);
	    myImage.setImageBitmap(ImageDecoder.decodeImage(getResources(),R.drawable.ar_3_1,myImage.getLayoutParams().width,myImage.getLayoutParams().height));

	    myImage = (ImageView) findViewById(R.id.imageView2);
	    myImage.setImageBitmap(ImageDecoder.decodeImage(getResources(),R.drawable.ar_3_2,myImage.getLayoutParams().width,myImage.getLayoutParams().height));

	    myImage = (ImageView) findViewById(R.id.imageView3);
	    myImage.setImageBitmap(ImageDecoder.decodeImage(getResources(),R.drawable.ar_3_3,myImage.getLayoutParams().width,myImage.getLayoutParams().height));

	    myImage = (ImageView) findViewById(R.id.imageView4);
	    myImage.setImageBitmap(ImageDecoder.decodeImage(getResources(),R.drawable.ar_3_4,myImage.getLayoutParams().width,myImage.getLayoutParams().height));

	    myImage = (ImageView) findViewById(R.id.imageView5);
	    myImage.setImageBitmap(ImageDecoder.decodeImage(getResources(),R.drawable.ar_3_5,myImage.getLayoutParams().width,myImage.getLayoutParams().height));

		////This function can be used. ///////
		timeOutUser();
		runCountDownTimer();
		Button resumeButton = (Button) findViewById(R.id.resume);
		resumeButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				RelativeLayout questionArea = (RelativeLayout) findViewById(R.id.main_layout);
				questionArea.setVisibility(View.VISIBLE);
				RelativeLayout quitResumeArea = (RelativeLayout) findViewById(R.id.quit_resume_layout);
				quitResumeArea.setVisibility(View.INVISIBLE);
				runCountDownTimer();
			}
		});

		Button quitButton = (Button) findViewById(R.id.quit);
		quitButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				recordEndTime();
				Intent intent = new Intent(AR22_Activity.this, FinishActivity.class);
				startActivityForResult(intent,1);
			}
		});

		//THE ABOVE CODE CAN BE USED ////


		  img1 = (ImageView) findViewById(R.id.imageView1);
			img2 = (ImageView) findViewById(R.id.imageView2);
			img3 = (ImageView) findViewById(R.id.imageView3);
			img4 = (ImageView) findViewById(R.id.imageView4);
			img5 = (ImageView) findViewById(R.id.imageView5);
			img1.setPadding(1, 1, 1, 1);
			img2.setPadding(1, 1, 1, 1);
			img3.setPadding(1, 1, 1, 1);
			img4.setPadding(1, 1, 1, 1);
			img5.setPadding(1, 1, 1, 1);
	        img1.setOnClickListener(new View.OnClickListener() {
	            public void onClick(View v) {
	                // Perform action on click
	            	selected[0]=true;
	            	selected[1]=false;
	            	selected[2]=false;
	            	selected[3]=false;
	            	selected[4]=false;
	            	img1.setBackgroundColor(Color.parseColor("#000000"));
	            	img2.setBackgroundColor(Color.parseColor("#FFFFFF"));
	            	img3.setBackgroundColor(Color.parseColor("#FFFFFF"));
	            	img4.setBackgroundColor(Color.parseColor("#FFFFFF"));
	            	img5.setBackgroundColor(Color.parseColor("#FFFFFF"));
	            }
	        });
	        img2.setOnClickListener(new View.OnClickListener() {
	            public void onClick(View v) {
	                // Perform action on click
	            	selected[0]=false;
	            	selected[1]=true;
	            	selected[2]=false;
	            	selected[3]=false;
	            	selected[4]=false;
	            	img1.setBackgroundColor(Color.parseColor("#FFFFFF"));
	            	img2.setBackgroundColor(Color.parseColor("#000000"));
	            	img3.setBackgroundColor(Color.parseColor("#FFFFFF"));
	            	img4.setBackgroundColor(Color.parseColor("#FFFFFF"));
	            	img5.setBackgroundColor(Color.parseColor("#FFFFFF"));
	            }
	        });
	        img3.setOnClickListener(new View.OnClickListener() {
	            public void onClick(View v) {
	                // Perform action on click
	            	selected[0]=false;
	            	selected[1]=false;
	            	selected[2]=true;
	            	selected[3]=false;
	            	selected[4]=false;
	            	img1.setBackgroundColor(Color.parseColor("#FFFFFF"));
	            	img2.setBackgroundColor(Color.parseColor("#FFFFFF"));
	            	img3.setBackgroundColor(Color.parseColor("#000000"));
	            	img4.setBackgroundColor(Color.parseColor("#FFFFFF"));
	            	img5.setBackgroundColor(Color.parseColor("#FFFFFF"));
	            }
	        });
	        img4.setOnClickListener(new View.OnClickListener() {
	            public void onClick(View v) {
	                // Perform action on click
	            	selected[0]=false;
	            	selected[1]=false;
	            	selected[2]=false;
	            	selected[3]=true;
	            	selected[4]=false;
	            	img1.setBackgroundColor(Color.parseColor("#FFFFFF"));
	            	img2.setBackgroundColor(Color.parseColor("#FFFFFF"));
	            	img3.setBackgroundColor(Color.parseColor("#FFFFFF"));
	            	img4.setBackgroundColor(Color.parseColor("#000000"));
	            	img5.setBackgroundColor(Color.parseColor("#FFFFFF"));
	            }
	        });
	        img5.setOnClickListener(new View.OnClickListener() {
	            public void onClick(View v) {
	                // Perform action on click
	            	selected[0]=false;
	            	selected[1]=false;
	            	selected[2]=false;
	            	selected[3]=false;
	            	selected[4]=true;
	            	img1.setBackgroundColor(Color.parseColor("#FFFFFF"));
	            	img2.setBackgroundColor(Color.parseColor("#FFFFFF"));
	            	img3.setBackgroundColor(Color.parseColor("#FFFFFF"));
	            	img4.setBackgroundColor(Color.parseColor("#FFFFFF"));
	            	img5.setBackgroundColor(Color.parseColor("#000000"));
	            }
	        });
      Button button = (Button) findViewById(R.id.button3);
      button.setOnClickListener(new View.OnClickListener() {
          public void onClick(View v) {
              // Perform action on click
          	click = true;count++;
          	String s = MyGlobalVariables.getData();
      		if (s.contains("ar22:")){
      			int p=s.indexOf("ar22:");
      			s = s.substring(0,p);
      		}
          	if (selected[0] || selected[1] || selected[2] || selected[3] || selected[4])
          	{
          		int u=0;
          		if(selected[0])u=1;
          		else if(selected[1])u=2;
          		else if(selected[2])u=3;
          		else if(selected[3])u=4;
          		else if(selected[4])u=5;
          		s+="ar22:"+Integer.toString(u)+";";
          	}
          	else
          	{
          		s+="ar22:0"+";";

              		TextView tv = (TextView) findViewById(R.id.message);
              		String t = getResources().getString(R.string.msg3);
         				 tv.setText(t);
         				 tv.setVisibility(View.VISIBLE);
         				 empty=true;
          	}
          	MyGlobalVariables.setData(s);
          	if((click && count>=2)){
          		click = false;
          		TextView tv = (TextView) findViewById(R.id.message);
          		tv.setVisibility(View.INVISIBLE);
          		recordEndTime();
          		Intent intent = new Intent(AR22_Activity.this, AR23_Activity.class);
				startActivityForResult(intent,1);
          	}
          }
      });
	}

	/////This function can be used /////
	public void runCountDownTimer()
	{

		click = false;
		count = 0;
		new CountDownTimer(18000, 1000) {

			public void onTick(long millisUntilFinished) {
				ms=millisUntilFinished;
				if( !click &&  millisUntilFinished <= 12000 ){
					//We should display a new message and arrange everything for just one click to enter the next activity.
					TextView tv = (TextView) findViewById(R.id.message);
					String t = getResources().getString(R.string.msg2);
					tv.setText(t);
					tv.setVisibility(View.VISIBLE);
					count++;
				}
				else if(click && !empty)
				{
					click = false;
					TextView tv = (TextView) findViewById(R.id.message);
					tv.setVisibility(View.INVISIBLE);
					recordEndTime();
					Intent intent = new Intent(AR22_Activity.this, AR23_Activity.class);
					startActivityForResult(intent,1);
				}
			}
			public void onFinish() {
				if(!click){
					//On finishing the 180 seconds, take the user to Quit/Resume activity.
					TextView tv = (TextView) findViewById(R.id.message);
					tv.setVisibility(View.INVISIBLE);
					RelativeLayout questionArea = (RelativeLayout) findViewById(R.id.main_layout);
					questionArea.setVisibility(View.INVISIBLE);
					RelativeLayout quitResumeArea = (RelativeLayout) findViewById(R.id.quit_resume_layout);
					quitResumeArea.setVisibility(View.VISIBLE);
				}
			}
		}.start();
		return;
	}

	/////This function can be used /////
	public void timeOutUser()
	{

		//Actual time should be for 2 hrs. Need to change the seconds.
		new CountDownTimer(25000, 1000) {

			@Override
			public void onTick(long l) {

			}

			public void onFinish() {
				if(!click & !exit ){
					//On finishing the 180 seconds, take the user to Quit/Resume activity.
					recordEndTime();
					Intent intent = new Intent(AR22_Activity.this, ARIntro_Activity.class);
					startActivityForResult(intent,1);
				}
			}
		}.start();
		return;
	}

	private void recordEndTime()
	{
		exit = true;
		Date end = new Date();
		String s = MyGlobalVariables.getTime();
		s+="ar22_end:"+end.toString()+";";
		MyGlobalVariables.setTime(s);
	}

	@Override
	public void onBackPressed()
	{

	   //thats it
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// Check which request we're responding to
		Log.d("AR22",  "onActivityResult - AR22");
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
