package edu.usc.projecttalent.cognitive.reasoning;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import edu.usc.projecttalent.cognitive.R;

public class ARIntro_Activity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_arintro_);
		Button button = (Button) findViewById(R.id.button3);
		//reset the data here.
		//todo Need to see the data from the previus step should  be overridden.
		/**String s = MyGlobalVariables.getData();
		if( s.contains("ar31") )
			s=s.substring(0,s.indexOf("ar31"));
		MyGlobalVariables.setData(s);**/
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
            		Intent intent = new Intent(ARIntro_Activity.this, AR31_Activity.class);
				startActivityForResult(intent,1);

            }
        });
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// Check which request we're responding to
		Log.d("ARIntro",  "onActivityResult - ARIntro");
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
