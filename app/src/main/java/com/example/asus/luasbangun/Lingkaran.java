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

public class Lingkaran extends AppCompatActivity {
    EditText r;
    ImageButton hitung;
    TextView hasil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lingkaran);
        final Animation scale = AnimationUtils.loadAnimation(this, R.anim.scale);

        r=(EditText)findViewById(R.id.editText2);
        hasil=(TextView)findViewById(R.id.textView);
        hitung =(ImageButton) findViewById(R.id.imageButton14);

        hitung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(scale);
                //notifikasi jika tidak diisi
                if (r.length()==0){
                    Toast.makeText(getApplication(),"Jari-jari belum dimasukkan",Toast.LENGTH_LONG).show();
                }
                else {
                    String isijari=r.getText().toString();
                    double r=Double.parseDouble(isijari);
                    double hs=LuasPersegi(r);
                    String output=String.valueOf(hs);
                    hasil.setText(output.toString());
                }
            }
        });
    }
    public double LuasPersegi(double r){
        return 3.14*r*r;
    }
}