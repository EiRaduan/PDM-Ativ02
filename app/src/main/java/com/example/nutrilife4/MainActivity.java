package com.example.nutrilife4;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private RadioGroup rd_grupo;
    private EditText edt_nome;
    private EditText edt_peso;
    private EditText edt_altura;
    private Button btn_calcular;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edt_nome = findViewById(R.id.edt_nome);
        edt_peso = findViewById(R.id.edt_peso);
        edt_altura = findViewById(R.id.edt_altura);
        rd_grupo = findViewById(R.id.rdn_grupo);
        btn_calcular = findViewById(R.id.btn_calcular);

        btn_calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (edt_altura.getText().toString().isEmpty() || edt_peso.getText().toString().isEmpty() || edt_nome.getText().toString().isEmpty()) {
                    AlertDialog.Builder janela = new AlertDialog.Builder(MainActivity.this);
                    janela.setTitle(R.string.app_name);
                    janela.setMessage("Todos os campos devem ser preenchidos!!!");
                    janela.setPositiveButton("OK", null);
                    janela.show();

                } else {
                    AlertDialog.Builder janela = new AlertDialog.Builder(MainActivity.this);
                    janela.setTitle(R.string.app_name);
                    janela.setMessage("Todos os dados estão corretos?");
                    janela.setPositiveButton("sim", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            abrirAtividade();
                        }
                    });

                    janela.setNegativeButton("não", null);
                    janela.show();
                }
            }


        });
    }
        public void abrirAtividade () {
            String nome = edt_nome.getText().toString();
            double altura = 0;
            double peso = 0;
            int id_sexo = rd_grupo.getCheckedRadioButtonId();
            RadioButton rb_sexo = findViewById(id_sexo);
            String sexo = rb_sexo.getText().toString();


            if (!edt_altura.getText().toString().isEmpty()) {
                altura = Double.parseDouble(edt_altura.getText().toString());
            }
            if (!edt_peso.getText().toString().isEmpty()) {
                peso = Double.parseDouble(edt_peso.getText().toString());
            }

            Intent intent = new Intent(MainActivity.this, ResultadoActivity2.class);
            intent.putExtra("nome", nome);
            intent.putExtra("altura", altura);
            intent.putExtra("peso", peso);
            intent.putExtra("sexo", sexo);
            startActivity(intent);
        }
    }
