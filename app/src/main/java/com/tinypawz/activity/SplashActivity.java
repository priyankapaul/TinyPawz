package com.tinypawz.activity;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.support.v4.app.FragmentActivity;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.tinypawz.R;


public class SplashActivity extends FragmentActivity {
    public static String TAG = SplashActivity.class.getSimpleName();

    BroadcastReceiver mRegistrationBroadcastReceiver;
    private Animation animation;
    private ImageView logo;
//    private TextView appTitle;
    private TextView appSlogan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);


        // Show Offline Error Message
 /*       if (!Connectivity.isConnected(getApplicationContext())) {
            Intent i = new Intent(this, OfflineSplashActivity.class);
            startActivity(i);
        } else {

        }
*/
        logo = (ImageView) findViewById(R.id.logo_img);
        appSlogan = (TextView) findViewById(R.id.pro_txt);

        if (savedInstanceState == null) {
            flyIn();
        }

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                endSplash();
            }
        }, 3000);
    }

    private void flyIn() {
        animation = AnimationUtils.loadAnimation(this, R.anim.logo_animation);
        logo.startAnimation(animation);

        animation = AnimationUtils.loadAnimation(this, R.anim.pro_animation);
        appSlogan.startAnimation(animation);
    }

    private void endSplash() {
        animation = AnimationUtils.loadAnimation(this,
                R.anim.logo_animation_back);
        logo.startAnimation(animation);

        animation = AnimationUtils.loadAnimation(this,
                R.anim.pro_animation_back);
        appSlogan.startAnimation(animation);

        animation.setAnimationListener(new AnimationListener() {
            @Override
            public void onAnimationEnd(Animation arg0) {


                SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
                String isSecondTimeOpen = preferences.getString("splash", "");

                if (isSecondTimeOpen.equals("existSplash")) {


                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            startActivity(new Intent(SplashActivity.this, MainActivity.class));
                            finish();
                        }
                    }, 0);
                } else {
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            // TODO -- mimi to find proper place to start MainActivity
                            startActivity(new Intent(SplashActivity.this, MainActivity.class));
                            finish();
                        }
                    }, 0);
                }



        /*        Intent intent = new Intent(getApplicationContext(),
                        HomeSliderInfoActivity.class);
                startActivity(intent);
                finish();*/
            }

            @Override
            public void onAnimationRepeat(Animation arg0) {
            }

            @Override
            public void onAnimationStart(Animation arg0) {
            }
        });

    }

    @Override
    public void onBackPressed() {
        // Do nothing
    }

}
