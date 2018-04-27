package com.example.asus.luasbangun;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;

public class DashboardActivitythird extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.third_dashboard);
        final Animation scale = AnimationUtils.loadAnimation(this, R.anim.scale);
        //menginisiasi dan memanggil widget button pada file layout
        ImageButton btn4 =(ImageButton) findViewById(R.id.imageButton4);
        ImageButton btn6 =(ImageButton) findViewById(R.id.imageButton6);
        ImageButton btn5 =(ImageButton) findViewById(R.id.imageButton5);

        btn4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                arg0.startAnimation(scale);
                // TODO Auto-generated method stub
                Intent move = new Intent(DashboardActivitythird.this, HitungActivity.class);
                startActivity(move);
                //menghubungkan antar activity dengan intent

            }
        });

        btn6.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                arg0.startAnimation(scale);
                // TODO Auto-generated method stub
                Intent move = new Intent(DashboardActivitythird.this, BelajarActivity.class);
                startActivity(move);
                //menghubungkan antar activity dengan intent
            }
        });

        btn5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                arg0.startAnimation(scale);
                // TODO Auto-generated method stub
                Intent move = new Intent(DashboardActivitythird.this, KuisCoba.class);
                startActivity(move);
                //menghubungkan antar activity dengan intent
            }
        });

    }
    @Override
    public void onBackPressed() {
        Intent i = new Intent(DashboardActivitythird.this, MainActivity.class);
        startActivity(i);
        finish();
    }
}
