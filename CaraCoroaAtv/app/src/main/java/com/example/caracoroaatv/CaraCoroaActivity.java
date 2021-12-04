package com.example.caracoroaatv;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.util.Random;

public class CaraCoroaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cara_coroa);

        Random r = new Random();
        int valor = r.nextInt() % 2;
        ImageView caraCoroaImagem = findViewById(R.id.caraCoroaImg);

        if (valor == 0){
            caraCoroaImagem.setBackgroundResource(R.drawable.moeda_cara);
        } else{
            caraCoroaImagem.setBackgroundResource(R.drawable.moeda_coroa);
        }
    }

    public void botaoVoltarClick(View view){
        startActivity(new Intent(this,MainActivity.class));
    }
}