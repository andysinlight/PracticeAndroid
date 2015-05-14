package yuan.andy.test.ui;

import android.app.TabActivity;
import android.os.Bundle;
import android.widget.TabHost;

import yuan.andy.test.R;

public class TabHostTest extends TabActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_tab_host_test);
        TabHost host =getTabHost();
        TabHost.TabSpec spec1=host.newTabSpec("1")
                .setIndicator("no.1")
                .setContent(R.id.tab1);
        host.addTab(spec1);
        host.addTab(host.newTabSpec("2").setIndicator("no.2").setContent(R.id.tab2));
        host.addTab(host.newTabSpec("3").setIndicator("no.3").setContent(R.id.tab3));
    }
}