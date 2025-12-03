package com.ulbra.AgendaCulturalMobile.activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import com.ulbra.myapplication.R;

public class EventoActivity extends AppCompatActivity {

    private TextView txtTitulo, txtDataPostagem, txtDataEvento, txtLocal, txtCorpo, txtResponsavel;
    private ImageView imgBanner;
    private ImageButton btnFavoritar;
    private Button btnVoltar;

    private boolean favoritado = false; // estado local

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_evento);

        // Referências
        imgBanner = findViewById(R.id.imgBanner);
        txtTitulo = findViewById(R.id.txtTitulo);
        txtDataPostagem = findViewById(R.id.txtDataPostagem);
        txtDataEvento = findViewById(R.id.txtDataEvento);
        txtLocal = findViewById(R.id.txtLocal);
        txtCorpo = findViewById(R.id.txtCorpo);
        txtResponsavel = findViewById(R.id.txtResponsavel);
        btnFavoritar = findViewById(R.id.btnFavoritar);
        btnVoltar = findViewById(R.id.btnVoltar);

        // 🔹 Recebe dados via Intent
        Intent intent = getIntent();
        String titulo = intent.getStringExtra("titulo");
        String descricao = intent.getStringExtra("descricao");
        String dataPostagem = intent.getStringExtra("dataPostagem");
        String dataEvento = intent.getStringExtra("dataEvento");
        String local = intent.getStringExtra("local");
        String responsavel = intent.getStringExtra("responsavel");

        // 🔹 Preenche os campos
        txtTitulo.setText(titulo != null ? titulo : "Título do evento");
        txtCorpo.setText(descricao != null ? descricao : "Descrição do evento...");
        txtDataPostagem.setText("Postado em: " + (dataPostagem != null ? dataPostagem : "-"));
        txtDataEvento.setText("Data do evento: " + (dataEvento != null ? dataEvento : "-"));
        txtLocal.setText("Local: " + (local != null ? local : "-"));
        txtResponsavel.setText("Responsável: " + (responsavel != null ? responsavel : "-"));

        imgBanner.setImageResource(R.drawable.icone_banner);

        // 🔹 Botão Favoritar com animação
        btnFavoritar.setOnClickListener(v -> {
            favoritado = !favoritado;
            btnFavoritar.setImageResource(
                    favoritado ? R.drawable.ic_star_filled : R.drawable.ic_star_border
            );

            // Animação "pop"
            btnFavoritar.animate()
                    .scaleX(1.2f)
                    .scaleY(1.2f)
                    .setDuration(150)
                    .withEndAction(() -> {
                        btnFavoritar.animate().scaleX(1f).scaleY(1f).setDuration(150);
                    });
        });

        // 🔹 Botão Voltar
        btnVoltar.setOnClickListener(v -> finish());
         btnVoltar.setOnClickListener(v -> {
             startActivity(new Intent(this, MenuActivity.class));
             finish();
        });
    }
}
