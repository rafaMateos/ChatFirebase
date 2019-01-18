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
import com.example.rafael.chatfirebase.Model.ChatList;
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

    private List<Chat> userList;


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

       databaseReference = FirebaseDatabase.getInstance().getReference("Chats");//.child(fuser.getUid());
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                userList.clear();
                for (DataSnapshot snapshot : dataSnapshot.getChildren()){





                }

                obtenerMisChats();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });




       return view;
    }

    private void obtenerMisChats() {



    }


}
