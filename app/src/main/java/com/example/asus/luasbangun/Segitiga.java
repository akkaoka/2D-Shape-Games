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

public class Segitiga extends AppCompatActivity {
    //inisialisasi
    EditText a;
    EditText t;
    ImageButton hitung;
    TextView hasil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.segitiga);
        final Animation scale = AnimationUtils.loadAnimation(this, R.anim.scale);

        a=(EditText)findViewById(R.id.editText);
        t=(EditText)findViewById(R.id.editText2);
        hasil=(TextView)findViewById(R.id.textView);
        hitung =(ImageButton) findViewById(R.id.imageButton14);

        hitung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(scale);
                //notifikasi jika tidak diisi
                if (a.length()==0){
                    Toast.makeText(getApplication(),"Alas belum dimasukkan",Toast.LENGTH_LONG).show();
                }
                else if (t.length()==0){
                    Toast.makeText(getApplication(),"Tinggi belum dimasukkan",Toast.LENGTH_LONG).show();
                }
                else {
                    String isialas=a.getText().toString();
                    double a=Double.parseDouble(isialas);
                    String isitinggi=t.getText().toString();
                    double t=Double.parseDouble(isitinggi);
                    double hs=LuasPerpanjang(a,t);
                    String output=String.valueOf(hs);
                    hasil.setText(output.toString());
                }
            }
        });
    }
    public double LuasPerpanjang(double a, double t){
        return a*t/2;
    }
}
