package com.sujon.varsitygradecalculaton;

import android.content.Context;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import com.sujon.varsitygradecalculaton.model.Course;
import com.sujon.varsitygradecalculaton.model.Semister;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {Course.class, Semister.class},version = 1,exportSchema = false)
public abstract class GradeDatabase extends RoomDatabase {
    public abstract CourseDao courseDao();
    public abstract SemisterDao semisterDao();

    public static volatile GradeDatabase INSTANCE;

    public static final int NUMBER_OF_THREADS = 4;

    static final ExecutorService databaseExecutor = Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    static GradeDatabase getDatabase(final Context context){
        if (INSTANCE==null){
            INSTANCE= Room.databaseBuilder(context.getApplicationContext(),GradeDatabase.class,
                    "GRADEDATABASE").fallbackToDestructiveMigration().build();
        }
        return INSTANCE;
    }

}
