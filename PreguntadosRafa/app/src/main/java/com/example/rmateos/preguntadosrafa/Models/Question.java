package com.example.rmateos.preguntadosrafa.Models;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Question {

    @PrimaryKey(autoGenerate = true)
    public int id;


    @ColumnInfo(name = "question_body")
    public String question_body;

    @ColumnInfo(name = "answer")
    public String answer;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuestion_body() {
        return question_body;
    }

    public void setQuestion_body(String question_body) {
        this.question_body = question_body;
    }

    public String getAnwers() {
        return answer;
    }

    public void setAnwers(String anwers) {
        this.answer = anwers;
    }
}
