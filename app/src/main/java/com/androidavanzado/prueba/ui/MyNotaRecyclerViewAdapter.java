package com.androidavanzado.prueba.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.androidavanzado.prueba.NuevaNotaDialogViewModel;
import com.androidavanzado.prueba.db.entity.NotaEntity;
import com.androidavanzado.prueba.R;

import java.util.List;

public class MyNotaRecyclerViewAdapter extends RecyclerView.Adapter<MyNotaRecyclerViewAdapter.ViewHolder> {

    private List<NotaEntity> mValues;
    private final Context mctx;
    private NuevaNotaDialogViewModel viewModel;

    public MyNotaRecyclerViewAdapter(List<NotaEntity> items, Context ctx) {
        mValues = items;
        mctx = ctx;
        viewModel = new ViewModelProvider((AppCompatActivity)ctx).get(NuevaNotaDialogViewModel.class);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.fragment_nota, parent, false);
        return new ViewHolder(view);

    }

    public void setNuevasNotas(List<NotaEntity> nuevasNotas) {
        this.mValues = nuevasNotas;
        notifyDataSetChanged();
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
            if(holder.mItem.getFavorite()) {
                holder.mItem.setFavorite(false);
                holder.imageViewFavorita.setImageResource(R.drawable.ic_baseline_star_border_24);
            } else {
                holder.mItem.setFavorite(true);
                holder.imageViewFavorita.setImageResource(R.drawable.ic_baseline_star_24);
            }

            // Se realiza la actualizacion
            viewModel.updateNota(holder.mItem);
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
        public NotaEntity mItem;

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