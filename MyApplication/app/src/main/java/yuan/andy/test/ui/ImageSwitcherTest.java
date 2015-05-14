package yuan.andy.test.ui;

import android.app.Activity;
import android.graphics.Path;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.ArrayMap;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.SimpleAdapter;
import android.widget.ViewSwitcher;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import yuan.andy.test.R;

public class ImageSwitcherTest extends Activity {

    int[] imageIds = new int[]
            {
                    R.drawable.bomb5 , R.drawable.bomb6 , R.drawable.bomb7
                    , R.drawable.bomb8 , R.drawable.bomb9 , R.drawable.bomb10
                    , R.drawable.bomb11 , R.drawable.bomb12	, R.drawable.bomb13
                    , R.drawable.bomb14 , R.drawable.bomb15 , R.drawable.bomb16
            };
    ImageSwitcher switcher ;
    GridView gridView ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_switcher_test);
        switcher = (ImageSwitcher)findViewById(R.id.imageSwitch);
        gridView = (GridView) findViewById(R.id.sgridView);
        List<Map<String,Object>> items = new ArrayList<>();
        switcher.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                ImageView image = new ImageView(ImageSwitcherTest.this);
              image.setScaleType(ImageView.ScaleType.CENTER);
                image.setLayoutParams(new ImageSwitcher.LayoutParams(ImageSwitcher.LayoutParams.WRAP_CONTENT,
                        ImageSwitcher.LayoutParams.WRAP_CONTENT));
                return  image ;
            };
        });
        for(int i=0;i<imageIds.length;i++){
           Map<String,Object> map = new HashMap<>();
            map.put("image",imageIds[i]);
            items.add(map);
        }
        SimpleAdapter adapter = new SimpleAdapter(ImageSwitcherTest.this,
                items,R.layout.call,new String[]{"image"},
                new int[]{ R.id.image1});
        gridView.setAdapter(adapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switcher.setImageResource(imageIds[position]);
            }
        });
    }

}
