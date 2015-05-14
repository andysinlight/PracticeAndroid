package yuan.andy.test.link.view;

import android.graphics.Bitmap;

public class PieceImage {

    Bitmap bitmap ;
    int imageid ;

    public PieceImage(Bitmap image, int imageid) {
        this.bitmap = image;
        this.imageid = imageid;
    }

    public Bitmap getBitmap() {
        return bitmap;
    }

    public int getImageid() {
        return imageid;
    }

    public void setBitmap(Bitmap image) {
        this.bitmap = image;
    }

    public void setImageid(int imageid) {
        this.imageid = imageid;
    }
}
