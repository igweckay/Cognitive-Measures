package edu.usc.cognitive;

import android.content.Intent;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class FinishActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finish);
        Button button = (Button) findViewById(R.id.finish);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Intent returnIntent = new Intent();
                //create the json object and do operations here and set that JSON object as a string and return from here.
                String res = buildJSONData();
                returnIntent.putExtra("jsonData", res);
                setResult(AppCompatActivity.RESULT_OK, returnIntent);
                finish();
            }
        });
    }


    private String buildJSONData()
    {
        JSONObject obj = new JSONObject();
        Date end = new Date();
        String s = MyGlobalVariables.getData();
        s += MyGlobalVariables.getTime();
        s+="sur_end:"+end.toString()+";";
        MyGlobalVariables.setData(s);
        String final_data = MyGlobalVariables.getData();
        String[] d = final_data.split(";");
        for(int i=0;i<d.length;i++) {
            String tag = d[i].substring(0, d[i].indexOf(':'));
            String value = d[i].substring(d[i].indexOf(':') + 1);
            boolean intg = false;
            if (tag.contains("_start") || tag.contains("_end")) {
                SimpleDateFormat sdf = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy");
                Date n = null;
                try {
                    n = sdf.parse(value);
                } catch (ParseException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                value = df.format(n);
                try {
                    obj.put(tag, value);
                } catch (JSONException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            } else {
                try {
                    Integer.parseInt(value);
                    intg = true;
                } catch (NumberFormatException ex) {
                    intg = false;
                }
                if (intg) {
                    try {
                        obj.put(tag, Integer.parseInt(value));
                    } catch (NumberFormatException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    } catch (JSONException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                } else {
                    try {
                        obj.put(tag, value);
                    } catch (JSONException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
            }
        }
        String result = obj.toString();
        return result;
    }


    @Override
    public void onBackPressed() {
        //do nothing.
    }
}
