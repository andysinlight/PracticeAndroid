package yuan.andy.test.link;

import android.app.Activity;
import android.content.res.Configuration;
import android.graphics.Point;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import yuan.andy.test.R;
import yuan.andy.test.link.impl.GameServiceImpl;
import yuan.andy.test.link.obj.GameConfig;
import yuan.andy.test.link.view.GameView;
import yuan.andy.test.link.view.Piece;

public class Link extends Activity {
    GameConfig config ;
    GameService service;
    GameView gameView ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_link);
        gameView =(GameView) findViewById(R.id.gameView);
        init();
        strar(10);
        gameView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
               if(event.getAction()==MotionEvent.ACTION_DOWN){
                   handDown(event);
               }
               else if(event.getAction()==MotionEvent.ACTION_UP){
                   handUp();
               }
                return false;
            }
        });
    }

    public void init(){
        config = new GameConfig(this,75,80,10,6,100);
        service = new GameServiceImpl(config);
        gameView.setService(service);
    }

    public void strar(int time){
       gameView.start();
    }

    public void handDown(MotionEvent event){
        Piece p =this.service.findPiece(new Point((int)event.getX(),(int)event.getY()));
       if(p!=null)
           Log.i("andy>>>hadfind",""+p.getIndexX()+p.getIndexY());
    }

    public void  handUp(){

    }


}
