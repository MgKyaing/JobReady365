package com.example.win.jobready365;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.DialogFragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.win.jobready365.ksw.Adapters.ViewPagerAdapter;
import com.example.win.jobready365.ksw.PojoJavaClasses.Education;
import com.example.win.jobready365.ksw.PojoJavaClasses.Experience;
import com.example.win.jobready365.ksw.PojoJavaClasses.Refree;
import com.example.win.jobready365.ksw.PojoJavaClasses.Skill;
import com.example.win.jobready365.ksw.Services.BusProvider;
import com.example.win.jobready365.ksw.Services.Communicator;
import com.example.win.jobready365.ksw.Services.Event.ErrorEvent;
import com.example.win.jobready365.ksw.Services.Event.ServerEvent;
import com.example.win.jobready365.ksw.TabFragments.FragmentCommunicator;
import com.example.win.jobready365.ksw.TabFragments.Profile_education_fragment;
import com.example.win.jobready365.ksw.TabFragments.Profile_experience_fragment;
import com.example.win.jobready365.ksw.TabFragments.Profile_fragment;
import com.example.win.jobready365.ksw.TabFragments.Profile_refree_fragment;
import com.example.win.jobready365.ksw.TabFragments.Profile_skill_fragment;
import com.squareup.otto.Subscribe;

import java.util.List;

public class ProfileActivity extends AppCompatActivity implements FragmentCommunicator {

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    Communicator communicator;
     String userId = MainActivity5.userId;
    String token = MainActivity5.token;



    Button updateBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
     // Server communicator
        communicator = new Communicator();

        viewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);


        // useGetApplicant(MainActivity5.userId, MainActivity5.token);
/*
        updateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firstName = editTextFirstName.getText().toString();
                Toast.makeText(getApplicationContext(),"rs = "+ firstName,Toast.LENGTH_SHORT).show();


                Toast.makeText(getApplicationContext(),""+b ,Toast.LENGTH_LONG).show();

                skill = editTextSkill.getText().toString();
                skillType =editTextSkillType.getText().toString();
                skillLevel=editTextSkillLevel.getText().toString();
                // setting a skill object




                final List<Experience> experienceList;
                experienceList = new ArrayList<Experience>();
                Experience experienceObj = new Experience(expOrganization,expRank,expStartDate,expEndDate);
                experienceList.add(experienceObj);



                refree = editTextRefree.getText().toString();
                refFirstName =editTextRefFirstName.getText().toString();
                refLastName = editTextRefLastName.getText().toString();
                refOrganization =editTextRefOrganization.getText().toString();
                refRank =editTextRefRank.getText().toString();
                refEmail = editTextRefEmail.getText().toString();
                refMobileNo = editTextRefMobileNo.getText().toString();




                useCreateApplicant(MainActivity5.userId, firstName, lastName, maritalStatus, gender, dateOfBirth, mobileNo, email, address,
                        township,postalCode,city,country,educationList,skillList,experienceList,refreeList);


            }
        });
*/



        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setLogo(R.mipmap.image);
        toolbar.setLogoDescription("JobReady365");


        toolbar.getPopupTheme();







        // useCreateApplicant(MainActivity5.userId,firstName,lastName,maritalStatus,gender,dateOfBirth,
        //         mobileNo,email,address,township,postalcode,city,country,);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }
    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new Profile_fragment(), "Profile");
        adapter.addFragment(new Profile_education_fragment(), "Education");
        adapter.addFragment(new Profile_skill_fragment(), "Skill");
        adapter.addFragment(new Profile_experience_fragment(), "Experience");
        adapter.addFragment(new Profile_refree_fragment(), "Referee");

        viewPager.setAdapter(adapter);
    }


    private void useCreateApplicant(String userId, String firstName, String lastName,
                                    String maritalStatus, String gender, String dateOfBirth,
                                    String mobileNo, String email, String address, String township,
                                    String postalCode, String city, String country, List<Education> educationList,
                                    List<Skill> skillList, List<Experience> experienceList,
                                    List<Refree> refreeList) {
        communicator.createApplicant(userId, firstName, lastName, maritalStatus, gender, dateOfBirth, mobileNo,
                email, address, township, postalCode, city, country, educationList, skillList, experienceList, refreeList);
    }

    private void useGetApplicant(String userId, String api_key) {
        communicator.getApplicant(userId, api_key);
    }

    private void useInsertSkill(String userId,String skillType,String skillLevel,String token){
        communicator.insertSkill(userId,skillType,skillLevel,token);
    }

    private void useInsertExperience(String userId,String expOrganizatioon,String expRank, String expStartedDate,String expEndDate,String token){
        communicator.insertExperience(userId,expOrganizatioon,expRank,expStartedDate,expEndDate,token);
    }

    private void useInsertEducation(String userId,String university,String degree, String year,String token){
        communicator.insertEducation(userId,university,degree,year,token);
    }

    private void useInsertReferee(String userId,String firstName,String lastName,String
                                  organization,String rank,String mobileNo,String email, String token){
        communicator.insertReferee(userId,firstName,lastName,organization,rank,mobileNo,email,token);
    }
    @Subscribe
    public void onServerEvent(ServerEvent serverEvent) {
        //  Intent intent = new Intent(MainActivity5.this,Main2Activity.class);
        //  startActivity(intent);

        // Toast.makeText(getApplicationContext(), "onServerEvent sucess " + serverEvent.getServerResponse().getToken(), Toast.LENGTH_SHORT).show();
        if (serverEvent.getServerResponse() != null) {
            Toast.makeText(getApplicationContext(), "success" + serverEvent.getServerResponse().getError().toString(), Toast.LENGTH_SHORT).show();
        }


    }

    @Subscribe
    public void onErrorEvent(ErrorEvent errorEvent) {
        Toast.makeText(this, "onErrorEvent fail " + errorEvent.getErrorMsg(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onResume() {
        super.onResume();
        BusProvider.getInstance().register(this);
    }

    @Override
    public void onPause() {
        super.onPause();
        BusProvider.getInstance().unregister(this);
    }


    @Override
    public void setCommunication(String firstName, String lastName, String maritalStatus, String gender, String dateOfBirth, String mobileNo,
                                 String email, String address, String township, String postalCode, String city, String country) {
        Toast.makeText(getApplicationContext(),""+firstName,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setCommunication(String educUniversity, String educDegree, String educYear) {
        useInsertEducation(userId,educUniversity,educDegree,educYear,token);
    }

    @Override
    public void setCommunication(String expOrganization, String expRank, String expStartDate, String expEndDate) {
            useInsertExperience(userId,expOrganization, expRank,expStartDate,expEndDate,token);

    }

    @Override
    public void setCommunication(String skillType, String skillLevel) {
        Toast.makeText(getApplicationContext(),""+skillType+""+skillLevel,Toast.LENGTH_SHORT).show();
        useInsertSkill(userId,skillType,skillLevel,token);







    }

    @Override
    public void setCommunication(String refFirstName, String refLastName, String refOrganization, String refRank, String refEmail, String refMobileNo) {
        useInsertReferee(userId,refFirstName,refLastName,refOrganization,refRank,refEmail,refMobileNo,token);
    }


    @Override
    public void respondStartDate(String clicked) {
        DialogFragment newFragment = new Profile_experience_fragment.StartDatePickerFragment();
        newFragment.show(getSupportFragmentManager(), "datePicker");
    }
    @Override
    public void respondEndDate(String clicked) {
        DialogFragment newFragment = new Profile_experience_fragment.EndDatePickerFragment();
        newFragment.show(getSupportFragmentManager(), "datePicker");




    }
}
