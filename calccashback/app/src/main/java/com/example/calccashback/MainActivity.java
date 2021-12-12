package com.example.calccashback;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SeekBar cashbackPorcentagem = findViewById(R.id.cashbackPorcentagem);

        TextView cashbackText = findViewById(R.id.cashbackText);

        EditText valorProduto = findViewById(R.id.valorProduto);
        TextView cashbackTotal = findViewById(R.id.cashbackTotal);
        TextView totalValue = findViewById(R.id.totalValue);
        Switch descontoSwitch = findViewById(R.id.descontoSwitch);
        EditText descontoValue = findViewById(R.id.descontoValue);

        cashbackPorcentagem.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                cashbackText.setText(String.valueOf(progress)+"%");


                float valorTotal = Float.parseFloat(valorProduto.getText().toString());
                if(descontoValue.isEnabled()){
                    valorTotal = Float.parseFloat(descontoValue.getText().toString()) - valorTotal;
                }
                float valorCashback = valorTotal * ((float)progress/100);

                cashbackTotal.setText("R$ " + String.valueOf(valorCashback));
                totalValue.setText("R$ " + String.valueOf(valorTotal-valorCashback));
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });



        descontoSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    descontoValue.setEnabled(true);
                } else{
                    descontoValue.setEnabled(false);
                }
            }
        });

    }
}