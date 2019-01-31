package com.example.rmateos.preguntadosrafa.InterfaceDAO;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.example.rmateos.preguntadosrafa.Models.Question;

import java.util.ArrayList;
import java.util.List;

@Dao
public interface MyDaoQuestion {

    /*Method to insert a single question*/
    @Insert()
    public void insertQuestion(Question question);

    /*Method to insert a list of single question*/
    @Insert
    public void insertListQuestion(ArrayList<Question> listQuestion);

    /*Interface for select all the question in DB*/
    @Query("Select * from Question")
    public Question[] getListQuestion();

}
