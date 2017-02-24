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

public class Profile_fragment extends Fragment  {
    private FragmentCommunicator mCallback;
    Button testButton;

    String firstName, lastName, maritalStatus, gender, dateOfBirth, mobileNo, email, address, township,postalCode,
            city, country;


    EditText editTextFirstName, editTextLastName,
            editTextMaritalStatus, editTextGender, editTextDateOfBirth, editTextMobileNo,
            editTextEmail, editTextAddress, editTextTownship,editTextPostalCode, editTextCity, editTextCountry;

    public Profile_fragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile_fragment, container, false);
        testButton = (Button) view.findViewById(R.id.btn_test_);
        editTextFirstName = (EditText)view.findViewById(R.id.editText_first_name);
        editTextLastName = (EditText) view.findViewById(R.id.editText_last_name);
        editTextMaritalStatus = (EditText) view.findViewById(R.id.editText_marital_status);
        editTextGender = (EditText) view.findViewById(R.id.editText_gender);
        editTextDateOfBirth = (EditText) view.findViewById(R.id.editText_date_of_birth);
        editTextMobileNo = (EditText) view.findViewById(R.id.editText_mobile_no);
        editTextEmail = (EditText) view.findViewById(R.id.editText_email);
        editTextAddress = (EditText) view.findViewById(R.id.editText_address);
        editTextTownship = (EditText) view.findViewById(R.id.editText_township);
        editTextPostalCode = (EditText)view.findViewById(R.id.editText_postalCode);
        editTextCity = (EditText) view.findViewById(R.id.editText_cityId);
        editTextCountry =(EditText) view.findViewById(R.id.editText_country);


        testButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firstName = editTextFirstName.getText().toString();
                lastName = editTextLastName.getText().toString();
                lastName = editTextLastName.getText().toString();
                maritalStatus = editTextMaritalStatus.getText().toString();
                gender = editTextGender.getText().toString();
                dateOfBirth = editTextDateOfBirth.getText().toString();
                mobileNo = editTextMobileNo.getText().toString();
                email = editTextEmail.getText().toString();
                address = editTextAddress.getText().toString();
                township = editTextTownship.getText().toString();
                postalCode = editTextPostalCode.getText().toString();
                city = editTextCity.getText().toString();
                country =editTextCountry.getText().toString();


                sendMessage(firstName,lastName,maritalStatus,gender,dateOfBirth,mobileNo,email,address,township
                            ,postalCode,city,country);
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

    public void sendMessage(String firstName,String lastName,String maritalStatus,String gender
                            ,String dateOfBirth,String mobileNo,String email,String address,
                            String township,String postalCode,String city, String country)
    {
        mCallback.setCommunication(firstName,lastName,maritalStatus,gender,dateOfBirth,mobileNo,email
                                    ,address,township,postalCode,city,country);
    }




}
