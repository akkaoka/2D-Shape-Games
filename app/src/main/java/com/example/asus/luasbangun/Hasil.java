package com.example.asus.luasbangun;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Hasil extends Activity implements View.OnClickListener {
    TextView nilaibenar;
    TextView nilaisalah;
    ImageView back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hasil);

        int benar = getIntent().getIntExtra("BENAR", 0);
        int salah = getIntent().getIntExtra("SALAH", 0);
        nilaibenar = (TextView) findViewById(R.id.hasil01);
        nilaibenar.setText(" " + benar);
        nilaisalah = (TextView) findViewById(R.id.hasil02);
        nilaisalah.setText(" " + salah);

        back = (ImageView) findViewById(R.id.Back);
        back.setOnClickListener(this);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(Hasil.this, DashboardActivitythird.class);
                startActivity(i);
                finish();
            }

        });
    }
    public void onClick(View arg0) {
        // TODO Auto-generated method stub
    }

    @Override
    public void onBackPressed() {
        Intent i = new Intent(Hasil.this, DashboardActivitythird.class);
        startActivity(i);
        finish();
    }
}

