package com.example.manu.cogmeasures;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SecNSEx2A_Activity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sec_nsex2_a_);
		EditText et = (EditText) findViewById(R.id.editText1);
		et.setText("8");
		Button button = (Button) findViewById(R.id.button3);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
    			Intent intent = new Intent(SecNSEx2A_Activity.this, SecNSIntro_Activity.class);
        	    //startActivity(intent);
				startActivityForResult(intent, 1);
            }
        });
	}



    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // Check which request we're responding to
        Log.d("SecNSEx2A",  "onActivityResult - SecNSEx2A_Activity");
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
