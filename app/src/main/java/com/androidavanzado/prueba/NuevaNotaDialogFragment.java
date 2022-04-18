package com.androidavanzado.prueba;

import androidx.fragment.app.DialogFragment;
import androidx.lifecycle.ViewModelProvider;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Switch;

import com.androidavanzado.prueba.db.entity.NotaEntity;

public class NuevaNotaDialogFragment extends DialogFragment {

    // private NuevaNotaDialogViewModel mViewModel;
    private View mView;
    private EditText editTextTitulo;
    private EditText editTextContenido;
    private RadioGroup radioGroupColor;
    private Switch switchFavorita;

    public static NuevaNotaDialogFragment newInstance() {
        return new NuevaNotaDialogFragment();
    }

    /*@Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        NuevaNotaDialogViewModel mViewModel = new ViewModelProvider(this).get(NuevaNotaDialogViewModel.class);
        // TODO: Use the ViewModel
    }*/

    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        // Use the builder class for convenient dialog construction
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        builder.setTitle("Nueva Nota");
        builder.setMessage("Introduzca los datos de la nueva nota")
                .setPositiveButton("Guardar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String titulo = editTextTitulo.getText().toString();
                        String contenido = editTextContenido.getText().toString();
                        String color = "azul";
                        switch(radioGroupColor.getCheckedRadioButtonId()){
                            case R.id.radioButtonColorRojo:
                                color = "rojo"; break;
                            case R.id.radioButtonColorVerde:
                                color = "verde"; break;
                        }
                        boolean esFavorita = switchFavorita.isChecked();

                        // Comunicar al viewmodel el nuevo dato
                        NuevaNotaDialogViewModel mViewModel = new ViewModelProvider(getActivity()).get(NuevaNotaDialogViewModel.class);
                        mViewModel.insertarNota(new NotaEntity(titulo, contenido, esFavorita, color));
                        dialogInterface.dismiss();
                    }
                })
                .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });

        LayoutInflater inflater = getActivity().getLayoutInflater();
        mView = inflater.inflate(R.layout.nueva_nota_dialog_fragment, null);

        editTextTitulo = mView.findViewById(R.id.editTextTitulo);
        editTextContenido = mView.findViewById(R.id.editTextTitulo);
        radioGroupColor = mView.findViewById(R.id.radioGroupColor);
        switchFavorita = mView.findViewById(R.id.switchNotaFavorita);

        builder.setView(mView);

        return builder.create();
    }
}