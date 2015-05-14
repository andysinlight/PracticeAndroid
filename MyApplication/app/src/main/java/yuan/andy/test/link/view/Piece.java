package yuan.andy.test.link.view;

import android.graphics.Point;


public class Piece {
    int indexX ;
    int indexY ;
    int startX ;
    int starrY ;
    PieceImage image ;

    public Piece(int indexX, int indexY) {
        this.indexY = indexY;
        this.indexX = indexX;
    }

    public Piece(int indexX, int starrY, int startX, int indexY) {
        this.indexX = indexX;
        this.starrY = starrY;
        this.startX = startX;
        this.indexY = indexY;
    }

    public Point getPieceCenter(){
        return new Point(startX+getImage().getBitmap().getWidth()/2,
                starrY+getImage().getBitmap().getHeight()/2);
    }


    public boolean isSeameImage(Piece piece){
        if(piece==null){
            return false ;
        }
        return this.getImage().getImageid()==(piece.getImage()).getImageid();
    }

    public PieceImage getImage() {
        return image;
    }

    public void setImage(PieceImage image) {
        this.image = image;
    }

    public int getIndexX() {
        return indexX;
    }

    public void setIndexX(int indexX) {
        this.indexX = indexX;
    }

    public int getIndexY() {
        return indexY;
    }

    public void setIndexY(int indexY) {
        this.indexY = indexY;
    }

    public int getStartX() {
        return startX;
    }

    public void setStartX(int startX) {
        this.startX = startX;
    }

    public int getStarrY() {
        return starrY;
    }

    public void setStarrY(int starrY) {
        this.starrY = starrY;
    }
}
