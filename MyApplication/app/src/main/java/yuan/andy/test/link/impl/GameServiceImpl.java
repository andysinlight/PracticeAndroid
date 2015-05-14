package yuan.andy.test.link.impl;

import android.graphics.Point;

import yuan.andy.test.link.GameBoard;
import yuan.andy.test.link.GameService;
import yuan.andy.test.link.obj.GameConfig;
import yuan.andy.test.link.obj.LinkInfo;
import yuan.andy.test.link.view.Piece;

/**
 * Created by Administrator on 2015-5-14.
 */
public class GameServiceImpl implements GameService {
    private GameConfig config ;
    private Piece [][] pieces ;

    public GameServiceImpl(GameConfig config) {
        this.config = config;
    }

    @Override
    public void start() {
        GameBoard board ;
        board = new GameBoard_1(config);
        pieces = board.create() ;
    }
    @Override
    public Piece[][] getPieces() {
        return this.pieces;
    }

    @Override
    public boolean hasPiece() {
        return false;
    }

    @Override
    public Piece findPiece(Point point) {
        int indexX,indexY ;
        int relativeX = point.x-config.getBeginX();
        int relativeY = point.y-config.getBeginy();
        if(relativeX<0||relativeY<0){
            return  null ;
        }
        if(relativeX % config.getDEFAULT_WIDTH()==0){
            indexX = relativeX/config.getDEFAULT_WIDTH()-1;
        }else {
            indexX=relativeX/config.getDEFAULT_WIDTH();
        }

        if(relativeY % config.getDEFAULT_HEIGH()==0){
            indexY = relativeY/config.getDEFAULT_HEIGH()-1;
        }else {
            indexY=relativeY/config.getDEFAULT_HEIGH();
        }

        if(0<=indexX && indexX <config.getCountY() && indexY>=0&&indexY<config.getCountX()){
        return pieces[indexY][indexX];
        }
        return null ;
    }



    @Override
    public LinkInfo link(Piece p1,Piece p2) {

        return null;
    }
}
