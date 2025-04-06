package com.duyer.BayrakUygulaması;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.duyer.QuizActivity;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    private Button buttonBasla;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        VeritabaniKopyala();

        buttonBasla = findViewById(R.id.buttonBasla);
        buttonBasla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, QuizActivity.class));

            }
        });
        }

        public void VeritabaniKopyala () {
        DatabaseCopyHelper helper = new DatabaseCopyHelper(this);
            try {
                helper.createDataBase();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            helper.openDataBase();
        }
    }
