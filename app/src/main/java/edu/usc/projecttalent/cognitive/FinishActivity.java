package edu.usc.projecttalent.cognitive;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.google.gson.Gson;

import edu.usc.projecttalent.cognitive.model.Survey;

public class FinishActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finish);
        Button button = (Button) findViewById(R.id.finish);
        final Survey survey = Survey.getSurvey();
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                survey.endSurvey();
                Gson gson = new Gson();
                String output = gson.toJson(survey);
                Intent intent = new Intent();
                intent.putExtra("json", output);
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }

    @Override
    public void onBackPressed() {}
}
