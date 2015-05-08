package yuan.andy.test.ui;

import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.MultiAutoCompleteTextView;

import yuan.andy.test.R;

public class AutoCompleteTextViewTest extends Activity {
    AutoCompleteTextView view1;
    MultiAutoCompleteTextView view2 ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auto_complete_text_view_test);
        view1= (AutoCompleteTextView)findViewById(R.id.completeView1);
        view2= (MultiAutoCompleteTextView)findViewById(R.id.completeView2);
        ArrayAdapter<String> adapter = new ArrayAdapter<String >(this,R.layout.arraytext,
                getResources().getStringArray(R.array.names));
        view1.setAdapter(adapter);
        view2.setAdapter(adapter);
        view2.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());
    }
}
