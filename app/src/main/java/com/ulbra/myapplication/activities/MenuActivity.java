package com.ulbra.myapplication.activities;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ulbra.myapplication.NoticiaAdapter;
import com.ulbra.myapplication.R;
import com.ulbra.myapplication.models.Noticia;

import java.util.ArrayList;
import java.util.List;

public class MenuActivity extends AppCompatActivity {

    private RecyclerView recyclerNoticias;
    private NoticiaAdapter noticiaAdapter;
    private List<Noticia> listaNoticias;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_menu);

        recyclerNoticias = findViewById(R.id.recyclerNoticias);
        recyclerNoticias.setLayoutManager(new LinearLayoutManager(this));

        listaNoticias = new ArrayList<>();
        // Exemplo de dados
        listaNoticias.add(new Noticia("Título 1", "Corpo da notícia 1", "01/12/2025", "05/12/2025", "Auditório"));
        listaNoticias.add(new Noticia("Título 2", "Corpo da notícia 2", "30/11/2025", null, null));

        noticiaAdapter = new NoticiaAdapter(listaNoticias);
        recyclerNoticias.setAdapter(noticiaAdapter);
    }
}
