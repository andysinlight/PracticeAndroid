package yuan.andy.test.ui;

import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;

import yuan.andy.test.R;

public class GallaryTest extends Activity {
    ImageView imageView ;
    Gallery gallery ;
    int [] images = new int[]{
            R.drawable.image1,R.drawable.image2,R.drawable.image3,R.drawable.image4,R.drawable.image5,
            R.drawable.image6,R.drawable.image7
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallary_test);
        imageView = (ImageView)findViewById(R.id.galleryImage);
        gallery = (Gallery)findViewById(R.id.gallery);

        BaseAdapter adapter = new BaseAdapter() {
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
                ImageView view = new ImageView(GallaryTest.this);
                view.setLayoutParams(new Gallery.LayoutParams(200,200));
                view.setImageResource((int)getItem(position));
                return view;
            }
        };
        gallery.setAdapter(adapter);
        gallery.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                imageView.setImageResource(images[position]);
            }
        });
    }
}
