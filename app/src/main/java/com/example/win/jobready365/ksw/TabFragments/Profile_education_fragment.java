package com.example.win.jobready365.ksw.TabFragments;

import android.content.Context;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


import com.example.win.jobready365.R;


public class Profile_education_fragment extends Fragment {
    private FragmentCommunicator mCallback;
    EditText editTextEducUniversity, editTextEducDegree;
    EditText editTextEducYear;
    String educUniversity, educDegree, educYear;
    Button btnEduc;

    public Profile_education_fragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //  editTextEducation = (EditText) findViewById(R.id.editText_education);

        View view = inflater.inflate(R.layout.fragment_profile_education_fragment, container, false);
        editTextEducUniversity = (EditText) view.findViewById(R.id.editText_university);
        editTextEducDegree = (EditText) view.findViewById(R.id.editText_degree);
        editTextEducYear = (EditText) view.findViewById(R.id.editText_year);



        btnEduc = (Button) view.findViewById(R.id.btn_educ_update);
        btnEduc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                educUniversity = editTextEducUniversity.getText().toString();
                educDegree = editTextEducDegree.getText().toString();
                educYear = editTextEducYear.getText().toString();
                sendMessage(educUniversity, educDegree, educYear);
            }
        });
        // Inflate the layout for this fragment
        return view;
    }

    public void showDatePickerDialog(View v) {
        // DialogFragment newFragment = new DatePickerFragment();
        //  newFragment.show(getSupportFragmentManager(), "datePicker");
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            mCallback = (FragmentCommunicator) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString()
                    + " must implement IFragmentToActivity");
        }
    }

    @Override
    public void onDetach() {
        mCallback = null;
        super.onDetach();
    }


    public void sendMessage(String educUniversity, String educDegree, String educYear) {
        mCallback.setCommunication(educUniversity, educDegree, educYear);
    }



}
