package yuan.andy.test.ui;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;
import yuan.andy.test.R;

public class FrameLayoutTest extends Activity {
    int currentColor =0;
    int [] names = new int[]{
      R.id.fTextView1,R.id.fTextView2,R.id.fTextView3,
            R.id.fTextView4,R.id.fTextView5,R.id.fTextView6,R.id.fTextView7
    };
    int colors []= new int[]{
        Color.RED,Color.LTGRAY,Color.YELLOW,Color.CYAN,Color.BLUE,Color.GREEN,Color.GRAY,Color.RED   };

    TextView[] views = new TextView[names.length];
    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            if(msg.what==12312){
                for(int i=0;i<views.length;i++){
                    views[i].setBackgroundColor(colors[(i+currentColor)
                            % names.length]);
                }
                currentColor++;
            }
            super.handleMessage(msg);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frame_layout_test);
        for(int i=0;i<names.length;i++){
            views[i]=(TextView)findViewById(names[i]);
        }

        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
               handler.sendEmptyMessage(12312);
            }
        },0,200);
    }

}
