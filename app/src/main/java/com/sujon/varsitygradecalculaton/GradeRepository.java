package com.sujon.varsitygradecalculaton;

import android.content.Context;
import android.os.AsyncTask;
import com.sujon.varsitygradecalculaton.model.Course;
import com.sujon.varsitygradecalculaton.model.Semister;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class GradeRepository {
    private CourseDao courseDao;
    private SemisterDao semisterDao;

    List<Semister> mySemisterList=new ArrayList<>();

    public GradeRepository(Context application) {
        GradeDatabase db = GradeDatabase.getDatabase(application);
        courseDao = db.courseDao();
        semisterDao=db.semisterDao();
    }

    public void InsertSemister(Semister semister){
        new InsertTask(semisterDao).execute(semister);

    }

    public void InsertCourseList(List<Course>myCourses){
        new courseListTask(courseDao).execute(myCourses);
    }

    public List<Semister>GetAllSemisters(){
        try {
            mySemisterList = new GetAllSemisterTask(semisterDao).execute().get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return mySemisterList;
    }



//background task
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

    private static class GetAllSemisterTask extends AsyncTask<Void,Void,List<Semister>>{
        SemisterDao dao;
        GetAllSemisterTask(SemisterDao semisterDao){
            dao=semisterDao;
        }

        @Override
        protected List<Semister> doInBackground(Void... voids) {
            return dao.GetAllSemisters();

        }
    }

    private static class courseListTask extends AsyncTask<List<Course>,Void,Void> implements com.sujon.varsitygradecalculaton.courseListTask {
        CourseDao dao;
        public courseListTask(CourseDao courseDao) {
            dao=courseDao;
        }

        protected Void doInBackground(List<Course>... lists) {
            dao.InsertCourseList(lists[0]);
            return null;
        }

    }

}
