package yuan.andy.test.link.impl;

import yuan.andy.test.GameBoard;
import yuan.andy.test.GameService;
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
    public Piece findPiece() {
        return null;
    }



    @Override
    public LinkInfo link() {
        return null;
    }
}
