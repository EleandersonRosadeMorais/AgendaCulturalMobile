package com.ulbra.myapplication;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ulbra.myapplication.activities.NoticiaActivity;
import com.ulbra.myapplication.models.Noticia;

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
        holder.txtTituloItem.setText(noticia.getTitulo());
        holder.txtDataPostagemItem.setText("Postado em: " + noticia.getDataPostagem());

        if (noticia.getDataEvento() != null) {
            holder.txtDataEventoItem.setText("Evento: " + noticia.getDataEvento());
        } else {
            holder.txtDataEventoItem.setText("Evento: -");
        }

        // Clique para abrir a NoticiaActivity
        holder.itemView.setOnClickListener(v -> {
            Context context = v.getContext();
            Intent intent = new Intent(context, NoticiaActivity.class);
            intent.putExtra("titulo", noticia.getTitulo());
            intent.putExtra("corpo", noticia.getCorpo());
            intent.putExtra("dataPostagem", noticia.getDataPostagem());
            intent.putExtra("dataEvento", noticia.getDataEvento());
            intent.putExtra("local", noticia.getLocal());
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return listaNoticias.size();
    }

    public static class NoticiaViewHolder extends RecyclerView.ViewHolder {
        TextView txtTituloItem, txtDataPostagemItem, txtDataEventoItem;

        public NoticiaViewHolder(@NonNull View itemView) {
            super(itemView);
            txtTituloItem = itemView.findViewById(R.id.txtTituloItem);
            txtDataPostagemItem = itemView.findViewById(R.id.txtDataPostagemItem);
            txtDataEventoItem = itemView.findViewById(R.id.txtDataEventoItem);
        }
    }
}
