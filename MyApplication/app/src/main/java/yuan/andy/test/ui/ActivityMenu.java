package yuan.andy.test.ui;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;

import yuan.andy.test.R;

public class ActivityMenu extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity_menu);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        SubMenu submenu = menu.addSubMenu("Name");
        SubMenu colors = menu.addSubMenu("颜色");
        submenu.setIcon(R.drawable.ap);
        submenu.setHeaderTitle("选择 你的姓名");
        MenuItem menuitem = submenu.add("李四");
        menuitem.setIntent(new Intent("andy.ProgressDialogTest"));
        return super.onCreateOptionsMenu(menu);
    }
}
