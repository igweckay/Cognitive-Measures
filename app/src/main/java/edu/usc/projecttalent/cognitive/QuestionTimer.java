package edu.usc.projecttalent.cognitive;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.CountDownTimer;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by anind on 5/18/2017.
 */

public class QuestionTimer extends CountDownTimer {

    private static QuestionTimer mTimer;
    private static Context mContext;
    private static AlertDialog mWarningDialog;
    private static AlertDialog mQuitDialog;
    static boolean shown;

    public static final String WARNING = "cognitive.timewarning";
    public static final String QUIT = "cognitive.quit";
    public static final String RESUME = "cognitive.resume";


    private QuestionTimer(long millisInFuture, long countDownInterval, Context context) {
        super(millisInFuture, countDownInterval);
        mContext = context;
        shown = false;
    }

    @Override
    public void onTick(long millisUntilFinished) {
        if(millisUntilFinished <= 60*1000 && !shown) {
            mWarningDialog.show();
            shown = true;
            mContext.sendBroadcast(new Intent(WARNING));
        }
    }

    @Override
    public void onFinish() {
        if(mWarningDialog.isShowing())
            mWarningDialog.dismiss();
        mQuitDialog.show();
    }

    public static void startTimer(Context context) {
        if(mTimer == null) {
            mTimer = new QuestionTimer(2*60 * 1000, 1000, context); //change to 2*60
        }
        mContext = context;
        createDialogs();
        mTimer.cancel();
        shown = false;
        mTimer.start();
    }

    private static void createDialogs() {
        mWarningDialog =  new AlertDialog.Builder(mContext)
                .setMessage(R.string.msg2)
                .setNeutralButton(R.string.ok, null)
                .create();
        mQuitDialog = new AlertDialog.Builder(mContext)
                .setTitle(R.string.timeup)
                .setMessage(R.string.quit_resume)
                .setNegativeButton(R.string.quit, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        mContext.sendBroadcast(new Intent(QUIT));
                    }
                })
                .setPositiveButton(R.string.resume, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        mContext.sendBroadcast(new Intent(RESUME));
                    }
                })
                .setCancelable(false).create();
    }

    public static void updateContext(Context context) {
        mContext = context;
    }
}
