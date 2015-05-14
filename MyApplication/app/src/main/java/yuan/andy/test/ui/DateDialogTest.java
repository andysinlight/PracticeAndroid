package yuan.andy.test.ui;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import java.util.Calendar;

import yuan.andy.test.R;

public class DateDialogTest extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date_dialog_test);
        Button b1 = (Button)findViewById(R.id.pickDateButton);
        Button b2 = (Button)findViewById(R.id.pickTimeButton);
        b1.setOnClickListener(new View.OnClickListener() {
            Calendar c = Calendar.getInstance();
            @Override
            public void onClick(View v) {
                DatePickerDialog pickerDialog = new DatePickerDialog(DateDialogTest.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                                TextView textView = (TextView)findViewById(R.id.dataPickVeiw);
                                textView.setText(year+":"+monthOfYear+":"+dayOfMonth);
                            }
                        }
                        , c.get(Calendar.YEAR)
                        , c.get(Calendar.MONTH)
                        , c.get(Calendar.DAY_OF_MONTH));
                pickerDialog.show();
            }
        });
    }

}
