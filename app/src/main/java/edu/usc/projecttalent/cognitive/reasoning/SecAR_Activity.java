package edu.usc.projecttalent.cognitive.reasoning;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import edu.usc.projecttalent.cognitive.ImageDecoder;
import edu.usc.projecttalent.cognitive.R;

public class SecAR_Activity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		ImageView img1,img2,img3,img4,img5;
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sec_ar_);
		/** Need to set the bitmap image code here
		 *
		 */
		ImageView myImage = (ImageView) findViewById(R.id.question_image);
		myImage.setImageBitmap(ImageDecoder.decodeImage(getResources(),R.drawable.ar_001_main,myImage.getLayoutParams().width,myImage.getLayoutParams().height));

		img1 = (ImageView) findViewById(R.id.imageView1);
		img1.setImageBitmap(ImageDecoder.decodeImage(getResources(),R.drawable.ar_001_1,myImage.getLayoutParams().width,myImage.getLayoutParams().height));

		img2 = (ImageView) findViewById(R.id.imageView2);
		img2.setImageBitmap(ImageDecoder.decodeImage(getResources(),R.drawable.ar_001_2,myImage.getLayoutParams().width,myImage.getLayoutParams().height));

		img3 = (ImageView) findViewById(R.id.imageView3);
		img3.setImageBitmap(ImageDecoder.decodeImage(getResources(),R.drawable.ar_001_3,myImage.getLayoutParams().width,myImage.getLayoutParams().height));

		img4 = (ImageView) findViewById(R.id.imageView4);
		img4.setImageBitmap(ImageDecoder.decodeImage(getResources(),R.drawable.ar_001_4,myImage.getLayoutParams().width,myImage.getLayoutParams().height));

		img5 = (ImageView) findViewById(R.id.imageView5);
		img5.setImageBitmap(ImageDecoder.decodeImage(getResources(),R.drawable.ar_001_5,myImage.getLayoutParams().width,myImage.getLayoutParams().height));


		img1.setPadding(1, 1, 1, 1);
		img2.setPadding(1, 1, 1, 1);
		img3.setPadding(1, 1, 1, 1);
		img4.setPadding(1, 1, 1, 1);
		img5.setPadding(1, 1, 1, 1);
        Button button = (Button) findViewById(R.id.button3);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
            	Intent intent = new Intent(SecAR_Activity.this, ARans1_Activity.class);
            	startActivityForResult(intent,1);

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
		Log.d("SecAR",  "onActivityResult - SecAR Activity");
		if (requestCode == 1) {
			// Make sure the request was successful
			if (resultCode == RESULT_OK) {
				// The user picked a contact.
				// The Intent's data Uri identifies which contact was selected.

				// Do something with the contact here (bigger example below)
				String output = data.getExtras().get("jsonData").toString();
				Log.d("final result", output);
				setResult(Activity.RESULT_OK, data);
				super.finish();
			}
		}
	}
}
