package yuan.andy.test.ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.ViewSwitcher;

import yuan.andy.test.R;


public class TextSwitcherTest extends Activity {
    TextSwitcher text ;
    int i =0;
    String [] str = new String[]{
      "好好学习天天天向上","百万年薪在前面等着你呢？","呵呵 ！"
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_switcher_test);
        text = (TextSwitcher)findViewById(R.id.textSwitch);
        text.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                TextView view = new TextView(TextSwitcherTest.this);
                view.setTextSize(20);
              return  view;
            };
        });
    }

    public void next(View v){
        text.setText(str[i++%str.length]);
    }

}
