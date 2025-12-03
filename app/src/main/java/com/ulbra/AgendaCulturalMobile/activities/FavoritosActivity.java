package com.ulbra.AgendaCulturalMobile.activities;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.ulbra.AgendaCulturalMobile.adapter.EventoAdapter;
import com.ulbra.AgendaCulturalMobile.models.Evento;
import com.ulbra.myapplication.R;
import java.util.ArrayList;
import java.util.List;

public class FavoritosActivity extends AppCompatActivity {

    private RecyclerView recyclerFavoritos;
    private EventoAdapter adapter;
    private List<Evento> listaFavoritos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_favoritos);

        recyclerFavoritos = findViewById(R.id.recyclerFavoritos);
        recyclerFavoritos.setLayoutManager(new LinearLayoutManager(this));

        // 🔹 Por enquanto, simulação: filtra apenas os eventos favoritados
        listaFavoritos = new ArrayList<>();
        for (Evento e : getEventosMock()) {
            if (e.isFavoritado()) {
                listaFavoritos.add(e);
            }
        }

        adapter = new EventoAdapter(listaFavoritos);
        recyclerFavoritos.setAdapter(adapter);
    }

    // 🔹 Mock de eventos (até termos banco de dados)
    private List<Evento> getEventosMock() {
        List<Evento> eventos = new ArrayList<>();
        eventos.add(new Evento("Feira Cultural", "Apresentações artísticas", "01/12/2025", "05/12/2025", "Auditório", "Prof. João"));
        eventos.add(new Evento("Semana da Ciência", "Exposição de projetos", "02/12/2025", "10/12/2025", "Laboratório", "Prof. Maria"));
        eventos.get(0).setFavoritado(true); // só o primeiro favoritado
        return eventos;
    }
}
