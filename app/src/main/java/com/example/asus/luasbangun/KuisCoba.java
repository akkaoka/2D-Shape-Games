package com.example.asus.luasbangun;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class KuisCoba extends Activity implements OnClickListener {
    MediaPlayer soundbackground;

    ImageButton btn_jwb, btn_next;
    EditText jawabannya;
    TextView salahbenar;
    ImageView soal;
    int benar = 0, salah = 0, index = 0;
    int[] pertanyaan = {R.drawable.soal1,
            R.drawable.soal2,
            R.drawable.soal3,
            R.drawable.soalke4,
            R.drawable.soal5,
            R.drawable.soal6,
            R.drawable.soal10,
            R.drawable.soal8,
            R.drawable.soal9,
            R.drawable.soal7};

    String[] jawaban = {"64", "314", "50", "200", "60", "180", "314", "56", "50,24", "16"};

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kuis_coba);

        btn_jwb = (ImageButton) findViewById(R.id.jawab);
        btn_jwb.setOnClickListener(this);

        btn_next = (ImageButton) findViewById(R.id.next);
        btn_next.setOnClickListener(this);

        salahbenar = (TextView) findViewById(R.id.salahbenar);
        salahbenar.setText("");

        soal = (ImageView) findViewById(R.id.GambarSoal);
        soal.setImageResource(pertanyaan[0]);

    }

    @Override
    public void onClick(View v) {
        // TODO Auto-generated method stub
        salahbenar = (TextView) findViewById(R.id.salahbenar);
        jawabannya = (EditText) findViewById(R.id.jawabannya);
        btn_jwb.setEnabled(false);
        jawabannya.setEnabled(false);
        if (v == btn_jwb) {
            String jawab1 = jawabannya.getText().toString();
            if (jawab1.equalsIgnoreCase(jawaban[index])) {
                salahbenar.setText("BENAR!");
                benar++;
                btn_next.setImageResource(R.drawable.go);
                soundbackground = MediaPlayer.create(KuisCoba.this, R.raw.benar);
                soundbackground.setLooping(false);
                soundbackground.setVolume(1, 1);
                soundbackground.start();
            } else {
                salahbenar.setText("SALAH!");
                salah++;
                btn_next.setImageResource(R.drawable.go);
                soundbackground = MediaPlayer.create(KuisCoba.this, R.raw.wrong);
                soundbackground.setLooping(false);
                soundbackground.setVolume(1, 1);
                soundbackground.start();
            }
        } else if (v == btn_next) {
            if (index < pertanyaan.length - 1) {
                index++;
                soal.setImageResource(pertanyaan[index]);
                btn_jwb.setEnabled(true);
                jawabannya.setEnabled(true);
                btn_next.setVisibility(View.VISIBLE);
                jawabannya.setText("");
                salahbenar.setText("");
            } else {
                Intent i = new Intent(KuisCoba.this, Hasil.class);
                i.putExtra("BENAR", benar);
                i.putExtra("SALAH", salah);
                startActivity(i);
            }
        }
    }

    @Override
    public void onBackPressed() {
        Intent i = new Intent(KuisCoba.this, DashboardActivitythird.class);
        startActivity(i);
        finish();
    }
}