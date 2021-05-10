package com.sujon.varsitygradecalculaton;

import android.app.Application;
import android.os.AsyncTask;
import com.sujon.varsitygradecalculaton.model.Semister;

public class GradeRepository {
    private CourseDao courseDao;
    private SemisterDao semisterDao;

    public GradeRepository(Application application) {
        GradeDatabase db = GradeDatabase.getDatabase(application);
        courseDao = db.courseDao();
        semisterDao=db.semisterDao();
    }

    public void InsertSemister(Semister semister){
        new InsertTask(semisterDao).execute(semister);

    }

    private static class InsertTask extends AsyncTask<Semister,Void,Void>{
        private SemisterDao dao;
        InsertTask(SemisterDao semisterDao){
            dao=semisterDao;
        }

        @Override
        protected Void doInBackground(Semister... semisters) {
            dao.InsertSemister(semisters[0]);
            return null;
        }
    }

}
