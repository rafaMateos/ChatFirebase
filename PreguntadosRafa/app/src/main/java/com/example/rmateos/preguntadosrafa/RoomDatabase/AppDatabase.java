package com.example.rmateos.preguntadosrafa.RoomDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import com.example.rmateos.preguntadosrafa.InterfaceDAO.MyDaoEmails;
import com.example.rmateos.preguntadosrafa.Models.Email;


@Database(entities = {Email.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {

    public abstract MyDaoEmails getQuestionDAO();

    private static AppDatabase INSTANCE_DATABASE;

    /*Singelton to conection database*/
    public static AppDatabase getInstanceDatabase(final Context context){

        if(INSTANCE_DATABASE == null){
            synchronized (AppDatabase.class){
                if(INSTANCE_DATABASE ==  null){

                    INSTANCE_DATABASE = Room.databaseBuilder(context.getApplicationContext(),
                            AppDatabase.class,"EmailDatabase.db").allowMainThreadQueries().build();
                }

            }
        }

        return INSTANCE_DATABASE;

    }
}
