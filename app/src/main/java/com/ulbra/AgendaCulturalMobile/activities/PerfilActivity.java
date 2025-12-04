package com.ulbra.AgendaCulturalMobile.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import com.ulbra.myapplication.R;

public class PerfilActivity extends AppCompatActivity {
    EditText edtxtNomePerfil, edtxtEmailPerfil;
    Button btnTelaCad;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        setContentView(R.layout.tela_perfil);
        edtxtNomePerfil = findViewById(R.id.edtxtNomePerfil);
        edtxtEmailPerfil = findViewById(R.id.edtxtEmailPerfil);
        btnTelaCad = findViewById(R.id.btnTelaPerfil);

        btnTelaCad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            editarUsuario();
            }

        });
    }

    String nome = "";
    String email = "";

    public void editarUsuario() {
        nome = edtxtNomePerfil.getText().toString();
        email = edtxtEmailPerfil.getText().toString();

        if(nome.isEmpty()){
            Toast.makeText(this, "Erro, preencha o campo do nome do usuario",Toast.LENGTH_SHORT).show();
            return;
        }

        if(email.isEmpty() || email.contains("@")){
            Toast.makeText(this,"Erro preencha o campo de email " +
                    "um endereço válido contem @", Toast.LENGTH_SHORT).show();
            return;
        } else {
            Toast.makeText(this, "Ok tudo ocorreu corretamente, seu nome de usuário agora é: " + nome
                    + " e o seu email agora é: " + email, Toast.LENGTH_SHORT).show();
        }

        finish();
    }

}
