package yuan.andy.test.link;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import yuan.andy.test.link.obj.GameConfig;
import yuan.andy.test.link.util.ImageUtil;
import yuan.andy.test.link.view.Piece;
import yuan.andy.test.link.view.PieceImage;

/**
 * Created by Administrator on 2015-5-14.
 */
public abstract class GameBoard {

    GameConfig config;
    public GameBoard(GameConfig config) {
        this.config=config;
    }
    public abstract List<Piece> createPieces(Piece[][] piece) ;
    public Piece[][] create(){
      Piece[][] pieces  =  new Piece[config.getCountX()][config.getCountY()];
        ArrayList<Piece> noNullPiece =(ArrayList)createPieces(pieces);
        ArrayList<PieceImage> playImage = ImageUtil.getPlayPiece(config.getCont(),noNullPiece.size());
        for(int i=0;i<noNullPiece.size();i++){
            PieceImage image = playImage.get(i);
            Piece piece = noNullPiece.get(i);
            piece.setImage(image);
            piece.setStarrY(config.getDEFAULT_HEIGH() * piece.getIndexX() + config.getBeginy());
            piece.setStartX(config.getDEFAULT_WIDTH() * piece.getIndexY() + config.getBeginX());
           try {
               pieces[piece.getIndexX()][piece.getIndexY()] = piece ;
                Log.i("andy___getindX -Y"," "+ piece.getIndexX()+">>y "+piece.getIndexY() );
           }catch (ArrayIndexOutOfBoundsException e){
           }
        }
        Log.i("andy_AgameBoard_pieces",""+pieces.length+" "+pieces[pieces.length-1].length);
        return pieces ;
    }
}
