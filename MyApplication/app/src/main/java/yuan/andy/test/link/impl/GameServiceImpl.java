package yuan.andy.test.link.impl;

import android.graphics.Point;
import android.util.Log;

import yuan.andy.test.link.GameBoard;
import yuan.andy.test.link.GameService;
import yuan.andy.test.link.obj.GameConfig;
import yuan.andy.test.link.obj.LinkInfo;
import yuan.andy.test.link.view.Piece;


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
        if(p1==p2)
            return  null;
        if(!p1.isSeameImage(p2)) {
            Log.i("andy_link", "reture link");
            return null;
        }

        if(p1.getIndexY()==p2.getIndexY()){
            if(p1.getIndexX()>p2.getIndexX()){
                link(p2,p1);
                       }

            isBlockX(p1, p2);
            Log.i("andy_blockx","bloclkx");
            return new LinkInfo(p1.getPieceCenter(),p2.getPieceCenter());
        }

        if(p1.getIndexX()==p2.getIndexX()){
            if(p1.getIndexY()>p2.getIndexY()){
                link(p2,p1);
                    }
            isBlockY(p1, p2);
            Log.i("andy_blockY", "bloclky");
            return new LinkInfo(p1.getPieceCenter(),p2.getPieceCenter());
        }
        return null;
    }

    public boolean isBlockX(Piece p1,Piece p2){

       int a = p1.getPieceCenter().y+config.getDEFAULT_HEIGH();
        int b = p2.getPieceCenter().y;
        for(int i=a;i<b;){
            i=i+config.getDEFAULT_HEIGH();
            Point p = new Point(p1.getPieceCenter().x,i);
            if(findPiece(p)!=null){
                return false ;
            }
        }
            return true ;
    }

    public boolean isBlockY(Piece p1,Piece p2){

        int a = p1.getPieceCenter().x+config.getDEFAULT_HEIGH();
        int b = p2.getPieceCenter().x;
        for(int i=a;i<b;){
            i=i+config.getDEFAULT_HEIGH();
            Point p = new Point(i,p1.getPieceCenter().y);
            if(findPiece(p)!=null){
                return false ;
            }
        }
        return true ;
    }


}
