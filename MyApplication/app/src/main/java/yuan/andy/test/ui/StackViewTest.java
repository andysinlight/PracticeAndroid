package yuan.andy.test.ui;

import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.SimpleAdapter;
import android.widget.StackView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import yuan.andy.test.R;

public class StackViewTest extends Activity {
    int[] imageIds = new int[]
            {
                    R.drawable.bomb5 , R.drawable.bomb6 , R.drawable.bomb7
                    , R.drawable.bomb8 , R.drawable.bomb9 , R.drawable.bomb10
                    , R.drawable.bomb11 , R.drawable.bomb12	, R.drawable.bomb13
                    , R.drawable.bomb14 , R.drawable.bomb15 , R.drawable.bomb16
            };
    StackView staceView ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stack_view_test);
        staceView=(StackView)findViewById(R.id.stackView);
        List<Map<String,Object>> items =new ArrayList();
        for(int i=0;i<imageIds.length;i++){
            Map<String,Object> map = new HashMap<>();
            map.put("image",imageIds[i]);
            items.add(map);
        }
        SimpleAdapter adapter = new SimpleAdapter(this,items,
                R.layout.call,new String[]{"image"},new int[]{R.id.image1});
        staceView.setAdapter(adapter);
    }

    public void pre(View v){
        staceView.showPrevious();
    }
    public void next(View v){
        staceView.showNext();
    }

}
