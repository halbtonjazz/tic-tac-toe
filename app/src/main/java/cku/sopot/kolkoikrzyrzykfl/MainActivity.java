package cku.sopot.kolkoikrzyrzykfl;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button p11, p12, p13,
            p21, p22, p23,
            p31, p32, p33,
            nowa;
    TextView komunikat;
    String znak = "O";
    int licznik = 0;
    boolean jestWygrana = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        p11 = findViewById(R.id.p11);
        p12 = findViewById(R.id.p12);
        p13 = findViewById(R.id.p13);

        p21 = findViewById(R.id.p21);
        p22 = findViewById(R.id.p22);
        p23 = findViewById(R.id.p23);

        p31 = findViewById(R.id.p31);
        p32 = findViewById(R.id.p32);
        p33 = findViewById(R.id.p33);

        nowa = findViewById(R.id.nowa);
        komunikat = findViewById(R.id.komunikat);

        View.OnClickListener sluchacz = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Button wcisniety = (Button) view;
                wcisniety.setText(znak);
                wcisniety.setEnabled(false);
                licznik ++;
                if (sprawdzWygrana()){
                    komunikat.setText("Wygrywa " + znak);
                    p11.setEnabled(false); p12.setEnabled(false); p13.setEnabled(false);
                    p21.setEnabled(false); p22.setEnabled(false); p23.setEnabled(false);
                    p31.setEnabled(false); p32.setEnabled(false); p33.setEnabled(false);
                } else if (licznik == 9){
                    komunikat.setText("Remis");
                    p11.setEnabled(false); p12.setEnabled(false); p13.setEnabled(false);
                    p21.setEnabled(false); p22.setEnabled(false); p23.setEnabled(false);
                    p31.setEnabled(false); p32.setEnabled(false); p33.setEnabled(false);
                } else {
                    if (znak.equals("O")) znak = "X";
                    else znak = "O";
                    komunikat.setText("Teraz gra " + znak);
                }
            }
        };

        p11.setOnClickListener(sluchacz);
        p12.setOnClickListener(sluchacz);
        p13.setOnClickListener(sluchacz);

        p21.setOnClickListener(sluchacz);
        p22.setOnClickListener(sluchacz);
        p23.setOnClickListener(sluchacz);

        p31.setOnClickListener(sluchacz);
        p32.setOnClickListener(sluchacz);
        p33.setOnClickListener(sluchacz);

        nowa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                p11.setText(""); p11.setEnabled(true);
                p12.setText(""); p12.setEnabled(true);
                p13.setText(""); p13.setEnabled(true);

                p21.setText(""); p21.setEnabled(true);
                p22.setText(""); p22.setEnabled(true);
                p23.setText(""); p23.setEnabled(true);

                p31.setText(""); p31.setEnabled(true);
                p32.setText(""); p32.setEnabled(true);
                p33.setText(""); p33.setEnabled(true);

                licznik = 0;

                komunikat.setText("Teraz gra " + znak);
            }
        });
    }
    boolean sprawdzWygrana(){
        String p11s = p11.getText().toString();
        String p12s = p12.getText().toString();
        String p13s = p13.getText().toString();

        String p21s = p21.getText().toString();
        String p22s = p22.getText().toString();
        String p23s = p23.getText().toString();

        String p31s = p31.getText().toString();
        String p32s = p32.getText().toString();
        String p33s = p33.getText().toString();

        boolean wiersz1 = p11s.equals(p12s) && p11s.equals(p13s) && p11s.length()>0;
        boolean wiersz2 = p21s.equals(p22s) && p21s.equals(p23s) && p21s.length()>0;
        boolean wiersz3 = p31s.equals(p32s) && p31s.equals(p33s) && p31s.length()>0;

        boolean kolumna1 = p11s.equals(p21s) && p11s.equals(p31s) && p11s.length()>0;
        boolean kolumna2 = p12s.equals(p22s) && p12s.equals(p32s) && p12s.length()>0;
        boolean kolumna3 = p13s.equals(p23s) && p13s.equals(p33s) && p13s.length()>0;

        boolean przekatna1 = p11s.equals(p22s) && p11s.equals(p33s) && p11s.length()>0;
        boolean przekatna2 = p13s.equals(p22s) && p13s.equals(p31s) && p31s.length()>0;

        return wiersz1 || wiersz2 || wiersz3 || kolumna1 || kolumna2 || kolumna3 || przekatna1 || przekatna2;
    }
}