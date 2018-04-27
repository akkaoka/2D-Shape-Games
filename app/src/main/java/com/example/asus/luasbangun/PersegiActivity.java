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

public class PersegiActivity extends AppCompatActivity {
    /** Inisialisasi */
    EditText s;
    ImageButton hitung;
    TextView hasil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.persegi);
        final Animation scale = AnimationUtils.loadAnimation(this, R.anim.scale);

        s=(EditText)findViewById(R.id.editText2);
        hasil=(TextView)findViewById(R.id.textView);
        hitung =(ImageButton) findViewById(R.id.imageButton14);

        hitung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(scale);
                //notifikasi jika tidak diisi
                if (s.length()==0){
                    Toast.makeText(getApplication(),"Sisi belum dimasukkan",Toast.LENGTH_LONG).show();
                }
                else {
                    String isisisi=s.getText().toString();
                    double s=Double.parseDouble(isisisi);
                    double hs=LuasPersegi(s);
                    String output=String.valueOf(hs);
                    hasil.setText(output.toString());
                }
            }
        });
    }
    public double LuasPersegi(double s){
        return s*s;
    }
}

