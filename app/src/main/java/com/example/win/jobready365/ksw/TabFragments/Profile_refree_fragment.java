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


public class Profile_refree_fragment extends Fragment  {
    private FragmentCommunicator mCallback;
    EditText editTextRefree, editTextRefFirstName,
            editTextRefLastName, editTextRefOrganization, editTextRefRank, editTextRefEmail, editTextRefMobileNo;
    Button btnReferee;


    String refree, refFirstName, refLastName, refOrganization, refRank, refEmail, refMobileNo;

    public Profile_refree_fragment() {
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
        View view = inflater.inflate(R.layout.fragment_profile_refree_fragment, container, false);

        editTextRefFirstName = (EditText) view.findViewById(R.id.editText_refree_firstname);
        editTextRefLastName = (EditText) view.findViewById(R.id.editText_refree_last_name);
        editTextRefOrganization = (EditText) view.findViewById(R.id.editText_refree_organization);
        editTextRefRank = (EditText) view.findViewById(R.id.editText_refree_rank);
        editTextRefEmail = (EditText) view.findViewById(R.id.editText_refree_email);
        editTextRefMobileNo = (EditText) view.findViewById(R.id.editText_refree_mobile_no);
        btnReferee = (Button)view.findViewById(R.id.btn_referee_update);
        btnReferee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                refFirstName = editTextRefFirstName.getText().toString();
                refLastName = editTextRefLastName.getText().toString();
                refOrganization = editTextRefOrganization.getText().toString();
                refRank = editTextRefRank.getText().toString();
                refEmail = editTextRefEmail.getText().toString();
                refMobileNo = editTextRefMobileNo.getText().toString();
                sendMessage(refFirstName,refLastName,refOrganization,refRank,refEmail,refMobileNo);
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

    public void sendMessage(String refFirstName, String refLastName, String refOrganization, String refRank
            , String refEmail, String refMobileNo) {
        mCallback.setCommunication(refFirstName, refLastName, refOrganization, refRank, refEmail, refMobileNo);
    }

}
