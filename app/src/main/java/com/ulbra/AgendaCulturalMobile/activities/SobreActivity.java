package com.ulbra.AgendaCulturalMobile.activities;

import android.os.Bundle;
import android.widget.TextView;
import com.ulbra.myapplication.R;
import androidx.appcompat.app.AppCompatActivity;

public class SobreActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_sobre);

        TextView txtVersao = findViewById(R.id.txtVersao);
        TextView txtWhats = findViewById(R.id.txtWhats);
        TextView txtContato = findViewById(R.id.txtContato);
        TextView txtDescricao = findViewById(R.id.txtDescricao);

        // 🔹 Exemplo de preenchimento dinâmico
        String versaoApp = "1.0.0"; // você pode puxar do BuildConfig.VERSION_NAME
        txtVersao.setText("Versão: " + versaoApp);

        txtWhats.setText("Whats: (51)3451-7557");
        txtContato.setText("Contato: ulbrasaolucas@ulbra.br");
        txtDescricao.setText("Agenda Cultural – Ulbra São Lucas é um aplicativo criado para aproximar alunos, professores e comunidade das principais atividades culturais promovidas pela escola. Com uma interface simples e prática, o app reúne eventos, notícias e atividades culturais realizadas na Ulbra São Lucas, permitindo que todos acompanhem a programação e participem ativamente da vida escolar.");
    }
}