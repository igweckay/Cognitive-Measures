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
import edu.usc.projecttalent.cognitive.reasoning.SecAR_Activity;

public class FinishActivity extends AppCompatActivity {

    Class nextClass;
    Context mContext;
    public static final String SECTION = "section",
                                JSON = "json";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finish);
        Button button = (Button) findViewById(R.id.finish);
        mContext = this;
        final int nextItem = getIntent().getIntExtra(SECTION, 0);

        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                switch(nextItem) {
                    case R.string.switch_ns:
                       nextClass = SecNS_Activity.class;
                        break;
                    case R.string.switch_ar:
                        nextClass = SecAR_Activity.class;
                    default:
                        Survey survey = Survey.getSurvey();
                        survey.endSurvey();
                        Intent intent = new Intent();
                        intent.putExtra(JSON,  new Gson().toJson(survey));
                        setResult(RESULT_OK, intent);
                        QuestionTimer.stopTimer(); //to prevent new on-ticks after activity closes.
                        finish();
                        return;
                }
                startActivityForResult(new Intent(mContext, nextClass), 1);
                finish();
            }
        });
    }

    @Override
    public void onBackPressed() {}
}
