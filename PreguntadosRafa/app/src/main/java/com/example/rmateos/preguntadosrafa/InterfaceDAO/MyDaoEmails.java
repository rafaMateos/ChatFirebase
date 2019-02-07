package com.example.rmateos.preguntadosrafa.InterfaceDAO;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.rmateos.preguntadosrafa.Models.Email;


import java.util.ArrayList;
import java.util.List;

@Dao
public interface MyDaoEmails {

    /*Method to insert a single email*/
    @Insert()
     void insertEmail(Email email);

    @Delete()
     void deleteEmail(Email email);

    @Update()
     void updateEmail(Email email);

    /*Interface for select all the emails in DB*/
    @Query("Select * from Email")
     LiveData<List<Email>> getListEmail();

}
