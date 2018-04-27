package com.example.asus.luasbangun;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class Trapesium extends AppCompatActivity {
    EditText atas;
    EditText bawah;
    EditText t;
    ImageButton hitung;
    TextView hasil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.trapesium);
        final Animation scale = AnimationUtils.loadAnimation(this, R.anim.scale);

        atas=(EditText)findViewById(R.id.editText);
        bawah=(EditText)findViewById(R.id.editText4);
        t=(EditText)findViewById(R.id.editText3);
        hasil=(TextView)findViewById(R.id.textView);
        hitung =(ImageButton) findViewById(R.id.imageButton14);

        hitung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(scale);
                //notifikasi jika tidak diisi
                if (atas.length()==0){
                    Toast.makeText(getApplication(),"Sisi Atas belum dimasukkan",Toast.LENGTH_LONG).show();
                }
                else if (bawah.length()==0){
                    Toast.makeText(getApplication(),"Sisi Bawah belum dimasukkan",Toast.LENGTH_LONG).show();
                }
                else if (t.length()==0){
                    Toast.makeText(getApplication(),"Tinggi belum dimasukkan",Toast.LENGTH_LONG).show();
                }
                else {
                    String isis1=atas.getText().toString();
                    double atas=Double.parseDouble(isis1);
                    String isis2=bawah.getText().toString();
                    double bawah=Double.parseDouble(isis2);
                    String isitinggi=t.getText().toString();
                    double t=Double.parseDouble(isitinggi);
                    double hs=LuasPerpanjang(atas,bawah,t);
                    String output=String.valueOf(hs);
                    hasil.setText(output.toString());
                }
            }
        });
    }
    public double LuasPerpanjang(double atas, double bawah, double t){
        return t*(atas+bawah)/2;
    }
}
