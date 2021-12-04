package com.example.caracoroaatv;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void botaoJogarClick(View view) {
        Intent intent = new Intent(this, CaraCoroaActivity.class);

        Random r = new Random();
        int caraCoroa = r.nextInt() % 2;

        intent.putExtra("caraCoroa", caraCoroa);
        startActivity(intent);
    }
}