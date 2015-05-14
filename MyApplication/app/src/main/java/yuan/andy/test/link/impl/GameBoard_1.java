package yuan.andy.test.link.impl;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import yuan.andy.test.link.GameBoard;
import yuan.andy.test.link.obj.GameConfig;
import yuan.andy.test.link.view.Piece;

/**
 * Created by Administrator on 2015-5-14.
 */
public class GameBoard_1 extends GameBoard {

    public GameBoard_1(GameConfig config) {
        super(config);
    }

    @Override
    public List<Piece> createPieces(Piece[][] piece) {
        ArrayList<Piece> arrayList = new ArrayList<>();
        for(int i=0;i<piece.length;i++){
            for(int j=0;j<piece[i].length;j++){
                Piece p = new Piece(i,j);
                arrayList.add(p);
            }
        }
        Log.i("andy____gameboard_1","Piece[ "+piece.length+"]"+" ["+piece[0].length+"]"+">>>>>>"+arrayList.size());
        return arrayList;
    }

}
