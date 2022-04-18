package com.androidavanzado.prueba;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.androidavanzado.prueba.db.NotaRoomDataBase;
import com.androidavanzado.prueba.db.dao.NotaDao;
import com.androidavanzado.prueba.db.entity.NotaEntity;

import java.util.List;

public class NotaRepository {
    private NotaDao notaDao;

    public NotaRepository(Application application) {
        NotaRoomDataBase db = NotaRoomDataBase.getDataBase(application);
        notaDao = db.notaDao();
    }

    public LiveData<List<NotaEntity>> getAll() { return notaDao.getAll(); }

    public LiveData<List<NotaEntity>> getAllFavorites() { return notaDao.getAllFavorites(); }

    public void insert(NotaEntity nota) {
        new insertAsyncTask(notaDao).execute(nota);
    }

    public void update(NotaEntity nota) {
        new updateAsyncTask(notaDao).execute(nota);
    }

    private static class insertAsyncTask extends AsyncTask<NotaEntity, Void, Void> {
        private NotaDao notaDaoAsyncTask;

        public insertAsyncTask(NotaDao dao) {
            this.notaDaoAsyncTask = dao;
        }

        @Override
        protected Void doInBackground(NotaEntity... notaEntities) {
            notaDaoAsyncTask.insert(notaEntities[0]);
            return null;
        }
    }

    private static class updateAsyncTask extends AsyncTask<NotaEntity, Void, Void> {
        private NotaDao notaDaoAsyncTask;

        public updateAsyncTask(NotaDao dao) {
            this.notaDaoAsyncTask = dao;
        }

        @Override
        protected Void doInBackground(NotaEntity... notaEntities) {
            notaDaoAsyncTask.update(notaEntities[0]);
            return null;
        }
    }
}
