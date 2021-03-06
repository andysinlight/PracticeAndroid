package yuan.andy.test.link;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Point;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import java.util.ArrayList;

import yuan.andy.test.R;
import yuan.andy.test.link.impl.GameServiceImpl;
import yuan.andy.test.link.obj.GameConfig;
import yuan.andy.test.link.obj.LinkInfo;
import yuan.andy.test.link.view.GameView;
import yuan.andy.test.link.view.Piece;

public class Link extends Activity {
    GameConfig config ;
    GameServiceImpl service;
    GameView gameView ;
    Piece seleced ;
    AlertDialog.Builder builder;

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
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    handDown(event);
                }
                if (event.getAction() == MotionEvent.ACTION_UP) {
                    handUp();
                    //           Log.i("andy","handup");
                }
                return true;
            }
        });
    }

    public void init(){
        config = new GameConfig(this,75,80,10,6,100);
        service = new GameServiceImpl(config);
        gameView.setService(service);
        builder=new AlertDialog.Builder(this);
    }

    public void strar(int time){
       gameView.start();
    }

    public void handDown(MotionEvent event){
        Piece current =this.service.findPiece(new Point((int) event.getX(), (int) event.getY()));

        if(current!=null) {
//            ArrayList list1 = service.getChannelUP(current);
//            ArrayList list2 = service.getChannelDown(current);
//            ArrayList list3 = service.getChannelLeft(current);
//            ArrayList list4 = service.getChannelRight(current);
//            Log.i("andy", "up" + list1.size() + " down" + list2.size() + " left" + list3.size() + "right" + list4.size());
        }
//           Log.i("andy>>>hadfind",""+current.getIndexX()+current.getIndexY());
        if(gameView.getSeleced()==null){
            gameView.setSeleced(current);
        }
        if(seleced == null){
            this.seleced = current;
            gameView.postInvalidate();
            return;
        }

        if(seleced!=null){
            LinkInfo info = service.link(seleced, current);
//            handSuccess(new LinkInfo(seleced.getPieceCenter(),current.getPieceCenter()));
           if(info!=null){
               handSuccess(info,current,seleced);
               return ;
           }
            gameView.setSeleced(current);
            seleced =current ;
            gameView.postInvalidate();
            return;
        }
    }

    public void  handUp(){
        gameView.setLinkInfo(null);
        gameView.postInvalidate();
    }

    public void handSuccess(LinkInfo info,Piece p1,Piece p2){
        gameView.setLinkInfo(info);
        gameView.postInvalidate();
        gameView.setSeleced(null);
        this.seleced=null ;
        Piece [][] pieces =service.getPieces();
        pieces[p1.getIndexX()][p1.getIndexY()]=null;
        pieces[p2.getIndexX()][p2.getIndexY()]=null;
        if(!service.hasPiece()){
            showGameSuccess();
        }
    }

    public void showGameSuccess(){
        builder.setPositiveButton("再来一局", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                gameView.start();
            }
        }).setIcon(R.drawable.ic_launcher).setMessage("哇！！！ You are god")
                .create()
                .show();
    }
}
