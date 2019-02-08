package com.example.rmateos.preguntadosrafa.Fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.rmateos.preguntadosrafa.BussinesLogic.Repository;
import com.example.rmateos.preguntadosrafa.Models.Email;
import com.example.rmateos.preguntadosrafa.R;
import com.example.rmateos.preguntadosrafa.ViewModels.ViewModel;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link InsertarEmails.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link InsertarEmails#newInstance} factory method to
 * create an instance of this fragment.
 */
public class InsertarEmails extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    public EditText titulo;
    public EditText destinatario;
    public EditText contenido;
    private Button save;


    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public InsertarEmails() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment InsertarEmails.
     */
    // TODO: Rename and change types and number of parameters
    public static InsertarEmails newInstance(String param1, String param2) {
        InsertarEmails fragment = new InsertarEmails();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_insertar_emails, container, false);

        titulo = v.findViewById(R.id.titulo);
        contenido = v.findViewById(R.id.contenido);
        destinatario = v.findViewById(R.id.destinatario);
        save = v.findViewById(R.id.Save);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String title = titulo.getText().toString();
                String content = contenido.getText().toString();
                String to = destinatario.getText().toString();

                if(title.isEmpty() || content.isEmpty() || to.isEmpty()){

                    Toast.makeText(getContext(), "No puedes dejar campos vacios", Toast.LENGTH_SHORT).show();

                }
                else{

                    Email emailToInsert = new Email();

                    emailToInsert.titulo = title;
                    emailToInsert.contenido = content;
                    emailToInsert.destinatarioEmail = to;
                    emailToInsert.id = 0;

                    ViewModel viewModel = new ViewModel(getActivity().getApplication());
                    viewModel.insert(emailToInsert,getContext());

                    Toast.makeText(getContext(), "Email save", Toast.LENGTH_SHORT).show();
                }


            }
        });



        return v;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    /*
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }
    */

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
