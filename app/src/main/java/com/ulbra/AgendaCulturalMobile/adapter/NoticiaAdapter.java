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
import com.ulbra.AgendaCulturalMobile.activities.NoticiaActivity;
import com.ulbra.AgendaCulturalMobile.models.Noticia;
import java.util.List;

public class NoticiaAdapter extends RecyclerView.Adapter<NoticiaAdapter.NoticiaViewHolder> {

    private List<Noticia> listaNoticias;

    public NoticiaAdapter(List<Noticia> listaNoticias) {
        this.listaNoticias = listaNoticias;
    }

    @NonNull
    @Override
    public NoticiaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_noticia, parent, false);
        return new NoticiaViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull NoticiaViewHolder holder, int position) {
        Noticia noticia = listaNoticias.get(position);

        // Preenche os textos
        holder.txtTituloItem.setText(noticia.getTitulo());
        holder.txtDescricaoItem.setText(noticia.getCorpo());
        holder.txtDataEventoItem.setText("Evento: " + (noticia.getDataEvento() != null ? noticia.getDataEvento() : "-"));
        holder.txtDataPostagemItem.setText("Postado em: " + noticia.getDataPostagem());

        // Banner (pode ser adaptado para carregar imagens reais)
        holder.imgBanner.setImageResource(R.drawable.icone_escola);

        // Botão "Ver mais"
        holder.btnVerMais.setOnClickListener(v -> {
            Context context = v.getContext();
            Intent intent = new Intent(context, NoticiaActivity.class);
            intent.putExtra("titulo", noticia.getTitulo());
            intent.putExtra("corpo", noticia.getCorpo());
            intent.putExtra("dataPostagem", noticia.getDataPostagem());
            intent.putExtra("dataEvento", noticia.getDataEvento());
            intent.putExtra("local", noticia.getLocal());
            context.startActivity(intent);
        });

        // Botão "Favoritar"
        holder.btnFavoritar.setImageResource(
                noticia.isFavoritado() ? R.drawable.ic_star_filled : R.drawable.ic_star_border
        );

        holder.btnFavoritar.setOnClickListener(v -> {
            noticia.setFavoritado(!noticia.isFavoritado());

            // Atualiza apenas o ícone
            holder.btnFavoritar.setImageResource(
                    noticia.isFavoritado() ? R.drawable.ic_star_filled : R.drawable.ic_star_border
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
        return listaNoticias.size();
    }

    public static class NoticiaViewHolder extends RecyclerView.ViewHolder {
        ImageView imgBanner;
        TextView txtTituloItem, txtDescricaoItem, txtDataEventoItem, txtDataPostagemItem;
        Button btnVerMais;
        ImageButton btnFavoritar;

        public NoticiaViewHolder(@NonNull View itemView) {
            super(itemView);
            imgBanner = itemView.findViewById(R.id.imgBanner);
            txtTituloItem = itemView.findViewById(R.id.txtTituloItem);
            txtDescricaoItem = itemView.findViewById(R.id.txtDescricaoItem);
            txtDataEventoItem = itemView.findViewById(R.id.txtDataEventoItem);
            txtDataPostagemItem = itemView.findViewById(R.id.txtDataPostagemItem);
            btnVerMais = itemView.findViewById(R.id.btnVerMais);
            btnFavoritar = itemView.findViewById(R.id.btnFavoritar);
        }
    }
}
