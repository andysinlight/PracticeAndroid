package yuan.andy.test.ui;

import android.app.Activity;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ProgressBar;

import yuan.andy.test.R;

public class ProgressBarTest extends Activity {
    ProgressBar bar1,bar2;
    int [] data = new int [100];
    int hasState=0;
    int state=0;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress_bar_test);
        bar1 = (ProgressBar)findViewById(R.id.bar1);
        bar2 = (ProgressBar)findViewById(R.id.bar2);
        new Thread(){
            @Override
            public void run() {
                while (state < 100) {
                    state = showData();
                    handler.sendEmptyMessage(01234);
                }
            }
        }.start();
    }

    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(msg.what==01234){
                bar1.setProgress(state);
                bar2.setProgress(state);

            }
        }
    };

    private  int showData(){
        data[hasState++] = (int)Math.random()*100;
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return hasState;
    }

}
