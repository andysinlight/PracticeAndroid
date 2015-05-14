package yuan.andy.test.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import yuan.andy.test.R;

public class ProgressDialogTest extends Activity {
    int MAXPROGRESS = 100 ;
    int state = 0;
    int hasState = 0 ;
    ProgressDialog p1,p2 ;
    int [] date = new int[50] ;

    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            if(msg.what==12312){
                p1.setProgress(state);
            }
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress_dialog_test);
    }

   public void sprind(View v){
       ProgressDialog.show(ProgressDialogTest.this,"静态方法创建的","123657",false,true);
   }

    public void progress(View source)
    {
        // 将进度条的完成进度重设为0
        state = 0;
        // 重新开始填充数组。
        hasState = 0;
        p1 = new ProgressDialog(ProgressDialogTest.this);
        p1.setMax(MAXPROGRESS);
        // 设置对话框的标题
        p1.setTitle("任务完成百分比");
        // 设置对话框 显示的内容
        p1.setMessage("耗时任务的完成百分比");
        // 设置对话框不能用“取消”按钮关闭
        p1.setCancelable(false);
        // 设置对话框的进度条风格
        p1.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        // 设置对话框的进度条是否显示进度
        p1.setIndeterminate(false);
        p1.show(); //③

        new Thread()
        {
            public void run()
            {
                while (state < MAXPROGRESS)
                {
                    // 获取耗时操作的完成百分比
                    state = MAXPROGRESS
                            * doWork() / date.length;
                    // 发送空消息到Handler
                    handler.sendEmptyMessage(12312);
                }
                // 如果任务已经完成
               if (state >= MAXPROGRESS)
                {
                    // 关闭对话框
                    p1.dismiss();
                }
            }
        }.start();
    }
    public void inProgress(View v){
        p2 = new ProgressDialog(ProgressDialogTest.this);
        p2.setIndeterminate(true);
        p2.setIcon(R.drawable.ic_launcher);
        p2.setTitle("不是精确控制的Progress");
        p2.setCancelable(true);
        p2.show();
    }

    private int  doWork(){
        date[hasState++] = (int)Math.random()*100;
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return  hasState ;
    }

}
