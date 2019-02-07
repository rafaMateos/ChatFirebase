package com.example.rmateos.preguntadosrafa.RoomDatabase;
import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.ContentValues;
import android.content.Context;
import android.support.annotation.NonNull;

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
                            AppDatabase.class,"EmailDatabase.db").fallbackToDestructiveMigration().build();
                }

            }
        }

        return INSTANCE_DATABASE;

    }

    //Insertamos la primera vez que se cree la base de datos
    private static RoomDatabase.Callback rooCallback = new RoomDatabase.Callback(){

        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);

            ContentValues cv = new ContentValues();
            cv.put("destinatario", "rafaelMateos@gmail.com");
            cv.put("titulo", "Ere el mejon");
            cv.put("contenido", "lorem ipsum");
            db.insert("Email",OnConflictStrategy.IGNORE,cv);
        }
    };
}
