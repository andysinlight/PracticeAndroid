package yuan.andy.test.ui;

import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import yuan.andy.test.R;

public class ArrayAdapterTest extends Activity {
    ListView list1,list2 ;
    String [] array1 = new String[]{
      "牛魔王","孙悟空","猪八戒","唐僧"
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_array_adapter_test);
        list1 =(ListView)findViewById(R.id.arrayList1);
        list2 = (ListView)findViewById(R.id.arrayList2);

        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this,R.layout.arraytext,array1);
        list1.setAdapter(adapter1);
        list2.setAdapter(new ArrayAdapter<String>(ArrayAdapterTest.this,
                R.layout.check_arraylist,getResources().getStringArray(R.array.names)));
    }

}
