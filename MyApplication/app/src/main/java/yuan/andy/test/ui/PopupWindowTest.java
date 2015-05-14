package yuan.andy.test.ui;

import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;

import yuan.andy.test.R;

public class PopupWindowTest extends Activity {
    PopupWindow popupWindow ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popup_window_test);
        LinearLayout root = (LinearLayout)getLayoutInflater().inflate(R.layout.call, null);
        ImageView image = (ImageView)root.findViewById(R.id.image1);
        image.setImageDrawable(getResources().getDrawable(R.drawable.image1));
        popupWindow = new PopupWindow(root,280,360);
        Button button =(Button)root.findViewById(R.id.cancle);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupWindow.dismiss();
            }
        });
    }

   public void popupBn(View v){
      //  popupWindow.showAtLocation(findViewById(R.id.popupBn), Gravity.CENTER,20,20);
       popupWindow.showAsDropDown(v);
   }

}
