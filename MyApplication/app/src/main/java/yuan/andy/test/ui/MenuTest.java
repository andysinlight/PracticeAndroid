package yuan.andy.test.ui;

import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.SurfaceHolder;
import android.widget.EditText;
import android.widget.Toast;

import yuan.andy.test.R;

public class MenuTest extends ActionBarActivity {
    final   int FORT_GREEN = 0x121;
    final  int FORT_RED = 0x122;
    final  int FORT_YELLO = 0x123;
    final  int FORT_18 = 0x124;
    final  int FORT_19 = 0x125;
    final  int FORT_20 = 0x126;
    final  int NORME = 0x127;
    EditText edit ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_test);
        edit=(EditText)findViewById(R.id.menuEditText);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        SubMenu fort_color = menu.addSubMenu("字体颜色");
        fort_color.setHeaderTitle("选择字体颜色");
        fort_color.setHeaderIcon(R.drawable.ic_launcher);
        SubMenu fort_size = menu.addSubMenu("字体大小");
        fort_size.setHeaderTitle("选择字体大小");
        fort_size.setHeaderIcon(R.drawable.ap);

        menu.add(0,NORME,0,"普通菜单");
        fort_size.add(0,FORT_18,0,"18号字体");
        fort_size.add(0,FORT_19,0,"19号字体");
        fort_size.add(0,FORT_20,0,"20号字体");
        fort_color.add(0,FORT_GREEN,0,"绿色");
        fort_color.add(0,FORT_RED, 0,"红色");
        fort_color.add(0,FORT_YELLO, 0,"黄色");
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id){
            case FORT_18:
                edit.setTextSize(18);
                break;
            case FORT_19:
                edit.setTextSize(19);
                break;
            case FORT_20:
                edit.setTextSize(20);
                break;
            case FORT_RED:
                edit.setTextColor(Color.RED);
                break;
            case FORT_GREEN:
                edit.setTextColor(Color.GREEN);
                break;
            case FORT_YELLO:
                edit.setTextColor(Color.YELLOW);
                break;
            case NORME:
                Toast.makeText(MenuTest.this,"点击的普通菜单",Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
