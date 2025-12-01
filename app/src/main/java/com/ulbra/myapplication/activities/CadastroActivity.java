package com.ulbra.myapplication.activities;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

import com.ulbra.myapplication.R;
import com.ulbra.myapplication.models.Usuario;

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
            Usuario usuario = new Usuario(
                    edtNome.getText().toString(),
                    edtEmail.getText().toString(),
                    edtSenha.getText().toString()
            );
            // Aqui salvaria no banco ou API
        });
    }
}
