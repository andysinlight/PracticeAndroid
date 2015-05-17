package yuan.andy.test.link.impl;

import android.graphics.Point;
import android.util.ArrayMap;
import android.util.Log;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

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
        for(int i=0;i<pieces.length;i++){
            for(int j=0;j<pieces[i].length;j++){
                if(pieces[i][j]!=null){
                    return true;
                }
            }
        }
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
        Log.i("andy_link", " linking");
        if(p1==p2)
            return  null;
        if(!p1.isSeameImage(p2)) {
//            Log.i("andy_link", "reture link");
            return null;
        }

        if(p1.getIndexY()==p2.getIndexY()){
            if(p1.getIndexX()>p2.getIndexX()){
//                Log.i("andy_blockx", "p1>>>p2");
                return link(p2, p1);
                //Log.i("andy_blockx", "second link done");
              // return null;
            }
            if(isBlockX(p1, p2)) {
//                Log.i("andy_blockx", "bloclkx");
                return new LinkInfo(p1.getPieceCenter(), p2.getPieceCenter());
            }

        }

        if(p1.getIndexX()==p2.getIndexX()){
            if(p1.getIndexY()>p2.getIndexY()){
//                Log.i("andy_blockx", "p1>>>p2");
                return link(p2, p1);
               // Log.i("andy_blockx", "Ysecond link done");
             //   return null;
            }
            if(isBlockY(p1, p2)) {
//                Log.i("andy_blockx", "bloclkY");
                return new LinkInfo(p1.getPieceCenter(), p2.getPieceCenter());
            }

        }

        if (p1.getIndexY()>p2.getIndexY()) {
//            Log.i("andy","exchang p1 p2"+p1.getPieceCenter().toString()+">>"+p2.getPieceCenter().toString());
            return link(p2,p1);
        }

        Point cornerPoint =handCorner(p1, p2);
        if(cornerPoint!=null){
            return new LinkInfo(p1.getPieceCenter(),cornerPoint,p2.getPieceCenter());
        }

        HashMap<Point,Point> map = handTwoCorner(p1,p2);
        if(map!=null) {
            return handMap(p1, p2, map);
        }
        return null;
    }

    public HashMap<Point,Point> handTwoCorner(Piece p1,Piece p2){
        Log.i("andy"," handTwoCorner id doing") ;
        HashMap<Point,Point> map = new HashMap<>();
        ArrayList<Point> p1UP = getChannelUP(p1);
        ArrayList<Point> p1Down=getChannelDown(p1);
        ArrayList<Point> p1Right = getChannelRight(p1);
        ArrayList<Point> p1Left = getChannelLeft(p1);
        ArrayList<Point> p2Left=getChannelLeft(p2);
        ArrayList<Point> p2UP = getChannelUP(p2);
        ArrayList<Point> p2Down = getChannelDown(p2);
        ArrayList<Point> p2Right = getChannelRight(p2);
//        if(p1.getIndexY()==p2.getIndexY()){
//            HashMap<Point,Point> m1 = (HashMap<Point,Point>)compareChannelY(p1UP,p2UP);
//            HashMap<Point,Point> m2 = (HashMap<Point,Point>)compareChannelY(p1Down,p2Down);
//            map.putAll(m1);
//            map.putAll(m2);
//        }
//
//        if(p1.getIndexX()==p2.getIndexX()){
//            HashMap<Point,Point> m1 = (HashMap<Point,Point>)compareChannelX(p1Right, p2Right);
//            HashMap<Point,Point> m2 = (HashMap<Point,Point>)compareChannelX(p1Left, p2Left);
//            map.putAll(m1);
//            map.putAll(m2);
//        }

        if(compareChannelY(p1UP, p2UP).size()!=0){
            HashMap<Point,Point> m1 =(HashMap<Point,Point>)compareChannelY(p1UP, p2UP);
            map.putAll(m1);
        }
        if(compareChannelY(p1Down, p2Down).size()!=0){
            HashMap<Point,Point> m2 =(HashMap<Point,Point>)compareChannelY(p1Down, p1Down);
            map.putAll(m2);
        }
        if(compareChannelY(p1Down, p2UP).size()!=0){
            HashMap<Point,Point> m2 =(HashMap<Point,Point>)compareChannelY(p1Down, p1Down);
            map.putAll(m2);
        }
        if(compareChannelY(p1UP, p2Down).size()!=0){
            HashMap<Point,Point> m4 =(HashMap<Point,Point>)compareChannelY(p1UP,p2Down);
            map.putAll(m4);
        }
        if(compareChannelX(p1Left, p2Left).size()!=0){
            HashMap<Point,Point> m3 =(HashMap<Point,Point>)compareChannelX(p1Left, p1Left);
            map.putAll(m3);
        }
        if(compareChannelX(p1Right,p2Right).size() !=0){
            HashMap<Point,Point> m5 =(HashMap<Point,Point>)compareChannelX(p1Right,p2Right);
            map.putAll(m5);
        }

        if(compareChannelX(p1Right,p2Left).size()!=0){
            HashMap<Point,Point> m5 =(HashMap<Point,Point>)compareChannelX(p1Right,p2Left);
            map.putAll(m5);
        }
        if(compareChannelX(p1Left,p2Right).size()!=0){
            HashMap<Point,Point> m5 =(HashMap<Point,Point>)compareChannelX(p1Right,p2Left);
            map.putAll(m5);
        }


        return map ;
    }

    public LinkInfo handMap(Piece p1,Piece p2,Map<Point,Point> map){
        Log.i("andy"," handMap id doing"+"mapSize"+map.size()) ;
        int distance = 1000000;
        LinkInfo linkInfo =null ;
        Point point1 = p1.getPieceCenter();
        Point point2 = p2.getPieceCenter();
        for(Point Kpoint :map.keySet()){
            Point Vpoint = map.get(Kpoint);
            Log.i("andy"," rady to count") ;
            int temp = countDistance(point1,Kpoint,Vpoint,point2);
            if(temp<distance){
                distance = temp ;
                linkInfo = new LinkInfo(point1,Kpoint,Vpoint,point2);
                Log.i("andy"," handMap id exchangge"+"mapSize"+"Linkinfo"+linkInfo.toString()) ;
            }
        }
        return linkInfo ;
    }

    public int countDistance(Point p1,Point p2,Point p3,Point p4){
        Point[]points = new Point[]{p1,p2,p3,p4};
        int diantance=0 ;
        for(int i=0;i<points.length-1;i++){
            diantance = diantance+Math.abs( (int)(points[i].x-points[i+1].x)) + Math.abs( (int)(points[i].y-points[i+1].y));
            Log.i("andy"," distance"+ diantance);
        }
        return diantance;
    }

    public Map<Point,Point> compareChannelX(ArrayList a1 ,ArrayList a2){
        HashMap<Point,Point> map =new HashMap<>();
        Point p1 ;
        Point p2 ;
        for(int i=0;i<a1.size();i++){
            for(int j=0;j<a2.size();j++){
                p1=(Point)a1.get(i);
                p2=(Point)a2.get(j);
                if(p1.x==p2.x){
                map.put(p1, p2);
                    return map;
                }
            }
        }
        return  map;
    }

    public Map<Point,Point> compareChannelY(ArrayList a1 ,ArrayList a2){
        Map<Point,Point> map = new HashMap<>();
        Point p1 ;
        Point p2 ;
        for(int i=0;i<a1.size();i++){
            for(int j=0;j<a2.size();j++){
                p1=(Point)a1.get(i);
                p2=(Point)a2.get(j);
                if(p1.y==p2.y){
                    map.put(p1,p2);
                    return map;
                }
            }
        }
        return  map;
    }

    public Point handCorner(Piece p1,Piece p2){
        ArrayList<Point> p1UP = getChannelUP(p1);
        ArrayList<Point> p1Down=getChannelDown(p1);
        ArrayList<Point> p1Right = getChannelRight(p1);
        ArrayList<Point> p2Left=getChannelLeft(p2);
        ArrayList<Point> p2UP = getChannelUP(p2);
        ArrayList<Point> p2Down = getChannelDown(p2);
        if(p1.getIndexX()<p2.getIndexX()){
            Point point1 = cutChannel(p1Down,p2Left);
            Point point2 = cutChannel(p1Right, p2UP);
            return point1!=null ? point1:point2 ;
        }
        if(p1.getIndexX()>p2.getIndexX()){
            Point point1 = cutChannel(p1UP,p2Left);
            Point point2 = cutChannel(p1Right, p2Down);
            return point1!=null ? point1:point2 ;
        }
        return  null ;
    }

    public Point cutChannel(ArrayList a1,ArrayList a2){
//        Log.i("andy","cuting"+a1.size()+">>"+a2.size());
        for (int i=0;i<a1.size();i++){
            for(int j=0;j<a2.size();j++){
//                Log.i("andy","has cut"+ a1.get(i).toString()+">>>"+a2.get(j).toString()+i+j);
                if(isSamePoint((Point)a1.get(i),(Point)a2.get(j))){
                    return (Point)a1.get(i);
                }
            }
        }
        return  null ;
    }

    public boolean isSamePoint(Point p1,Point p2){
        if(p1.x==p2.x&&p1.y==p2.y&&p1!=null&&p2!=null){
            return  true ;
        }
        return false ;
    }

    public ArrayList<Point> getChannelUP(Piece p){
        ArrayList<Point> list = new ArrayList<>();
        for(int i=p.getPieceCenter().y-config.getDEFAULT_HEIGH();
            i>config.getBeginy();i=i-config.getDEFAULT_HEIGH()){
            Point point =new Point(p.getPieceCenter().x,i);
            if(findPiece(point)!=null){
                break;
            }
            list.add(point);
        }
        return list ;
    }
    public ArrayList<Point> getChannelDown(Piece p){
        ArrayList<Point> list = new ArrayList<>();
        for(int i=p.getPieceCenter().y+config.getDEFAULT_HEIGH();
            i<hasMaxHeigth();i=i+config.getDEFAULT_HEIGH()){
            Point point =new Point(p.getPieceCenter().x,i);
            if(findPiece(point)!=null){
                break;
            }
            list.add(point);
        }
        return list ;
    }

    public ArrayList<Point> getChannelRight(Piece p){
        ArrayList<Point> list = new ArrayList<>();
        for(int i=p.getPieceCenter().x+config.getDEFAULT_WIDTH();
            i<hasMaxWidth();i=i+config.getDEFAULT_WIDTH()){
            Point point =new Point(i,p.getPieceCenter().y);
            if(findPiece(point)!=null){
                break;
            }
            list.add(point);
        }
        return list ;
    }

    public ArrayList<Point> getChannelLeft(Piece p){
        ArrayList<Point> list = new ArrayList<>();
        for(int i=p.getPieceCenter().x-config.getDEFAULT_WIDTH();
            i>config.getBeginX();i=i-config.getDEFAULT_WIDTH()){
            Point point =new Point(i,p.getPieceCenter().y);
            if(findPiece(point)!=null){
                break;
            }
            list.add(point);
        }
        return list ;
    }

    public int hasMaxHeigth(){
        int higth=config.getBeginy() ;
        higth = higth+pieces.length*config.getDEFAULT_HEIGH();
        return  higth;
    }

    public int hasMaxWidth(){
        int width=config.getBeginX() ;
        width = width+pieces[0].length*config.getDEFAULT_HEIGH();
        return  width;
    }

    public boolean isBlockX(Piece p1,Piece p2){
       int a = p1.getPieceCenter().y+config.getDEFAULT_HEIGH();
        int b = p2.getPieceCenter().y-config.getDEFAULT_HEIGH()+20;
        for(int i=a;i<b;i=i+config.getDEFAULT_HEIGH()){
            Point p = new Point(p1.getPieceCenter().x,i);
            if(findPiece(p)!=null){
         //       Log.i("andy_findpie","find pieceX ");
                return false ;
            }
        }
//        Log.i("andy_findpie","not has find pieceX ");
        return true ;
    }

    public boolean isBlockY(Piece p1,Piece p2){
        int a = p1.getPieceCenter().x+config.getDEFAULT_HEIGH();
        int b = p2.getPieceCenter().x-config.getDEFAULT_HEIGH()+20;
        for(int i=a;i<b;i=i+config.getDEFAULT_HEIGH()){
            Point p = new Point(i,p1.getPieceCenter().y);
            if(findPiece(p)!=null){
//                Log.i("andy_findpie","find pieceY ");
                return false ;
            }
        }
//        Log.i("andy_findpie","not has find pieceY ");
        return true ;
    }
}
