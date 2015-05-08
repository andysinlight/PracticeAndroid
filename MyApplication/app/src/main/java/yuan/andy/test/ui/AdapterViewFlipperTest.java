package yuan.andy.test.ui;

import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterViewFlipper;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import yuan.andy.test.R;

public class AdapterViewFlipperTest extends Activity {
    int [] images = new int[]{
      R.drawable.image1,R.drawable.image2,R.drawable.image3,R.drawable.image4,R.drawable.image5
    };
    AdapterViewFlipper flipper ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adapter_view_flipper_test);
        flipper = (AdapterViewFlipper)findViewById(R.id.flipper);
        BaseAdapter adaapter = new BaseAdapter() {
            @Override
            public int getCount() {
                return images.length;
            }

            @Override
            public Object getItem(int position) {
                return images[position];
            }

            @Override
            public long getItemId(int position) {
                return position;
            }

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                ImageView view = new ImageView(AdapterViewFlipperTest.this) ;
                view .setImageResource((int)getItem(position));
                view.setScaleType(ImageView.ScaleType.FIT_XY);
                view.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT));
                return view;
            }
        };
        flipper.setAdapter(adaapter);
    }

    public void next(View v){
        flipper.showNext();
        flipper.stopFlipping();
    }
    public void pre(View v){
        flipper.showPrevious();
        flipper.stopFlipping();
    }
    public void auto(View c ){
        flipper.startFlipping();
    }

}
