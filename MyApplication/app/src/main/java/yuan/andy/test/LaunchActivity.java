package yuan.andy.test;

import android.app.ListActivity;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import yuan.andy.test.ui.CodeView;


public class LaunchActivity extends ListActivity {
    ArrayAdapter adapter ;
    String [] names ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        names = getResources().getStringArray(R.array.names);
        adapter = new ArrayAdapter(this,R.layout.arraytext,names);
        setListAdapter(adapter);
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        switch (position){
            case 0:
                startActivity(new Intent(LaunchActivity.this,UI.class));
                break;
        }
    }
}
