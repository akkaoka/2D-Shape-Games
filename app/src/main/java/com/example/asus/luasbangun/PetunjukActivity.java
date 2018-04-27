package com.example.asus.luasbangun;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class PetunjukActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.petunjuk);
    }

    @Override
    public void onBackPressed() {
        Intent i = new Intent(PetunjukActivity.this, MainActivity.class);
        startActivity(i);
        finish();
    }
}
