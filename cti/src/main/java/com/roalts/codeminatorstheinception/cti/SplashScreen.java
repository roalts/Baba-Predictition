package com.roalts.codeminatorstheinception.cti;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;

/**
 * Created by raghav on 26/03/14.
 */
public class SplashScreen extends Activity {
    final private int Splash_display_length = 5000;
    MediaPlayer m;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        m = MediaPlayer.create(this, R.raw.la);
        m.start();
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.splash_screen);

/* New Handler to start the Menu-Activity
         * and close this Splash-Screen after some seconds.*/
        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {
                                               /* Create an Intent that will start the Menu-Activity. */
                Intent mainIntent = new Intent(SplashScreen.this,MainActivity.class);
                SplashScreen.this.startActivity(mainIntent);
                SplashScreen.this.finish();
            }
        }, Splash_display_length);
    }

    @Override
    public void onBackPressed() {
        m.pause();
        super.onBackPressed();
    }
}
