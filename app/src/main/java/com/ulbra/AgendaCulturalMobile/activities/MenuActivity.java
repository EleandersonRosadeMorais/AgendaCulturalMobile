package com.ulbra.AgendaCulturalMobile.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.navigation.NavigationView;
import com.ulbra.AgendaCulturalMobile.adapter.EventoAdapter;
import com.ulbra.myapplication.R;
import com.ulbra.AgendaCulturalMobile.models.Evento;

import java.util.ArrayList;
import java.util.List;

public class MenuActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private RecyclerView recyclerEvento;
    private EventoAdapter eventoAdapter;
    private List<Evento> listaEventos;
    private ImageView btnMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_menu);

        // Inicializa DrawerLayout, NavigationView e botão de menu
        drawerLayout = findViewById(R.id.drawerLayout);
        navigationView = findViewById(R.id.navigationView);
        btnMenu = findViewById(R.id.btnMenu);

        // Clique no botão hambúrguer abre o menu lateral
        btnMenu.setOnClickListener(v -> drawerLayout.openDrawer(GravityCompat.END));

        // Trata cliques no menu lateral
        navigationView.setNavigationItemSelectedListener(this::onNavigationItemSelected);

        // Configura o RecyclerView
        recyclerEvento = findViewById(R.id.recyclerEventos);
        recyclerEvento.setLayoutManager(new LinearLayoutManager(this));

        listaEventos = new ArrayList<>();
        eventoAdapter = new EventoAdapter(listaEventos);
        recyclerEvento.setAdapter(eventoAdapter);

        // 🔹 Carregar eventos da API
        carregarEventos();
    }

    // 🔹 Método para consumir JSON da API
    private void carregarEventos() {
        RequestQueue queue = Volley.newRequestQueue(this);
        listaEventos.clear();

        // 🔹 Loop de 1 até 20
        for (int i = 1; i <= 20; i++) {
            final int id = i; // variável final para usar dentro da lambda
            String url = "https://ac.infinitydev.com.br/api/APPfeedPríncipal.php?id=" + id;

            JsonObjectRequest request = new JsonObjectRequest(
                    Request.Method.GET,
                    url,
                    null,
                    response -> {
                        try {
                            // 🔹 Verifica se o JSON tem conteúdo válido
                            String titulo = response.optString("titulo", "");
                            String descricao = response.optString("descricao", "");
                            String data = response.optString("data", "");
                            String local = response.optString("local", "");
                            String responsavel = response.optString("responsavel", "");

                            // 🔹 Só adiciona se tiver título (ou outro campo essencial)
                            if (!titulo.isEmpty()) {
                                Evento evento = new Evento(
                                        titulo,
                                        descricao,
                                        data,   // dataPostagem
                                        data,   // dataEvento
                                        local,
                                        responsavel
                                );

                                listaEventos.add(evento);
                                eventoAdapter.notifyDataSetChanged();
                            }
                            // Se estiver vazio, simplesmente ignora (não adiciona, não mostra toast)
                        } catch (Exception e) {
                            e.printStackTrace(); // apenas loga
                        }
                    },
                    error -> {
                        error.printStackTrace(); // apenas loga
                    }
            );

            queue.add(request);
        }
    }

    // Trata seleção de itens do Drawer
    private boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.nav_favoritos) {
            startActivity(new Intent(this, FavoritosActivity.class));
        } else if (id == R.id.nav_perfil) {
            startActivity(new Intent(this, PerfilActivity.class));
        } else if (id == R.id.nav_sobre) {
            startActivity(new Intent(MenuActivity.this, SobreActivity.class));
        } else if (id == R.id.nav_desconectar) {
            Intent intent = new Intent(this, LoginActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
            finish();
        }

        drawerLayout.closeDrawers();
        return true;
    }
}
