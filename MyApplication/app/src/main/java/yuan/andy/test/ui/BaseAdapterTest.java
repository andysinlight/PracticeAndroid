package yuan.andy.test.ui;

import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import yuan.andy.test.R;

public class BaseAdapterTest extends Activity {
    ListView view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base_adapter_test);
        view = (ListView)findViewById(R.id.baseList);
        BaseAdapter adapter = new BaseAdapter() {
            @Override
            public int getCount() {
                return 20;
            }

            @Override
            public Object getItem(int position) {
                return position;
            }

            @Override
            public long getItemId(int position) {
                return position;
            }

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                LinearLayout line = new LinearLayout(BaseAdapterTest.this);
                line.setOrientation(LinearLayout.HORIZONTAL);
                ImageView image = new ImageView(BaseAdapterTest.this);
                image.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT));
                image.setImageResource(R.drawable.thum);
                TextView textView = new TextView(BaseAdapterTest.this);
                textView.setText("第" + (position + 1) + "行");
                line.addView(image);
                line.addView(textView);
                return line;
            }
        };
        view.setAdapter(adapter);
    }
}
