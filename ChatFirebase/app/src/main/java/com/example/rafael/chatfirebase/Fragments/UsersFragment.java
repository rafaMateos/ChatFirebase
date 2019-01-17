package com.example.rafael.chatfirebase.Fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.Toast;

import com.example.rafael.chatfirebase.Adapter.UserAdapter;
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


public class UsersFragment extends Fragment implements TextWatcher {

    AutoCompleteTextView editText_buscar;
    FloatingActionButton btn_search;

    private RecyclerView recyclerView;

    private UserAdapter userAdapter;

    private List<User> mUsers;
    int times = 0;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_users,container,false);

        btn_search = view.findViewById(R.id.btn_buscar);
        editText_buscar = view.findViewById(R.id.bottom);
        editText_buscar.addTextChangedListener(this);

        btn_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(times == 0){
                    editText_buscar.setVisibility(View.VISIBLE);
                    times++;

                }else{
                    editText_buscar.setVisibility(View.GONE);
                    times--;

                }

            }
        });



        recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        mUsers = new ArrayList<>();

        readUser();

        return view;
    }


    private void readUser() {

        final FirebaseUser firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("Users");

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                mUsers.clear();
                for(DataSnapshot snapshot: dataSnapshot.getChildren()){

                    User user = snapshot.getValue(User.class);

                    assert user != null;
                    assert firebaseUser != null;
                    if(!user.getId().equals(firebaseUser.getUid())){

                        mUsers.add(user);//Añadimos los usuarios que sean distintos al usuario actual.
                        //Debemos tener en cuenta que para buscar tenemos que estar cambiando el adaptador del recycler view
                        //constantemente para asi poder actualizar cada vez que el usuarios introduzca alguna palabra,
                        //en el autoCompleteTextview
                    }
                }

                userAdapter = new UserAdapter(getContext(), mUsers);
                recyclerView.setAdapter(userAdapter);


            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

                Toast.makeText(getContext(), "Contrata movistar please", Toast.LENGTH_SHORT).show();


            }
        });
    }

    private void readUserSearch() {

        final FirebaseUser firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("Users");

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                mUsers.clear();
                for(DataSnapshot snapshot: dataSnapshot.getChildren()){

                    User user = snapshot.getValue(User.class);

                    assert user != null;
                    assert firebaseUser != null;
                    if(user.getUsername().contains(editText_buscar.getText().toString())){

                        mUsers.add(user);//Añadimos los usuarios que sean distintos al usuario actual.
                        //Debemos tener en cuenta que para buscar tenemos que estar cambiando el adaptador del recycler view
                        //constantemente para asi poder actualizar cada vez que el usuarios introduzca alguna palabra,
                        //en el autoCompleteTextview
                    }
                }

                userAdapter = new UserAdapter(getContext(), mUsers);
                recyclerView.setAdapter(userAdapter);


            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

                Toast.makeText(getContext(), "Contrata movistar please", Toast.LENGTH_SHORT).show();


            }
        });
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    @Override
    public void afterTextChanged(Editable s) {

        readUserSearch();
        editText_buscar.getText();

    }
}
