package com.example.asus.luasbangun;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Handler;
import android.os.Bundle;

public class DashboardActivity extends Activity {

    MediaPlayer soundbackground;
    private static int SPLASH_TIME_OUT = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dashboard);

        soundbackground = MediaPlayer.create(DashboardActivity.this, R.raw.shawn);

        soundbackground.setLooping(true);
        soundbackground.setVolume(1,1);
        soundbackground.start();

        new Handler().postDelayed(new Runnable() {

			/*
             * Showing splash screen with a timer. This will be useful when you
			 * want to show case your app logo / company
			 */

            @Override
            public void run() {

                Intent i = new Intent(DashboardActivity.this, MainActivity.class);
                startActivity(i);

                onResume();

            }

        }, SPLASH_TIME_OUT);
    }
}
