package com.example.win.jobready365.ksw.TabFragments;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import com.example.win.jobready365.R;

import java.util.Calendar;


public class Profile_experience_fragment extends Fragment {
    private FragmentCommunicator mCallback;
    EditText  editTextExpOrganization, editTextExpRank;
     static EditText       editTextExpStartDate, editTextExpEndDate;

    String  expOrganization, expRank;
    String expStartDate, expEndDate;
    Button btnExp;

    public Profile_experience_fragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view   = inflater.inflate(R.layout.fragment_profile_experience_fragment, container, false);
        //  editTextExp = (EditText) findViewById(R.id.editText_experience);
        editTextExpOrganization = (EditText)view. findViewById(R.id.editText_organization);
        editTextExpRank = (EditText) view.findViewById(R.id.editText_exp_rank);
        editTextExpStartDate = (EditText) view.findViewById(R.id.editText_start_date);
        editTextExpEndDate = (EditText)view. findViewById(R.id.editText_end_date);

        editTextExpStartDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    mCallback.respondStartDate("Clicked");
                } catch (Exception ex) {
                    Toast.makeText(getContext(), ex.toString(), Toast.LENGTH_SHORT).show();
                }

            }
        });

        editTextExpEndDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    mCallback.respondEndDate("Clicked");
                } catch (Exception ex) {
                    Toast.makeText(getContext(), ex.toString(), Toast.LENGTH_SHORT).show();
                }

            }
        });
        btnExp = (Button)view.findViewById(R.id.btn_exp_update);
        btnExp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                expOrganization = editTextExpOrganization.getText().toString();
                expRank = editTextExpRank.getText().toString();
                expStartDate = editTextExpStartDate.getText().toString();
                expEndDate = editTextExpEndDate.getText().toString();
                sendMessage(expOrganization,expRank,expStartDate,expEndDate);
            }
        });
        return view;




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

    public void sendMessage(String expOrganization,String expRank,String expStartDate, String expEndDate)
    {
        mCallback.setCommunication(expOrganization,expRank,expStartDate,expEndDate);
    }

    // DatePicker class

    public static class StartDatePickerFragment extends DialogFragment implements
            DatePickerDialog.OnDateSetListener {

        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            // Use the current date as the default date in the picker
            Calendar c = Calendar.getInstance();





            int year = c.get(Calendar.YEAR);

            int month = c.get(Calendar.MONTH);

            int day = c.get(Calendar.DAY_OF_MONTH);



            // Create a new instance of DatePickerDialog and return it
            return new DatePickerDialog(getActivity(), this, year, month, day);
        }


        public void onDateSet(DatePicker view, int year, int month, int day) {
            // Do something with the date chosen by the user
            editTextExpStartDate.setText(year + "-" + (month + 1) + "-" + day);

        }


    }
    public static class EndDatePickerFragment extends DialogFragment implements
            DatePickerDialog.OnDateSetListener {

        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            // Use the current date as the default date in the picker
            Calendar c = Calendar.getInstance();





            int year = c.get(Calendar.YEAR);

            int month = c.get(Calendar.MONTH);

            int day = c.get(Calendar.DAY_OF_MONTH);



            // Create a new instance of DatePickerDialog and return it
            return new DatePickerDialog(getActivity(), this, year, month, day);
        }


        public void onDateSet(DatePicker view, int year, int month, int day) {
            // Do something with the date chosen by the user

            editTextExpEndDate.setText(year + "-" + (month + 1) + "-" + day);
        }


    }

}
