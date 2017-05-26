package edu.usc.projecttalent.cognitive;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.google.gson.Gson;

import edu.usc.projecttalent.cognitive.model.Survey;
import edu.usc.projecttalent.cognitive.numbers.SecNS_Activity;

public class FinishActivity extends AppCompatActivity {

    Class nextClass;
    Context mContext;
    public static final String SECTION = "section";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finish);
        Button button = (Button) findViewById(R.id.finish);
        mContext = this;
        final String nextItem = getIntent().getStringExtra("section");

        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                switch(nextItem) {
                    case "number":
                       nextClass = SecNS_Activity.class;
                        break;
                    default:
                        nextClass = FinishActivity.class;
                }

                if(nextClass == FinishActivity.class) {
                    Survey survey = Survey.getSurvey();
                    survey.endSurvey();
                    Gson gson = new Gson();
                    String output = gson.toJson(survey);
                    Intent intent = new Intent();
                    intent.putExtra("json", output);
                    setResult(RESULT_OK, intent);
                } else {
                    Intent intent = new Intent(mContext, nextClass);
                    startActivityForResult(intent, 1);
                }
                finish();
            }
        });
    }

    @Override
    public void onBackPressed() {}
}
