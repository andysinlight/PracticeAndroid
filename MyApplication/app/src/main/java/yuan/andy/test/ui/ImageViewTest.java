package yuan.andy.test.ui;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;

import yuan.andy.test.R;

public class ImageViewTest extends Activity {
    int alpha=155;
    int current =0 ;
    ImageView view1 ;
    ImageView view2 ;
    Button plus,min,next;
    int images [] = new int[]{
      R.drawable.image1,R.drawable.image2,R.drawable.image3
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_view_test);
        view1= (ImageView)findViewById(R.id.showWiew);
        view2 =(ImageView)findViewById(R.id.plusView);
        plus = (Button)findViewById(R.id.plus);
        min = (Button)findViewById(R.id.minus);
        next = (Button)findViewById(R.id.next);
        view1.setImageResource(images[current]);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view1.setImageResource(images[++current % images.length]);
            }
        });

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(v==plus){
                    alpha+=20;
                }
                if(v==min){
                    alpha-=20;
                }
                if(alpha>=255){
                    alpha=255;
                }
                if(alpha<=0){
                    alpha=0;
                }

                view1.setAlpha(alpha);
            }
        };
    plus.setOnClickListener(listener);
        min.setOnClickListener(listener);

        view1.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
               BitmapDrawable bitmapDrawable = (BitmapDrawable)view1.getDrawable();
                Bitmap image = bitmapDrawable.getBitmap();
                int scale= image.getWidth()/640;
                int x = (int)event.getX()*scale;
                int y = (int)event.getY()*scale;
                if(x+120>image.getWidth()){
                    x=image.getWidth()-120;
                }
                if(y+120>image.getHeight()){
                    y=image.getHeight()-120 ;
                }
                Bitmap bitmap = Bitmap.createBitmap(image,x,y,120,120);
                view2.setImageBitmap(bitmap);
                return false;

            }
        });

    }
}
