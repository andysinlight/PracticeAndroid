package yuan.andy.test.ui;

import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RadioGroup;
import android.widget.TextView;

import yuan.andy.test.R;

public class CheckButtonTest extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_button_test);
        RadioGroup radioGroup =(RadioGroup) findViewById(R.id.radioGroup);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                String s =checkedId==R.id.male?
                        "你的性别是男性":"您的性别是女性";
                TextView textView = (TextView)findViewById(R.id.showSex);
                textView.setText(s);
            }
        });
    }

}
