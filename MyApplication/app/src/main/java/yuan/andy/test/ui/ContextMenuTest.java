package yuan.andy.test.ui;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.EditText;

import yuan.andy.test.R;

public class ContextMenuTest extends Activity {
    final  int FORT_GREEN =0x123;
    final int FORT_RED = 0x124;
    final int FORT_YEELL = 0x125;
    EditText editText ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_context_menu_test);
        editText = (EditText)findViewById(R.id.contextMenuEdit);
        registerForContextMenu(editText);

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.add(0, FORT_GREEN, 0, "绿色");
        SubMenu sub = menu.addSubMenu("另外的颜色");
        sub.add(0,FORT_RED,0,"红色");
        sub.add(0,FORT_YEELL,0,"黄色");
        menu.setGroupCheckable(1,false,false);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        int id =item.getItemId();
        switch (id){
            case FORT_GREEN:
                editText.setTextColor(Color.GREEN);
                break ;
            case FORT_RED:
                editText.setTextColor(Color.RED);
                break ;
            case FORT_YEELL:
                editText.setTextColor(Color.YELLOW);
                break ;
        }
        return super.onContextItemSelected(item);
    }
}
