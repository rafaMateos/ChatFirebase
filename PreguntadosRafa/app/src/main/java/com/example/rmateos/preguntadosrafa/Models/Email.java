package com.example.rmateos.preguntadosrafa.Models;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class Email {

    public Email() {
    }

    @PrimaryKey(autoGenerate=true)
    public int id;

    @ColumnInfo(name = "destinatario")
    public String destinatarioEmail;
    @ColumnInfo(name = "titulo")
    public String titulo;
    @ColumnInfo(name = "contenido")
    public String contenido;





    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDestinatarioEmail() {
        return destinatarioEmail;
    }

    public void setDestinatarioEmail(String destinatarioEmail) {
        this.destinatarioEmail = destinatarioEmail;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }
}
