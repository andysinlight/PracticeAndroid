package yuan.andy.test.link.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import yuan.andy.test.link.GameService;
import yuan.andy.test.link.obj.LinkInfo;

/**
 * TODO: document your custom view class.
 */
public class GameView extends View {
    private GameService service ;
    private LinkInfo linkInfo ;
    private Piece seleced ;
    private Bitmap selecedImage ;
    private  Piece [][] pieces ;
    private Paint paint = new Paint();


    public GameView(Context context,AttributeSet arr) {
        super(context,arr);
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
                        if(pieces[i][j]!=null);
                        {   Piece p = pieces[i][j];
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
}
