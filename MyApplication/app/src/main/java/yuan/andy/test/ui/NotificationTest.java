package yuan.andy.test.ui;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import yuan.andy.test.R;

public class NotificationTest extends ActionBarActivity {
    NotificationManager nm ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification_test);
        nm = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
    }

    public void send(View v){
        Intent intent = new Intent();
        intent.setAction("andy.TabHostTest");
        PendingIntent pendingIntent = PendingIntent.getActivity(NotificationTest.this,12312,intent,0);
        Notification noti= new Notification.Builder(this)
                .setSmallIcon(R.drawable.ap)
                .setAutoCancel(true)
                .setContentText("加薪了")
                .setContentTitle("jiaxin")
                .setTicker("来消息了")
                .setWhen(System.currentTimeMillis())
                .setContentIntent(pendingIntent).build();
        nm.notify(12312,noti);
    }

    public void del(){
        nm.cancel(12312);
    }

}
