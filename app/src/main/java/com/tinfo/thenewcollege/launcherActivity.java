package com.tinfo.thenewcollege;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.Toast;

public class launcherActivity extends AppCompatActivity {
      private ImageView yeah;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launcher);
        getWindow().setStatusBarColor(Color.parseColor("#FFFFFFFF"));
        getSupportActionBar().hide();

yeah=(ImageView) findViewById(R.id.imageView6);


        Animation animation1 = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.clockwise);
        yeah.startAnimation(animation1);





        int secondsDelayed = 1;
        new Handler().postDelayed(new Runnable() {
            public void run() {
                startActivity(new Intent(launcherActivity.this, Studentauthactivity.class));
                finish();
                Toast.makeText(launcherActivity.this,"Don't forget to turn on Mobile Data!",Toast.LENGTH_SHORT).show();
            }
        }, secondsDelayed * 1200);



    }
}