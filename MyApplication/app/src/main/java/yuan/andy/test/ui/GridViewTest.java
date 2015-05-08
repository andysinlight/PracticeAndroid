package yuan.andy.test.ui;

import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import yuan.andy.test.R;

public class GridViewTest extends Activity {
    GridView gridView ;
    ImageView image ;
    int [] images = new int[]{
            R.drawable.image1,R.drawable.image2,R.drawable.image3,R.drawable.image4,R.drawable.image5,
            R.drawable.image6,R.drawable.image7
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_view_test);
        gridView = (GridView)findViewById(R.id.gridView);
        image =(ImageView)findViewById(R.id.gridImage);

        List<Map<String ,Object>> items= new ArrayList<Map<String,Object>>();
        for(int i=0;i<images.length;i++){
            Map<String,Object> map = new HashMap<String,Object>();
            map.put("girl",images[i]);
            items.add(map);
        }

        SimpleAdapter adapter = new SimpleAdapter(this,items,R.layout.call,
                new String[]{"girl"},new int []{R.id.image1});
        gridView.setAdapter(adapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                image.setImageResource(images[position]);
            }
        });
    }

}
