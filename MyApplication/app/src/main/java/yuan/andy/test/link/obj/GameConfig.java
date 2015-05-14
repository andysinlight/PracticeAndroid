package yuan.andy.test.link.obj;

import android.content.Context;

/**
 * Created by Administrator on 2015-5-14.
 */
public class GameConfig {
    Context cont ;
    int beginX ;
    int beginy ;
    int countX ;
    int countY ;
    int DEFAULT_TIME ;
    int DEFAULT_WIDTH =80;
    int DEFAULT_HEIGH =80;

    public GameConfig(Context cont, int beginX, int beginy, int countX, int countY,int time) {
        this.cont = cont;
        this.beginX = beginX;
        this.beginy = beginy;
        this.countX = countX;
        this.countY = countY;
        this.DEFAULT_TIME  = time ;
    }

    public Context getCont() {
        return cont;
    }

    public void setCont(Context cont) {
        this.cont = cont;
    }

    public int getBeginX() {
        return beginX;
    }

    public void setBeginX(int beginX) {
        this.beginX = beginX;
    }

    public int getBeginy() {
        return beginy;
    }

    public void setBeginy(int beginy) {
        this.beginy = beginy;
    }

    public int getCountX() {
        return countX;
    }

    public void setCountX(int countX) {
        this.countX = countX;
    }

    public int getCountY() {
        return countY;
    }

    public void setCountY(int countY) {
        this.countY = countY;
    }

    public int getDEFAULT_WIDTH() {
        return DEFAULT_WIDTH;
    }

    public void setDEFAULT_WIDTH(int DEFAULT_WIDTH) {
        this.DEFAULT_WIDTH = DEFAULT_WIDTH;
    }

    public int getDEFAULT_HEIGH() {
        return DEFAULT_HEIGH;
    }

    public void setDEFAULT_HEIGH(int DEFAULT_HEIGH) {
        this.DEFAULT_HEIGH = DEFAULT_HEIGH;
    }
}
