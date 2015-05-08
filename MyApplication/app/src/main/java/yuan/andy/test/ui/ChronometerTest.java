package yuan.andy.test.ui;

import android.app.Activity;
import android.os.SystemClock;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;

import yuan.andy.test.R;

public class ChronometerTest extends Activity {
    Chronometer chronometer;
    Button button ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chronometer);
        chronometer = (Chronometer)findViewById(R.id.chronometer);
        button = (Button)findViewById(R.id.chStart);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chronometer.setBase(SystemClock.elapsedRealtime());
                chronometer.start();
                chronometer.setEnabled(false);
            }
        });
        chronometer.setOnChronometerTickListener(new Chronometer.OnChronometerTickListener() {
            @Override
            public void onChronometerTick(Chronometer chronometer) {
                if(SystemClock.elapsedRealtime()-chronometer.getBase()>10*1000){
                    chronometer.stop();
                    chronometer.setEnabled(true);
                }
            }
        });

    }
}
