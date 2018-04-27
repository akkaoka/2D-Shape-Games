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

public class PerpanjangActivity extends AppCompatActivity {
    /** Inisialisasi */
    EditText p;
    EditText l;
    ImageButton hitung;
    TextView hasil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.perpanjang);
        final Animation scale = AnimationUtils.loadAnimation(this, R.anim.scale);

        p=(EditText)findViewById(R.id.editText);
        l=(EditText)findViewById(R.id.editText2);
        hasil=(TextView)findViewById(R.id.textView);
        hitung =(ImageButton) findViewById(R.id.imageButton14);

        hitung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(scale);
                //notifikasi jika tidak diisi
                if (p.length()==0){
                    Toast.makeText(getApplication(),"Panjang belum dimasukkan",Toast.LENGTH_LONG).show();
                }
                else if (l.length()==0){
                    Toast.makeText(getApplication(),"Lebar belum dimasukkan",Toast.LENGTH_LONG).show();
                }
                else {
                    String isipanjang=p.getText().toString();
                    double p=Double.parseDouble(isipanjang);
                    String isilebar=l.getText().toString();
                    double l=Double.parseDouble(isilebar);
                    double hs=LuasPerpanjang(p,l);
                    String output=String.valueOf(hs);
                    hasil.setText(output.toString());
                }
            }
        });
    }
    public double LuasPerpanjang(double p, double l){
        return p*l;
    }
}
