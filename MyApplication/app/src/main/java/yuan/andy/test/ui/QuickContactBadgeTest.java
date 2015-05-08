package yuan.andy.test.ui;

import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.QuickContactBadge;

import yuan.andy.test.R;

public class QuickContactBadgeTest extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quick_contact_badge_test);
        QuickContactBadge badge = (QuickContactBadge)findViewById(R.id.myBrage);
        badge.assignContactFromPhone("13872766110",false);
    }
}
