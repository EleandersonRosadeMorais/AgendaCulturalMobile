package com.ulbra.AgendaCulturalMobile.activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import com.ulbra.AgendaCulturalMobile.api.ApiClient;
import com.ulbra.AgendaCulturalMobile.api.ApiService;
import com.ulbra.AgendaCulturalMobile.models.LoginResponse;
import com.ulbra.AgendaCulturalMobile.models.Usuario;
import com.ulbra.myapplication.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    private EditText edtEmail, edtSenha;
    private Button btnLogar, btnCadastrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_login);

        edtEmail = findViewById(R.id.edtEmail);
        edtSenha = findViewById(R.id.edtSenha);
        btnLogar = findViewById(R.id.btnLogar);
        btnCadastrar = findViewById(R.id.btnCadastrar);

        btnLogar.setOnClickListener(v -> {
            String email = edtEmail.getText().toString().trim();
            String senha = edtSenha.getText().toString().trim();

            if (email.isEmpty() || senha.isEmpty()) {
                Toast.makeText(LoginActivity.this,
                        "Preencha todos os campos",
                        Toast.LENGTH_SHORT).show();
                return;
            }

            // 🔹 Chamada à API de login
            ApiService apiService = ApiClient.getClient().create(ApiService.class);
            apiService.login(email, senha).enqueue(new Callback<LoginResponse>() {
                @Override
                public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                    if (response.isSuccessful() && response.body() != null) {
                        LoginResponse loginResponse = response.body();

                        if (loginResponse.isSucesso()) {
                            Usuario usuario = loginResponse.getUsuario();
                            Toast.makeText(LoginActivity.this,
                                    "Bem-vindo, " + usuario.getNome(),
                                    Toast.LENGTH_SHORT).show();

                            // Vai para MenuActivity e passa o ID do usuário
                            Intent intent = new Intent(LoginActivity.this, MenuActivity.class);
                            intent.putExtra("usuarioId", usuario.getId_pk());
                            startActivity(intent);
                            finish();
                        } else {
                            Toast.makeText(LoginActivity.this,
                                    loginResponse.getMsg(),
                                    Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(LoginActivity.this,
                                "Erro na resposta da API (código: " + response.code() + ")",
                                Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<LoginResponse> call, Throwable t) {
                    Toast.makeText(LoginActivity.this,
                            "Erro de conexão: " + t.getMessage(),
                            Toast.LENGTH_LONG).show();
                }
            });
        });

        btnCadastrar.setOnClickListener(v -> {
            Intent intent = new Intent(LoginActivity.this, CadastroActivity.class);
            startActivity(intent);
        });
    }
}
