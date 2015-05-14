package yuan.andy.test.ui;

import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import yuan.andy.test.R;

public class SpinnerTest extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner);
        Spinner spinner = (Spinner)findViewById(R.id.spinner2);
        String [] names = new String[]{
                "猪八戒","孙悟空","唐僧","沙和尚"
        };

        spinner.setAdapter(new ArrayAdapter<String>(SpinnerTest.this,
                android.R.layout.simple_dropdown_item_1line,names));
    }

}
