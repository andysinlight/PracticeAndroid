package yuan.andy.test.ui;

import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.ToggleButton;

import yuan.andy.test.R;

public class ToggleButtonTest extends Activity {
    Switch switchB ;
    ToggleButton toggleButton ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toggle_button_test);
        switchB = (Switch)findViewById(R.id.switchB);
        toggleButton = (ToggleButton)findViewById(R.id.toggle);
        final LinearLayout linearLayout = (LinearLayout)findViewById(R.id.textLine);
        CompoundButton.OnCheckedChangeListener listener = new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                       if(isChecked){
                           linearLayout.setOrientation(LinearLayout.HORIZONTAL);
                       }else{
                           linearLayout.setOrientation(LinearLayout.VERTICAL);
                       }
            }
        };

        switchB.setOnCheckedChangeListener(listener);
        toggleButton.setOnCheckedChangeListener(listener);
    }

}
