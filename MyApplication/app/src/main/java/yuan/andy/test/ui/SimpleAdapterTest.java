package yuan.andy.test.ui;

import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import yuan.andy.test.R;

public class SimpleAdapterTest extends Activity {
    int hander [] = new int[]{
            R.drawable.az,R.drawable.at,R.drawable.ap
    };
    String [] names = new String[]{
      "李白","苏轼","李清照"
    };

    String [] describle = new String[]{
            "浪漫主义诗人","我喜欢的诗人","我不知道什么派的诗人"
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_adapter_test);
        ListView listView = (ListView)findViewById(R.id.simle_listview);
        List<Map<String,Object>> items = new ArrayList<>();
        for(int i=0;i<names.length;i++){
            Map<String,Object> map = new HashMap<>();
            map.put("name",names[i]);
            map.put("describle",describle[i]);
            map.put("hander",hander[i]);
            items.add(map);
        }

        SimpleAdapter adapter = new SimpleAdapter(this,items,
                R.layout.simple_adapter_layout,
                new String[]{"hander","name","describle"},
                new int[]{R.id.simple_image,R.id.simpleTextView1,R.id.simpleTextView2});
        listView.setAdapter(adapter);
    }

}
