package yuan.andy.test;

import yuan.andy.test.link.obj.LinkInfo;
import yuan.andy.test.link.view.Piece;

public interface GameService {
    abstract  void start();
    abstract  boolean hasPiece() ;
    abstract Piece findPiece() ;
    abstract Piece [][] getPieces();
    abstract LinkInfo  link() ;
}
