package edu.usc.projecttalent.cognitive;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.Date;

import edu.usc.projecttalent.cognitive.vocab.VO31_Activity;

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
                Intent intent = new Intent(MainActivity.this, VO31_Activity.class);
                startActivityForResult(intent,1);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        Log.d("Main Activity",  "onActivityResult - Main Activity");
        if (requestCode == 1) {
            if (resultCode == RESULT_OK) {
                String output = data.getExtras().get("jsonData").toString();
                Log.d("final result", output);
                setResult(Activity.RESULT_OK, data);
                super.finish();
            }
        }
    }

    @Override
    public void onBackPressed() {}
}
