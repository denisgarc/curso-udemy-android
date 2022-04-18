package com.androidavanzado.prueba;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.androidavanzado.prueba.db.entity.NotaEntity;

import java.util.List;

public class NuevaNotaDialogViewModel extends AndroidViewModel {
    private LiveData<List<NotaEntity>> allNotas;
    private NotaRepository notaRepository;

    public NuevaNotaDialogViewModel(Application application) {
        super(application);
        notaRepository = new NotaRepository(application);
        allNotas = notaRepository.getAll();
    }

    // El fragmento que necesita recibir la nueva lista de datos
    public LiveData<List<NotaEntity>> getAllNotas() { return allNotas; }

    // El fragmento que inserte una nueva nota, deberá comunicarlo en este viewmodel
    public void insertarNota(NotaEntity nota) { notaRepository.insert(nota); }

    public void updateNota(NotaEntity nota) { notaRepository.update(nota); }
}