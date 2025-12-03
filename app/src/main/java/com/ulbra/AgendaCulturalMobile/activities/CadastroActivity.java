package com.ulbra.AgendaCulturalMobile.activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import com.ulbra.myapplication.R;
import com.ulbra.AgendaCulturalMobile.models.Usuario;

public class CadastroActivity extends AppCompatActivity {

    private EditText edtNome, edtEmail, edtSenha;
    private Button btnCadastrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_cadastro);

        edtNome = findViewById(R.id.edtNome);
        edtEmail = findViewById(R.id.edtEmail);
        edtSenha = findViewById(R.id.edtSenha);
        btnCadastrar = findViewById(R.id.btnCadastrar);

        btnCadastrar.setOnClickListener(v -> {
            try {
                // Simulação de cadastro
                Usuario usuario = new Usuario(
                        edtNome.getText().toString().trim(),
                        edtEmail.getText().toString().trim(),
                        edtSenha.getText().toString().trim()
                );

                // Aqui futuramente salvaria no banco ou API
                // Por enquanto, apenas simulação de sucesso
                Toast.makeText(CadastroActivity.this,
                        "Cadastro realizado com sucesso!",
                        Toast.LENGTH_SHORT).show();

                // Vai para tela de Login
                Intent intent = new Intent(CadastroActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();

            } catch (Exception e) {
                // Caso ocorra algum erro inesperado
                Toast.makeText(CadastroActivity.this,
                        "Erro ao cadastrar: " + e.getMessage(),
                        Toast.LENGTH_LONG).show();
            }
        });
    }
}
