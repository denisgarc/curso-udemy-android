package com.androidavanzado.prueba;

import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class MyNotaRecyclerViewAdapter extends RecyclerView.Adapter<MyNotaRecyclerViewAdapter.ViewHolder> {

    private final List<Nota> mValues;
    private NotasInteractionListener mlistener;

    public MyNotaRecyclerViewAdapter(List<Nota> items, NotasInteractionListener listener) {
        mValues = items;
        mlistener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.fragment_nota, parent, false);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.textViewTitulo.setText(holder.mItem.getTitle());
        holder.textViewContenido.setText(holder.mItem.getContent());
        if(holder.mItem.getFavorite()){
            holder.imageViewFavorita.setImageResource(R.drawable.ic_baseline_star_24);
        }

        holder.imageViewFavorita.setOnClickListener((v) -> {
           if(null != mlistener){
               mlistener.favoritaNotaClick(holder.mItem);
           }
        });
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mview;
        public final TextView textViewTitulo;
        public final TextView textViewContenido;
        public final ImageView imageViewFavorita;
        public Nota mItem;

        public ViewHolder(View view) {
            super(view);
            mview = view;
            textViewTitulo = view.findViewById(R.id.textViewTitulo);
            textViewContenido = view.findViewById(R.id.textViewContenido);
            imageViewFavorita = view.findViewById(R.id.imageViewFavorita);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + textViewTitulo.getText() + "'";
        }
    }
}