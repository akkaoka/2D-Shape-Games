package com.example.asus.luasbangun;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;

public class BelajarPerpanjang extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.belajar_perpanjang);
        final Animation scale = AnimationUtils.loadAnimation(this, R.anim.scale);
        //menginisiasi dan memanggil widget button pada file layout
        ImageButton btn16 =(ImageButton) findViewById(R.id.imageButton16);
        ImageButton btn17 =(ImageButton) findViewById(R.id.imageButton17);
        ImageButton btn18 =(ImageButton) findViewById(R.id.imageButton18);


        btn16.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                arg0.startAnimation(scale);
                // TODO Auto-generated method stub
                Intent move = new Intent(BelajarPerpanjang.this, BelajarActivity.class);
                startActivity(move);
                //menghubungkan antar activity dengan intent

            }
        });
        btn17.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                arg0.startAnimation(scale);
                // TODO Auto-generated method stub
                Intent move = new Intent(BelajarPerpanjang.this, BelajarActivity.class);
                startActivity(move);
                //menghubungkan antar activity dengan intent

            }
        });
        btn18.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                arg0.startAnimation(scale);
                // TODO Auto-generated method stub
                Intent move = new Intent(BelajarPerpanjang.this, BelajarPerpanjang2.class);
                startActivity(move);
                //menghubungkan antar activity dengan intent

            }
        });
    }
    public void onBackPressed() {
        Intent i = new Intent(BelajarPerpanjang.this, BelajarActivity.class);
        startActivity(i);
        finish();
    }
}
