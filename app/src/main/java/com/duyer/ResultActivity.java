package com.duyer;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.duyer.BayrakUygulaması.R;
import com.duyer.BayrakUygulaması.databinding.ActivityResultBinding;

public class ResultActivity extends AppCompatActivity {
    private ActivityResultBinding tasarim;
    private int dogruSayac;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        tasarim = ActivityResultBinding.inflate(getLayoutInflater());
        setContentView(tasarim.getRoot());


        dogruSayac = getIntent().getIntExtra("dogruSayac", 0);
        tasarim.textViewSonuc.setText(dogruSayac + "/5 Doğru");
        tasarim.textViewYuzdeSonuc.setText(((dogruSayac * 100) / 5) + "% Doğru");


        }
    public void buttonTekrar(View view) {
        startActivity(new Intent(ResultActivity.this, QuizActivity.class));
        finish();
    }
    }
