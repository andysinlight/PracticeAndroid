package yuan.andy.test.ui;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import yuan.andy.test.R;

public class AlertDialogTest extends Activity {


    String [] a =new String[]{"sakjdhfjk","asjdlfk","asdljfk"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alert_dialog_test);
    }
    public void simpleDialog(View v ){
        AlertDialog.Builder bulider = new AlertDialog.Builder(this)
                .setTitle("简单的对话框")
                .setIcon(R.drawable.ic_launcher)
                .setMessage("简单的对话框\n 对话框测试");
                setPositiveButton(bulider);
                setNegativeButton(bulider)
                        .create()
                        .show();

    }

    public void  simpleList(View v){
        AlertDialog.Builder builder = new AlertDialog.Builder(this)
                .setTitle("简单的List")
                .setIcon(R.drawable.ic_launcher)
                .setItems(R.array.names, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                      Toast.makeText(AlertDialogTest.this, "" + which, Toast.LENGTH_SHORT).show();
                    }
                });
        setPositiveButton(builder);
        setNegativeButton(builder)
                .create()
                .show();
    }

    public void singleChoice(View v){
        AlertDialog.Builder build = new AlertDialog.Builder(this)
                .setTitle("简单的单选List")
                .setIcon(R.drawable.ic_launcher)
                .setSingleChoiceItems(R.array.names, 1, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(AlertDialogTest.this, "" + which, Toast.LENGTH_SHORT);
                    }
                });
        setPositiveButton(build);
        setNegativeButton(build)
                .create()
                .show();
    }

    public  void multiChoice(View v){
        AlertDialog.Builder builder = new AlertDialog.Builder(this)
                .setTitle("多选的对话框")
                .setIcon(R.drawable.ic_launcher)
                .setMultiChoiceItems(R.array.names, new boolean[]{true, true, false, true},
                        new DialogInterface.OnMultiChoiceClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                                Toast.makeText(AlertDialogTest.this, "" + which, Toast.LENGTH_SHORT);
                            }
                        });
        setPositiveButton(builder);
        setNegativeButton(builder)
                .create()
                .show();
    }

    public void customList(View v){
        AlertDialog.Builder builder = new AlertDialog.Builder(this)
                .setTitle("自定义的list")
                .setIcon(R.drawable.ic_launcher)
                .setAdapter(new ArrayAdapter<String>(AlertDialogTest.this,R.layout.check_arraylist,a),null);
        setPositiveButton(builder);
        setNegativeButton(builder)
                .create()
                .show();
    }

    private AlertDialog.Builder setPositiveButton(AlertDialog.Builder builder){
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(AlertDialogTest.this,"点解了确定按钮",Toast.LENGTH_SHORT).show();
            }
        });
       return builder ;
    }

    private AlertDialog.Builder setNegativeButton(AlertDialog.Builder builder){
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(AlertDialogTest.this,"你点击了取消按钮",Toast.LENGTH_SHORT).show();
            }
        });
        return  builder;
    }
}
