package yuan.andy.test.ui;

import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ViewFlipper;

import yuan.andy.test.R;

public class ViewFlipperTest extends Activity {
    ViewFlipper flipper ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_flipper_test);
        flipper = (ViewFlipper)findViewById(R.id.viewFlipper);
    }

    public void next(View v){
     flipper.showNext();
        flipper.stopFlipping();
    }
    public void  pre(View v){
        flipper.showPrevious();
        flipper.stopFlipping();
    }
    public void auto (View c){
        flipper.startFlipping();
    }

}
