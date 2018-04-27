package com.example.asus.luasbangun;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.content.Intent;
import android.widget.ImageButton;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        final Animation scale = AnimationUtils.loadAnimation(this, R.anim.scale);

        //menginisiasi dan memanggil widget button pada file layout
        ImageButton btn1 =(ImageButton) findViewById(R.id.imageButton);
        ImageButton btn2 =(ImageButton) findViewById(R.id.imageButton2);
        ImageButton btn7 =(ImageButton) findViewById(R.id.imageButton7);

        btn1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                v.startAnimation(scale);
                // TODO Auto-generated method stub
                Intent move = new Intent(MainActivity.this, DashboardActivitythird.class);
                startActivity(move);
                //menghubungkan antar activity dengan intent
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                v.startAnimation(scale);
                // TODO Auto-generated method stub
                Intent move = new Intent(MainActivity.this, PetunjukActivity.class);
                startActivity(move);
                //menghubungkan antar activity dengan intent
            }
        });

        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder a_builder = new AlertDialog.Builder(MainActivity.this);
                a_builder.setMessage("Apa Kamu Yakin Ingin Keluar?")
                        .setCancelable(false)
                        .setPositiveButton("Iya", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                finishAffinity();
                                System.exit(0);
                            }
                        })
                        .setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        }) ;
                AlertDialog alert = a_builder.create();
                alert.setTitle("EXIT");
                alert.setIcon(android.R.drawable.ic_menu_myplaces);
                alert.show();
            }

        });
    }

    @Override
    public void onBackPressed () {
        new AlertDialog.Builder(this).setIcon(android.R.drawable.ic_menu_myplaces).setTitle("Exit Game")
                .setMessage("Apa Kamu Yakin Ingin Keluar?")
                .setPositiveButton("Iya", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finishAffinity();
                        System.exit(0);
                    }
                }).setNegativeButton("Tidak", null).show();
    }

}