package yuan.andy.test.ui;

import android.app.Activity;
import android.graphics.Path;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.GridLayout;

import yuan.andy.test.R;

public class GridLayoutTest extends Activity {
    String [] chars = new String []{
            "9","8","7","-",
            "6","5","4","+",
            "3","2","1","-",
            ".","0","=","*"

    };
    GridLayout gridLayout;

    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_layout_test);
        gridLayout = (GridLayout) findViewById(R.id.gridRoot);

        for(int i = 0 ; i < chars.length ; i++)
        {
            Button bn = new Button(this);
            bn.setText(chars[i]);
            // 设置该按钮的字体大小
            bn.setTextSize(40);
            // 指定该组件所在的行
            GridLayout.Spec rowSpec = GridLayout.spec(i / 4 + 2);
            // 指定该组件所在列
            GridLayout.Spec columnSpec = GridLayout.spec(i % 4);
            GridLayout.LayoutParams params = new GridLayout.LayoutParams(
                    rowSpec , columnSpec);
            // 指定该组件占满父容器
            //params.setGravity(Gravity.FILL);
            gridLayout.addView(bn , params);
        }
    }


}
