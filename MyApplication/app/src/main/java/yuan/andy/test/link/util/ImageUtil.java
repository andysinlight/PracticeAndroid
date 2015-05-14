package yuan.andy.test.link.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import yuan.andy.test.R;
import yuan.andy.test.link.view.PieceImage;


public abstract class ImageUtil {
   static ArrayList<Integer> vlaueResource = (ArrayList)getVlaueResource() ;

    public static List<Integer> getVlaueResource() {
        List<Integer> resource = new ArrayList<>();
        Field [] field =R.drawable.class.getFields();
        try {
            for (Field value : field) {
                if (value.getName().indexOf("aap_") != -1) {
                    resource.add(value.getInt(R.drawable.class));
                }
            }
            return resource;
        }catch (Exception e){
            return null;
        }
    }

    public static List<Integer> getRandowValue(int Size, List<Integer> Resource){
        ArrayList<Integer> list = new ArrayList<>();
        Random random = new Random() ;
        for(int i=0;i<Size;i++ ){
            list.add(Resource.get(random.nextInt(Resource.size())));
        }
        return  list;
    }

    public static List<Integer> getPlayValue(int size){
        int tsize;
        if(size/2!=0){
            tsize = size/2;
        }
        else {
            tsize = size/2+1 ;
        }
        ArrayList<Integer> playList =(ArrayList)getRandowValue(tsize,vlaueResource);
        playList.addAll(playList);
        Collections.shuffle(playList);
        return playList;
    }

    public static ArrayList<PieceImage> getPlayPiece(Context context ,int size){
        ArrayList<Integer> list =(ArrayList)getPlayValue(size);
        ArrayList<PieceImage>PIlist =new ArrayList<>();
        for(Integer value :list){
            Bitmap bitmap = BitmapFactory.decodeResource(context.getResources(),value);
            PieceImage pieceImage = new PieceImage(bitmap,value);
            PIlist.add(pieceImage);
        }
        return PIlist ;
    }

    public static Bitmap getSeleced (Context context){
        return  BitmapFactory.decodeResource(context.getResources(),R.drawable.selected);
    }
}
