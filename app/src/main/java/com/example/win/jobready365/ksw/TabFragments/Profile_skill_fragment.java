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


public class Profile_skill_fragment extends Fragment  {
    private FragmentCommunicator mCallbackSkill;
    EditText  editTextSkillType,editTextSkillLevel;
    String        skillType, skillLevel;
    Button skillBtn;

    public Profile_skill_fragment() {
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
        View view  = inflater.inflate(R.layout.fragment_profile_skill_fragment, container, false);
        //  editTextSkill = (EditText) findViewById(R.id.editText_skill);
        editTextSkillType = (EditText) view.findViewById(R.id.editText_skill_type);
        editTextSkillLevel = (EditText) view.findViewById(R.id.editText_level);
        skillBtn = (Button)view.findViewById(R.id.btn_skill_update);
        skillBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                skillType = editTextSkillType.getText().toString();
                skillLevel = editTextSkillLevel.getText().toString();
                sendMessage(skillType,skillLevel);
            }
        });
        return  view;
    }
    @Override
    public void onDetach() {
        mCallbackSkill = null;
        super.onDetach();
    }
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            mCallbackSkill = (FragmentCommunicator) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString()
                    + " must implement IFragmentToActivity");
        }
    }



    public void sendMessage(String skillType, String skillLevel)
    {
        mCallbackSkill.setCommunication(skillType,skillLevel);
    }
}
