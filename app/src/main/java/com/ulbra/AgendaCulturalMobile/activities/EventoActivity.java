package com.ulbra.AgendaCulturalMobile.activities;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import com.ulbra.myapplication.R;

public class EventoActivity extends AppCompatActivity {

    private TextView txtTitulo, txtDataPostagem, txtDataEvento, txtLocal, txtCorpo, txtResponsavel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_evento);

        txtTitulo = findViewById(R.id.txtTitulo);
        txtDataPostagem = findViewById(R.id.txtDataPostagem);
        txtDataEvento = findViewById(R.id.txtDataEvento);
        txtLocal = findViewById(R.id.txtLocal);
        txtCorpo = findViewById(R.id.txtCorpo);
        txtResponsavel = findViewById(R.id.txtResponsavel);


        // Exemplo de preenchimento
        txtTitulo.setText("Título da notícia");
        txtDataPostagem.setText("Postado em: 30/11/2025");
        txtDataEvento.setText("Data do evento: 05/12/2025");
        txtLocal.setText("Local: Auditório");
        txtResponsavel.setText("Responsável: ");
        txtCorpo.setText("Aqui vai o corpo da notícia...");
    }
}
