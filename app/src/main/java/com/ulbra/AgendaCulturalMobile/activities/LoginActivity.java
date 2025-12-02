package com.ulbra.AgendaCulturalMobile.activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import com.ulbra.myapplication.R;

public class LoginActivity extends AppCompatActivity {

    private EditText edtEmail, edtSenha;
    private Button btnLogar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_login);

        edtEmail = findViewById(R.id.edtEmail);
        edtSenha = findViewById(R.id.edtSenha);
        btnLogar = findViewById(R.id.btnLogar);

        btnLogar.setOnClickListener(v -> {
            String email = edtEmail.getText().toString().trim();
            String senha = edtSenha.getText().toString().trim();

            // ⚠️ LOGIN TEMPORÁRIO - REMOVER POSTERIORMENTE
            // Apenas para testes iniciais, sem banco de dados
            if (email.equals("admin") && senha.equals("admin")) {
                // Se credenciais corretas, vai para o MenuActivity
                Intent intent = new Intent(LoginActivity.this, MenuActivity.class);
                startActivity(intent);
                finish(); // fecha a tela de login
            } else {
                // Caso contrário, mostra mensagem de erro
                Toast.makeText(LoginActivity.this,
                        "Email ou senha inválidos (login temporário)",
                        Toast.LENGTH_SHORT).show();
            }
        });
    }
}
