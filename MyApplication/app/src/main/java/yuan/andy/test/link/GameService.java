package yuan.andy.test.link;

import android.graphics.Point;

import yuan.andy.test.link.obj.LinkInfo;
import yuan.andy.test.link.view.Piece;

public interface GameService {
    abstract  void start();
    abstract  boolean hasPiece() ;
    abstract Piece findPiece(Point point) ;
    abstract Piece [][] getPieces();
    abstract LinkInfo  link(Piece p1,Piece p2) ;
}
