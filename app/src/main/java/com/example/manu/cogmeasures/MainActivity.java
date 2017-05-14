package com.example.manu.cogmeasures;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.Date;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Date start = new Date();
        MyGlobalVariables.setData("");
        MyGlobalVariables.setTime("");
        String s = MyGlobalVariables.getData();
        s+="sur_start:"+start.toString()+";";
        MyGlobalVariables.setData(s);
        Button button = (Button) findViewById(R.id.button3);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
                Intent intent = new Intent(MainActivity.this, ARIntro_Activity.class);
                startActivityForResult(intent,1);
            }
        });
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // Check which request we're responding to
        Log.d("Main Activity",  "onActivityResult - Main Activity");
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


    @Override
    public void onBackPressed() {
        //do nothing.
    }
}
