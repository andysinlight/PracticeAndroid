package yuan.andy.test.link.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;

import yuan.andy.test.link.GameService;
import yuan.andy.test.link.obj.LinkInfo;
import yuan.andy.test.link.util.ImageUtil;

/**
 * TODO: document your custom view class.
 */
public class GameView extends View {
    private GameService service ;
    private LinkInfo linkInfo ;
    private Piece seleced =null ;
    private Bitmap selecedImage ;
    private  Piece [][] pieces ;
    private Paint paint = new Paint();


    public GameView(Context context,AttributeSet arr) {
        super(context, arr);
        selecedImage = ImageUtil.getSeleced(context);
        paint.setColor(Color.RED);
        paint.setStrokeWidth(7);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        pieces = service.getPieces();
        Log.i("andy_game_view_pieces","x>>> "+pieces.length+">>y"+pieces[pieces.length-1].length);
        if(pieces !=null) {
            try {
                for (int i = 0; i < pieces.length; i++) {
                    for (int j = 0; j < pieces[i].length; j++) {
                        Log.i("andy_game_view_i,j","i>> "+i +"j>> "+j);
                        if (pieces[i][j]!=null) {
                            Piece p = pieces[i][j];
                            PieceImage pieceImage = p.getImage();
                            Bitmap bitmap = pieceImage.getBitmap();
                            canvas.drawBitmap(bitmap, p.getStartX(), p.getStarrY(), paint);
                        }
                    }
                }
            }catch ( Exception e){
                Log.e("andy___gameview",e.toString());
                e.printStackTrace();
            }
        }


        if(seleced !=null){
            canvas.drawBitmap(selecedImage,seleced.getStartX(),seleced.getStarrY(),paint);
        }

        if(linkInfo !=null){
            drawLine(this.linkInfo,canvas);
            Log.i("andy_drawling","drawling");
        }
    }

    public void  drawLine(LinkInfo linkInfo,Canvas canvas){
        ArrayList<Point> points  =(ArrayList)linkInfo.getPoints();
        for(int i=0;i<points.size()-1;i++){
            Point currentPoint = points.get(i);
            Point secondPoint = points.get(i+1);
            Log.i("andy_drawline>>>>"," "+currentPoint.x +currentPoint.y+secondPoint.x+secondPoint.y);
            canvas.drawLine(currentPoint.x,currentPoint.y,secondPoint.x,secondPoint.y,paint);
        }
    }

    public void setService(GameService service) {
        this.service = service;
    }

    public void setSeleced(Piece seleced) {
        this.seleced = seleced;
    }

    public void start(){
        service.start();
        postInvalidate();
    }

    public Piece getSeleced() {
        return seleced;
    }

    public void setLinkInfo(LinkInfo linkInfo) {
        this.linkInfo = linkInfo;
    }
}
