package yuan.andy.test.ui;

import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupMenu;

import yuan.andy.test.R;

public class PopupMenuTest extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popup_menu_test);
    }

    public void showPopupMenu(View v){
        PopupMenu popupMenu =new PopupMenu(PopupMenuTest.this,v);
        getMenuInflater().inflate(R.menu.menu_menu_res_test,popupMenu.getMenu());
        popupMenu.show();
    }

}
