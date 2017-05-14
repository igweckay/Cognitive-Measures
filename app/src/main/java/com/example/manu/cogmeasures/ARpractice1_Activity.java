package com.example.manu.cogmeasures;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class ARpractice1_Activity extends Activity {
	boolean[] selected={false,false,false,false,false};
	ImageView img1,img2,img3,img4,img5;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_arpractice1_);

		ImageView myImage = (ImageView) findViewById(R.id.question_image);
		myImage.setImageBitmap(ImageDecoder.decodeImage(getResources(),R.drawable.ar_002_main,myImage.getLayoutParams().width,myImage.getLayoutParams().height));
		img1 = (ImageView) findViewById(R.id.imageView1);
		img1.setImageBitmap(ImageDecoder.decodeImage(getResources(),R.drawable.ar_002_1,myImage.getLayoutParams().width,myImage.getLayoutParams().height));

		img2 = (ImageView) findViewById(R.id.imageView2);
		img2.setImageBitmap(ImageDecoder.decodeImage(getResources(),R.drawable.ar_002_2,myImage.getLayoutParams().width,myImage.getLayoutParams().height));

		img3 = (ImageView) findViewById(R.id.imageView3);
		img3.setImageBitmap(ImageDecoder.decodeImage(getResources(),R.drawable.ar_002_3,myImage.getLayoutParams().width,myImage.getLayoutParams().height));

		img4 = (ImageView) findViewById(R.id.imageView4);
		img4.setImageBitmap(ImageDecoder.decodeImage(getResources(),R.drawable.ar_002_4,myImage.getLayoutParams().width,myImage.getLayoutParams().height));

		img5 = (ImageView) findViewById(R.id.imageView5);
		img5.setImageBitmap(ImageDecoder.decodeImage(getResources(),R.drawable.ar_002_5,myImage.getLayoutParams().width,myImage.getLayoutParams().height));

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
            	if(selected[4]) {
            		Intent intent = new Intent(ARpractice1_Activity.this, ARpracticeCorrect_Activity.class);
					startActivityForResult(intent,1);
            	}
            	else {
            		Intent intent = new Intent(ARpractice1_Activity.this, ARpracticeWrong_Activity.class);
					startActivityForResult(intent,1);
            	}
            		
            	
            }
        });
        button = (Button) findViewById(R.id.button4);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
            	Intent intent = new Intent(ARpractice1_Activity.this, ARans1_Activity.class);
				startActivityForResult(intent,1);
            	
            }
        });
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// Check which request we're responding to
		Log.d("ARPracticee1",  "onActivityResult - ARPractice1");
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
