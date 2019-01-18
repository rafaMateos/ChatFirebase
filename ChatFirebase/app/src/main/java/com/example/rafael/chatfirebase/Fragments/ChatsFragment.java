package com.example.rafael.chatfirebase.Fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.rafael.chatfirebase.Adapter.UserAdapter;
import com.example.rafael.chatfirebase.Model.Chat;
import com.example.rafael.chatfirebase.Model.User;
import com.example.rafael.chatfirebase.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class ChatsFragment extends Fragment {

    private RecyclerView recyclerView;
    private UserAdapter useradapter;
    private List<User> mUsers;

    FirebaseUser fuser;
    DatabaseReference databaseReference;

    private List<String> userList;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        // Inflate the layout for this fragment
       View view = inflater.inflate(R.layout.fragment_chats,container,false);

       recyclerView = view.findViewById(R.id.recycler_view);
       recyclerView.setHasFixedSize(true);
       recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

       fuser = FirebaseAuth.getInstance().getCurrentUser();

       userList = new ArrayList<>();

       databaseReference = FirebaseDatabase.getInstance().getReference("Chats");

        /**
         * Tienes que mirar porque te da un nullPointer si el array de usarios si tiene
         * los usuarios que estan registrado en la aplicacion*/

        /**
         * Mirar tambn la posibilidad de implementar si el usuario esta conectado en ese momento*/

        /**
         * Comprobar si el mensage esta leido o no esta leido por el usuario*/

        /**
         *
         * Implementar otra parte del menu ViewPager para que el usuario pueda ver si propio perfil, y realizar
         * acciones sobre el
         * */

        /**
         * Poder cambiar la imagen de perfil del usuario, ya que esta implementado la manera de comprobar
         * si el usuario tiene una imagen ya cambiada*/


       return view;
    }



}
