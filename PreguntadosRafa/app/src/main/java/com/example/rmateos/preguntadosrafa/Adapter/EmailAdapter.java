package com.example.rmateos.preguntadosrafa.Adapter;

import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.rmateos.preguntadosrafa.Fragments.SeeAllEmails;
import com.example.rmateos.preguntadosrafa.Models.Email;
import com.example.rmateos.preguntadosrafa.R;
import com.example.rmateos.preguntadosrafa.ViewModels.ViewModel;

import java.util.ArrayList;
import java.util.List;

public class EmailAdapter extends RecyclerView.Adapter<EmailAdapter.EmailHolder> {

    private List<Email> emails = new ArrayList<>();

    ViewModel Editar;

    @NonNull
    @Override
    public EmailHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.email_item,viewGroup,false);


        return new EmailHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull EmailHolder emailHolder, int i) {

        Email currentEmail = emails.get(i);
        emailHolder.title.setText(currentEmail.getTitulo());
        emailHolder.content.setText(currentEmail.getContenido());
        emailHolder.to.setText(currentEmail.getDestinatarioEmail());
    }

    @Override
    public int getItemCount() {
        return emails.size();
    }

    public void setEmails(List<Email> emails){

        this.emails = emails;
        notifyDataSetChanged();

    }

    public Email getNoteSwipe(int pos){

        return emails.get(pos);

    }

    class EmailHolder extends RecyclerView.ViewHolder{

        private TextView title;
        private TextView content;
        private TextView to;


        public EmailHolder(View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.title_email);
            content = itemView.findViewById(R.id.Contenido);
            to = itemView.findViewById(R.id.Destinatario);


        }



    }
}
