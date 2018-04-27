package com.example.asus.luasbangun;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;

public class BelajarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.belajar);
        final Animation scale = AnimationUtils.loadAnimation(this, R.anim.scale);

        //menginisiasi dan memanggil widget button pada file layout
        ImageButton btn8 =(ImageButton) findViewById(R.id.imageButton8);
        ImageButton btn12 =(ImageButton) findViewById(R.id.imageButton12);
        ImageButton btn9 =(ImageButton) findViewById(R.id.imageButton9);
        ImageButton btn10 =(ImageButton) findViewById(R.id.imageButton10);
        ImageButton btn11 =(ImageButton) findViewById(R.id.imageButton11);

        btn8.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                arg0.startAnimation(scale);
                // TODO Auto-generated method stub
                Intent move = new Intent(BelajarActivity.this, BelajarPersegi.class);
                startActivity(move);
                //menghubungkan antar activity dengan intent
            }
        });
        btn12.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                arg0.startAnimation(scale);
                // TODO Auto-generated method stub
                Intent move = new Intent(BelajarActivity.this, BelajarTrapesium.class);
                startActivity(move);
                //menghubungkan antar activity dengan intent
            }
        });
        btn9.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                arg0.startAnimation(scale);
                // TODO Auto-generated method stub
                Intent move = new Intent(BelajarActivity.this, BelajarPerpanjang.class);
                startActivity(move);
                //menghubungkan antar activity dengan intent
            }
        });
        btn10.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                arg0.startAnimation(scale);
                // TODO Auto-generated method stub
                Intent move = new Intent(BelajarActivity.this, BelajarSegitiga.class);
                startActivity(move);
                //menghubungkan antar activity dengan intent
            }
        });
        btn11.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                arg0.startAnimation(scale);
                // TODO Auto-generated method stub
                Intent move = new Intent(BelajarActivity.this, BelajarLingkaran.class);
                startActivity(move);
                //menghubungkan antar activity dengan intent
            }
        });
    }
    public void onBackPressed() {
        Intent i = new Intent(BelajarActivity.this, DashboardActivitythird.class);
        startActivity(i);
        finish();
    }
}
