package com.example.nutrilife4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResultadoActivity2 extends AppCompatActivity {
    private TextView txt_imc;
    private TextView txt_risco;
    private Button btn_voltar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado2);

        txt_imc = findViewById(R.id.txt_imc);
        btn_voltar = findViewById(R.id.btn_voltar);

        Intent intent = getIntent();
        String nome = intent.getStringExtra("nome");
        Double altura_imc = intent.getDoubleExtra("altura", 0);
        Double peso_imc = intent.getDoubleExtra("peso", 0);

        double imc = 0;
        double calculo_imc =  peso_imc/(altura_imc*altura_imc);
        String classificacao = "";
        String risco = "";

        String sexo = intent.getStringExtra("sexo");

        //////////////////RISCO

            if (calculo_imc >= 16 && calculo_imc < 16.9) {
                risco = "Queda de cabelo, infertilidade, ausẽncia mestrual";
            }
            if (calculo_imc >= 17 && calculo_imc <= 18.4) {
                risco = "Fadiaga, stress, ansiedade";
            }
            if (calculo_imc >= 18.5 && calculo_imc <= 24.9) {
                risco = "Menor risco de doenças cardiacas e vasculares";
            }
            if (calculo_imc >= 25 && calculo_imc <= 29.9) {
                risco = "Fadiga, má circulação, varizes";
            }
            if (calculo_imc >= 30 && calculo_imc <= 34.9) {
                risco = "Diabetes, angina, infarto, ateroscierose";
            }
            if (calculo_imc >= 35 && calculo_imc <= 40) {
                risco = "Apneia do sono, falta de ar";
            }
            if (calculo_imc >= 40) {
                risco = "Refluxo, dificuldade para se mover, escaras, diabetes, infarto, AVC";
            }



        //////////////////////////////////////CLASSIFICAÇÂO
        if(sexo.equals("Masculino")) {
            if (calculo_imc < 20) {
                classificacao = "Abaixo do normal";
            }
            if (calculo_imc >= 20 && calculo_imc <= 24.9) {
                classificacao = "Normal";
            }
            if (calculo_imc >= 25 && calculo_imc <= 29.9) {
                classificacao = "Obesidade Leve";
            }
            if (calculo_imc >= 30 && calculo_imc <= 39.9) {
                classificacao = "Obesidade Moderada";
            }
            if (calculo_imc >= 43) {
                classificacao = "Obesidade Mórbida";
            }
        }

        if(sexo.equals("Feminino")) {
            if (calculo_imc < 19) {
                classificacao = "Abaixo do normal";
            }
            if (calculo_imc >= 19 && calculo_imc <= 23.9) {
                classificacao = "Normal";
            }
            if (calculo_imc >= 24 && calculo_imc <= 28.9) {
                classificacao = "Obesidade Leve";
            }
            if (calculo_imc >= 29 && calculo_imc <= 38.9) {
                classificacao = "Obesidade Moderada";
            }
            if (calculo_imc >= 39) {
                classificacao = "Obesidade Mórbida";
            }
        }

        StringBuilder resultado = new StringBuilder();
        resultado.append("Ola, ").append(nome).append("\n");
        resultado.append("Seu IMC é: ").append(String.format("%.2f\n",calculo_imc));
        resultado.append("Classificação: ").append(classificacao).append("\n\n\n\n\n");
        resultado.append("Abaixo estão os riscos associados ao seu resultado:\n");
        resultado.append(risco).append("\n");
        txt_imc.setText(resultado);

        btn_voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

    }
}