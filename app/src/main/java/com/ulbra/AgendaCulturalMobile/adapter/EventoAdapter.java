package com.ulbra.AgendaCulturalMobile.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Button;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.ulbra.myapplication.R;
import com.ulbra.AgendaCulturalMobile.activities.EventoActivity;
import com.ulbra.AgendaCulturalMobile.models.Evento;
import java.util.List;

public class EventoAdapter extends RecyclerView.Adapter<EventoAdapter.EventoViewHolder> {

    private List<Evento> listaEventos;

    public EventoAdapter(List<Evento> listaEventos) {
        this.listaEventos = listaEventos;
    }

    @NonNull
    @Override
    public EventoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_evento, parent, false);
        return new EventoViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull EventoViewHolder holder, int position) {
        Evento evento = listaEventos.get(position);

        // Preenche os textos
        holder.txtTituloItem.setText(evento.getTitulo());
        holder.txtDescricaoItem.setText(evento.getDescricao());
        holder.txtDataEventoItem.setText("Evento: " + (evento.getData() != null ? evento.getData() : "-"));
        holder.txtDataPostagemItem.setText("Postado em: " + evento.getDataPostagem());
        holder.txtResponsavelItem.setText("Responsável: " + (evento.getResponsavel() != null ? evento.getResponsavel() : "-"));

        // Banner (pode ser adaptado para carregar imagens reais)
        holder.imgBanner.setImageResource(R.drawable.icone_escola);

        // Botão "Ver mais"
        holder.btnVerMais.setOnClickListener(v -> {
            Context context = v.getContext();
            Intent intent = new Intent(context, EventoActivity.class);
            intent.putExtra("titulo", evento.getTitulo());
            intent.putExtra("corpo", evento.getCorpo());
            intent.putExtra("dataPostagem", evento.getDataPostagem());
            intent.putExtra("dataEvento", evento.getDataEvento());
            intent.putExtra("local", evento.getLocal());
            intent.putExtra("responsavel", evento.getResponsavel()); // 🔹 novo campo
            context.startActivity(intent);
        });

        // Botão "Favoritar"
        holder.btnFavoritar.setImageResource(
                evento.isFavoritado() ? R.drawable.ic_star_filled : R.drawable.ic_star_border
        );

        holder.btnFavoritar.setOnClickListener(v -> {
            evento.setFavoritado(!evento.isFavoritado());

            // Atualiza apenas o ícone
            holder.btnFavoritar.setImageResource(
                    evento.isFavoritado() ? R.drawable.ic_star_filled : R.drawable.ic_star_border
            );

            // Animação de "pop"
            holder.btnFavoritar.animate()
                    .scaleX(1.2f)
                    .scaleY(1.2f)
                    .setDuration(150)
                    .withEndAction(() -> {
                        holder.btnFavoritar.animate().scaleX(1f).scaleY(1f).setDuration(150);
                    });
        });
    }

    @Override
    public int getItemCount() {
        return listaEventos.size();
    }

    public static class EventoViewHolder extends RecyclerView.ViewHolder {
        ImageView imgBanner;
        TextView txtTituloItem, txtDescricaoItem, txtDataEventoItem, txtDataPostagemItem, txtResponsavelItem;
        Button btnVerMais;
        ImageButton btnFavoritar;

        public EventoViewHolder(@NonNull View itemView) {
            super(itemView);
            imgBanner = itemView.findViewById(R.id.imgBanner);
            txtTituloItem = itemView.findViewById(R.id.txtTituloItem);
            txtDescricaoItem = itemView.findViewById(R.id.txtDescricaoItem);
            txtDataEventoItem = itemView.findViewById(R.id.txtDataEventoItem);
            txtDataPostagemItem = itemView.findViewById(R.id.txtDataPostagemItem);
            txtResponsavelItem = itemView.findViewById(R.id.txtResponsavelItem); // 🔹 novo campo
            btnVerMais = itemView.findViewById(R.id.btnVerMais);
            btnFavoritar = itemView.findViewById(R.id.btnFavoritar);
        }
    }
}
