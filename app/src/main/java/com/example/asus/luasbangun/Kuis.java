package com.example.asus.luasbangun;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class Kuis extends Activity implements View.OnClickListener {
    MediaPlayer audioBackground;
    ImageButton btn_jwb;
    ImageButton btn_next;
    EditText jawabannya;
    TextView salahbenar;
    ImageView soal;
    int benar=0, salah=0, index=0;

    int [] pertanyaan={R.drawable.soal1,
            R.drawable.soal2,
            R.drawable.soal3,
            R.drawable.soalke4,
            R.drawable.soal5,
            R.drawable.soal6,
            R.drawable.soal10,
            R.drawable.soal8,
            R.drawable.soal9,
            R.drawable.soal7};
    int [] btn_jawab={R.drawable.jawab};
    int [] btn_go={R.drawable.go};
    String [] jawaban ={"64","314","50","33","60","180","314","56","50,24","16"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kuis);

        soal = (ImageView)findViewById(R.id.GambarSoal);
        soal.setImageResource(pertanyaan[0]);

        salahbenar = (TextView) findViewById(R.id.salahbenar);
        salahbenar.setText("");

        btn_jwb = (ImageButton) findViewById(R.id.jawab);
        btn_jwb.setOnClickListener(this);

        btn_next = (ImageButton) findViewById(R.id.next);
        btn_next.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        // TODO Auto-generated method stub
        salahbenar=(TextView)findViewById(R.id.salahbenar);
        jawabannya=(EditText)findViewById(R.id.jawabannya);
        btn_jwb.setImageResource(R.drawable.jawab);
        btn_next.setImageResource(R.drawable.go);

        if(v==btn_jwb)
        {
            String jawab1=jawabannya.getText().toString();
            if(jawab1.equalsIgnoreCase(jawaban[index]))
            {
                salahbenar.setText("BENAR");benar++;
                btn_jwb.setImageResource(R.drawable.jawab);
                btn_next.setImageResource(R.drawable.go);
            }
            else
            {
                salahbenar.setText("SALAH");salah++;
                btn_jwb.setImageResource(R.drawable.jawab);
                btn_next.setImageResource(R.drawable.go);
            }
        }
        else if (v==btn_next)
        {
            if(index<pertanyaan.length-1)
            {
                index++;
                soal.setImageResource(pertanyaan[index]);
                btn_jwb.setImageResource(btn_jawab[index]);
                btn_next.setImageResource(btn_go[index]);

                jawabannya.setText("");
                salahbenar.setText("");
                btn_jwb.setImageDrawable(Drawable.createFromPath(""));
                btn_next.setImageDrawable(Drawable.createFromPath(""));
            }
            else{
                Intent i = new Intent(Kuis.this, Hasil.class);
                i.putExtra("BENAR", benar);
                i.putExtra("SALAH", salah);
                startActivity(i);
            }
        }
    }
}
