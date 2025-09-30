package com.example.projetoquiz;

import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    TextView txvPergunta;

    RadioGroup rdg_principal;

    Button btn_responder;

    int pontuacao = 0;

    int indicePergunta = 0;

    String [] perguntas = {
           "Minha pergunta 1",
            "Minha pergunta 2",
            "Minha pergunta 3",
            "Minha pergunta 4",

    };

    int []respostasCorretas = {
       R.id.rb_a, 
            R.id.rb_b,
            R.id.rb_c,
            R.id.rb_d
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        
        txvPergunta = findViewById(R.id.txv_pergunta);
        rdg_principal = findViewById(R.id.rdg_principal);
        btn_responder = findViewById(R.id.btn_responder);
        
        carregarPerguntas();
        
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private void carregarPerguntas() {
        if(indicePergunta < perguntas.length){

            txvPergunta.setText(perguntas[indicePergunta]);

            rdg_principal.clearCheck();

            btn_responder.setEnabled(true);

        }else{

            txvPergunta.setText("Fim");

            btn_responder.setEnabled(false);
        }
    }
}