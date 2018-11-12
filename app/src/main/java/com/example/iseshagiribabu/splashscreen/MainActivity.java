package com.example.iseshagiribabu.splashscreen;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.WindowManager;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.target.GlideDrawableImageViewTarget;

public class MainActivity extends AppCompatActivity {

    /** Duration of wait **/
    private final int SPLASH_DISPLAY_LENGTH = 10000;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle icicle) {
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(icicle);
        setContentView(R.layout.activity_main);

        /* New Handler to start the Menu-Activity
         * and close this Splash-Screen after some seconds.*/
        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {
                /* Create an Intent that will start the Menu-Activity. */
                Intent mainIntent = new Intent(MainActivity.this,HomeActivity.class);
                MainActivity.this.startActivity(mainIntent);
                ImageView imageView = findViewById(R.id.image_view);
                GlideDrawableImageViewTarget splashScreen = new GlideDrawableImageViewTarget(imageView);
                Glide.with(MainActivity.this).load(R.drawable.zebra2).into(splashScreen);
                MainActivity.this.finish();
            }
        }, SPLASH_DISPLAY_LENGTH);
    }

}
