package yuan.andy.test.ui;

import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.Toast;

import yuan.andy.test.R;

public class RatingBarTest extends Activity {
    RatingBar bar ;
    ImageView view ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rating_bar_test);
        bar = (RatingBar)findViewById(R.id.ratingBar);
        view = (ImageView)findViewById(R.id.ratingView);
        view.setImageResource(R.drawable.image1);
        bar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                view.setAlpha((int)rating * 255 / 5);
            }
        });
    }

}
