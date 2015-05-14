package yuan.andy.test.link;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import yuan.andy.test.GameService;
import yuan.andy.test.R;
import yuan.andy.test.link.impl.GameServiceImpl;
import yuan.andy.test.link.obj.GameConfig;
import yuan.andy.test.link.view.GameView;

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
    }

    public void init(){
        config = new GameConfig(this,40,80,12,8,100);
        service = new GameServiceImpl(config);
        gameView.setService(service);
    }

    public void strar(int time){
       gameView.start();
    }
}
