package yuan.andy.test.ui;

import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ViewSwitcher;

import java.util.ArrayList;
import java.util.zip.Inflater;

import yuan.andy.test.R;

public class ViewSwitcherTest extends Activity {
    ViewSwitcher switcher ;
    int NUM_SCREEN =12 ;
    int count ;
    int screen_now=0 ;
    LayoutInflater inflater ;

    GridView gridView ;
   public static class names {
      public int drawable ;
       public String text ;
    };

    ArrayList<names> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_switcher_test);
        switcher = (ViewSwitcher)findViewById(R.id.viewSitcher);
        inflater = getLayoutInflater();
        for(int i=0;i<40;i++){
            names name =new names();
            name.drawable = R.drawable.ap;
            name.text=i+"";
            list.add(name);
        }
        count = 40 % NUM_SCREEN == 0?
                40%NUM_SCREEN:40%NUM_SCREEN+1;
        switcher.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                GridView view = (GridView)inflater.inflate(R.layout.gridview_layout,null);
                return view;
            }
        });
        next(null);
    }

    public void next(View v){
        if(screen_now<count-1){
            screen_now++;
            switcher.setInAnimation(ViewSwitcherTest.this,android.R.anim.slide_in_left);
            switcher.setOutAnimation(ViewSwitcherTest.this,android.R.anim.slide_out_right);
            ((GridView)switcher.getNextView()).setAdapter(adapter);
            switcher.showNext();
        }
    }

    public void pre(View v){
        if(screen_now>1){
            screen_now--;
            switcher.setInAnimation(ViewSwitcherTest.this,android.R.anim.slide_in_left);
            switcher.setOutAnimation(ViewSwitcherTest.this,android.R.anim.slide_out_right);
            ((GridView)switcher.getNextView()).setAdapter(adapter);
            switcher.showPrevious();
        }
    }

    BaseAdapter adapter  = new BaseAdapter() {
        @Override
        public int getCount() {
            if(screen_now==count-1&&list.size()%12!=0){
                return list.size()%12;
            }
            return 12;
        }

        @Override
        public names getItem(int position) {
            return list.get((screen_now-1)*12+position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View root = convertView ;
            if(convertView==null){
                root = (LinearLayout)inflater.inflate(R.layout.shortcut_layout,null);
            }
            ImageView image =(ImageView)root.findViewById(R.id.shortCutImage);
            TextView text = (TextView)root.findViewById(R.id.shortCutText);
            text.setText(getItem(position).text);
            image.setImageResource(getItem(position).drawable);
            return root;
        }
    };
}
