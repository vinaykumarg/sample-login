package com.example.vinayg.resumebuilder;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by vinay.g.
 */

public class SplashScreen extends Activity {
    private static int SPLASH_TIME_OUT = 5000;
    private Animation mAnimation1, mAnimation2;
    private TextView sampleTextView;
    private ImageView mImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        sampleTextView = (TextView) findViewById(R.id.textView);
        mImageView = (ImageView) findViewById(R.id.imgLogo);
        mAnimation1 = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.sample_animation);
        sampleTextView.startAnimation(mAnimation1);
        mAnimation2 = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade_in);
        mImageView.startAnimation(mAnimation2);
        new Handler().postDelayed(new Runnable() {

            /*
             * Showing splash screen with a timer. This will be useful when you
             * want to show case your app logo / company
             */

            @Override
            public void run() {
                // This method will be executed once the timer is over
                // Start your app main activity
                Intent i = new Intent(SplashScreen.this, Main2Activity.class);
                startActivity(i);

                // close this activity
                finish();
            }
        }, SPLASH_TIME_OUT);
    }
}

