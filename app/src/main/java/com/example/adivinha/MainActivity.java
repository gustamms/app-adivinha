package com.example.adivinha;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Button botaoJogar;
    private TextView textoResultado;
    private EditText aposta1;
    private EditText aposta2;
    private TextView resultadoAposta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        botaoJogar = (Button) findViewById(R.id.botaoJogarId);
        textoResultado = (TextView) findViewById(R.id.texto);
        aposta1 = (EditText) findViewById(R.id.inputAposta1);
        aposta2 = (EditText) findViewById(R.id.inputAposta2);
        resultadoAposta = (TextView) findViewById(R.id.resultadoAposta);

        botaoJogar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Random randomico = new Random();
                int numeroAleatorio = randomico.nextInt(10);
                if(!aposta1.getText().toString().isEmpty() && !aposta2.getText().toString().isEmpty()){
                    textoResultado.setText("Número = " + (numeroAleatorio+1));
                    int resultAposta1 = Integer.parseInt(aposta1.getText().toString());
                    int resultAposta2 = Integer.parseInt(aposta2.getText().toString());

                    int resultadoAposta1 = (numeroAleatorio+1) - resultAposta1;
                    int resultadoAposta2 = (numeroAleatorio+1) - resultAposta2;
                    if(resultadoAposta1 < resultadoAposta2){
                        resultadoAposta.setText("Jogador 1 ganhou");
                    }else if(resultadoAposta1 > resultadoAposta2){
                        resultadoAposta.setText("Jogador 2 ganhou");
                    }else{
                        resultadoAposta.setText("Ambos ganharam");
                    }
                }else{
                    textoResultado.setText("Número = " + (numeroAleatorio+1));
                }
            }
        });
    }
}
