package yuan.andy.test.link.obj;

import android.graphics.Point;

import java.util.ArrayList;
import java.util.List;

public class LinkInfo {

    List<Point> points = new ArrayList<>();
    public List<Point> getPoints() {
        return points;
    }

    public LinkInfo(Point p1,Point p2) {
       points.add(p1);
        points.add(p2);
    }

    public LinkInfo(Point p1,Point p2,Point p3) {
        points.add(p1);
        points.add(p2);
        points.add(p3);
    }
    public LinkInfo(Point p1,Point p2,Point p3,Point p4) {
        points.add(p1);
        points.add(p2);
        points.add(p3);
        points.add(p4);
    }
}
