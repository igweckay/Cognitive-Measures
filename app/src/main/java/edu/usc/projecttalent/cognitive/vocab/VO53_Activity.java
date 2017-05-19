package edu.usc.projecttalent.cognitive.vocab;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.Date;

import edu.usc.projecttalent.cognitive.FinishActivity;
import edu.usc.projecttalent.cognitive.MyGlobalVariables;
import edu.usc.projecttalent.cognitive.QuestionTimer;
import edu.usc.projecttalent.cognitive.R;
import edu.usc.projecttalent.cognitive.databinding.ActivityVocabBinding;
import edu.usc.projecttalent.cognitive.numbers.SecNS_Activity;

public class VO53_Activity extends AppCompatActivity {
    boolean click = false;
    boolean empty = false;
    int count = 0;
    Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vocab);

        Date start = new Date();
        String s = MyGlobalVariables.getTime();
        s += "vo53_start:" + start.toString() + ";";
        MyGlobalVariables.setTime(s);
        mContext = this;

        VocabItem item  = new VocabItem(getString(R.string.vo53), getResources().getStringArray(R.array.vo53a));
        ActivityVocabBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_vocab);
        binding.setItem(item);

        IntentFilter filter = new IntentFilter();
        filter.addAction(QuestionTimer.WARNING);
        filter.addAction(QuestionTimer.QUIT);
        filter.addAction(QuestionTimer.RESUME);
        registerReceiver(mReceiver, filter);
        final LinearLayout layout = (LinearLayout) findViewById(R.id.vocab_layout);
        QuestionTimer.startTimer(mContext);

        Button button = (Button) findViewById(R.id.next);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                click = true;
                count++;
                RadioGroup radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
                int selectedId = radioGroup.getCheckedRadioButtonId();
                String s = MyGlobalVariables.getData();
                int p;
                if (s.contains("vo53:")) {
                    p = s.indexOf("vo53:");
                    s = s.substring(0, p);
                }
                if (s.contains("vo53_score:")) {
                    p = s.indexOf("vo53_score:");
                    s = s.substring(0, p);
                }
                if (s.contains("vo53_ans:")) {
                    p = s.indexOf("vo53_ans:");
                    s = s.substring(0, p);
                }

                if (selectedId == -1) {
                    s += "vo53:0" + ";";
                    MyGlobalVariables.q31 = 0;
                    s += "vo53_score:" + MyGlobalVariables.qx3 + ";";
                    s += "vo53_ans:3;";

                    Snackbar snackbar = Snackbar.make(layout, R.string.msg2, Snackbar.LENGTH_LONG);
                    TextView tv = (TextView) snackbar.getView().findViewById(android.support.design.R.id.snackbar_text);
                    tv.setMaxLines(3);
                    snackbar.show();
                } else {
                    RadioButton radioButton = (RadioButton) findViewById(selectedId);
                    int idx = radioGroup.indexOfChild(radioButton);
                    if (idx == 3)
                        MyGlobalVariables.qx3 = 1;
                    s += "vo53:" + idx + ";";
                    s += "vo53_score:" + MyGlobalVariables.qx3 + ";";
                    s += "vo53_ans:3;";
                    empty = false;
                }
                MyGlobalVariables.setData(s);
                if (click && count >= 2) {
                    click = false;
                    recordEndTime();
                    Intent intent = new Intent(mContext, SecNS_Activity.class);
                    startActivityForResult(intent, 1);
                }
            }
        });
    }

    BroadcastReceiver mReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if(action.equals(QuestionTimer.WARNING)) {
                count++;
                QuestionTimer.updateContext(mContext);
            } else {
                if(action.equals(QuestionTimer.QUIT)) {
                    recordEndTime();
                    Intent next = new Intent(mContext, FinishActivity.class);
                    startActivityForResult(next, 1);
                }
                QuestionTimer.startTimer(mContext);
            }
        }
    };

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 1) {
            if (resultCode == RESULT_OK) {
                setResult(Activity.RESULT_OK, data);
                super.finish();
            }
        }
    }

    @Override
    public void onBackPressed() {}

    private void recordEndTime() {
        Date end = new Date();
        String s = MyGlobalVariables.getTime();
        s += "vo53_end:" + end.toString() + ";";
        s += "sec_vo_end:" + end.toString() + ";";
        String t = MyGlobalVariables.getData();
        t += s;
        MyGlobalVariables.setData(t);
        MyGlobalVariables.setTime("");
    }
}