package com.duyer;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.duyer.BayrakUygulaması.R;
import com.duyer.BayrakUygulaması.databinding.ActivityQuizBinding;

import java.util.ArrayList;
import java.util.HashSet;

public class QuizActivity extends AppCompatActivity {
    private ActivityQuizBinding tasarim;
    private ArrayList<Bayraklar> sorularListe;
    private ArrayList<Bayraklar> yanlisSeceneklerList;
    private Bayraklar dogruSoru;
    private Veritabani vt;
    private int soruSayac = 0;
    private int dogruSayac = 0;
    private int yanlisSayac = 0;
    private HashSet<Bayraklar> secenekleriKaristirmaListe = new HashSet<>();
    private ArrayList<Bayraklar> seceneklerListe = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        tasarim = ActivityQuizBinding.inflate(getLayoutInflater());
        setContentView(tasarim.getRoot());

        vt = new Veritabani(this);
        sorularListe = new Bayraklardao().rastgele5Getir(vt);
        soruYukle();



    }
    public void buttonA(View view) {
        dogruKontrol(tasarim.buttonA);
        sayacKontrol();

    }



    public void buttonB(View view) {
        dogruKontrol(tasarim.buttonB);
        sayacKontrol();


    }


    public void buttonC(View view) {
        dogruKontrol(tasarim.buttonC);
        sayacKontrol();


    }


    public void buttonD(View view) {
        dogruKontrol(tasarim.buttonD);
        sayacKontrol();


    }

    public void soruYukle() {
        tasarim.textViewSoruSayi.setText((soruSayac + 1)+".SORU");
        tasarim.textViewDogru.setText("DOĞRU: " + dogruSayac);
        tasarim.textViewYanlis.setText("YANLIŞ: " + yanlisSayac);

            dogruSoru = sorularListe.get(soruSayac);
            yanlisSeceneklerList = new Bayraklardao().rastgele3YanlisSecenekGetir(vt, dogruSoru.getBayrak_id());
            tasarim.imageViewBayrak.setImageResource(getResources().getIdentifier(dogruSoru.getBayrak_resim(), "drawable", getPackageName()));


            secenekleriKaristirmaListe.add(dogruSoru);
            secenekleriKaristirmaListe.add(yanlisSeceneklerList.get(0));
            secenekleriKaristirmaListe.add(yanlisSeceneklerList.get(1));
            secenekleriKaristirmaListe.add(yanlisSeceneklerList.get(2));
            seceneklerListe.clear();


            for (Bayraklar b :secenekleriKaristirmaListe) {
                seceneklerListe.add(b);
            }

            tasarim.buttonA.setText(seceneklerListe.get(0).getBayrak_ad());
            tasarim.buttonB.setText(seceneklerListe.get(1).getBayrak_ad());
            tasarim.buttonC.setText(seceneklerListe.get(2).getBayrak_ad());
            tasarim.buttonD.setText(seceneklerListe.get(3).getBayrak_ad());



        }


    public void dogruKontrol(Button button) {
        String buttonYazi = button.getText().toString();
        String dogruCevap = dogruSoru.getBayrak_ad();
        if (buttonYazi.equals(dogruCevap)) {
            dogruSayac++;
        } else {
            yanlisSayac++;
        }
    }

    public void sayacKontrol() {
        soruSayac++;
        if (soruSayac != 5) {
            soruYukle();
        } else {
            Intent intent = new Intent(QuizActivity.this, ResultActivity.class);
            intent.putExtra("dogruSayac", dogruSayac);
            startActivity(intent);
            finish();
        }
    }

        


    }
