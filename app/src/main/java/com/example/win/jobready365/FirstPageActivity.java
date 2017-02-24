package com.example.win.jobready365;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.win.jobready365.Authentication.LoginActivity;
import com.example.win.jobready365.ksw.Services.Event.ErrorEvent;
import com.example.win.jobready365.ksw.Services.Event.ServerEvent;

import com.example.win.jobready365.ksw.Adapters.EmpRecycleViewAdapter;
import com.example.win.jobready365.ksw.PojoJavaClasses.Employer;
import com.example.win.jobready365.ksw.Services.BusProvider;
import com.example.win.jobready365.ksw.Services.Communicator;
import com.squareup.otto.Subscribe;

import java.util.ArrayList;

public class FirstPageActivity extends AppCompatActivity {

    ProgressDialog pd1;
    private Communicator communicator;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    public static ArrayList<Employer> employer;

    private SwipeRefreshLayout swipeContainer;
    private static String LOG_TAG = "FirstPageActivity";
    private TextView Disconnected;
    private Button buttontonext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        communicator = new Communicator();
        setContentView(R.layout.activity_first_page);

        initViews();

        buttontonext=(Button)findViewById(R.id.buttontologin);
        buttontonext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(FirstPageActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
        swipeContainer = (SwipeRefreshLayout) findViewById(R.id.swipeContainer_firstPage);

        // Configure the refreshing colors
        swipeContainer.setColorSchemeResources(android.R.color.holo_orange_dark);

        swipeContainer.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {

                Toast.makeText(FirstPageActivity.this,"Movie List Refreshed.", Toast.LENGTH_SHORT).show();
                loadJSON();
            }
        });
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    private void useGetResult(String category, String location, String type) {
        communicator.getResult(category,location,type);
    }
    @Subscribe
    public void onServerEvent(ServerEvent serverEvent) {

        if (serverEvent.getServerResponse() != null) {
            employer =  serverEvent.getServerResponse().getEmployerList();
           // Toast.makeText(getApplicationContext(),""+employer.size(),Toast.LENGTH_LONG).show();
            recyclerView.setAdapter(new EmpRecycleViewAdapter(this,employer));

            //Toast.makeText(MainActivity5.this, movieArrayList.toString(), Toast.LENGTH_SHORT).show();
            swipeContainer.setRefreshing(false);
            pd1.hide();

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

    private void initViews() {
        pd1 = new ProgressDialog(this);
        pd1.setMessage("Fetching Jobs...");
        pd1.setCancelable(false);
        pd1.show();
        recyclerView = (RecyclerView) findViewById(R.id.my_recycle_view1);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.smoothScrollToPosition(0);
        loadJSON();
    }

    private void loadJSON() {
        String category = "";
        String location =  "";
        String  type = "";

        useGetResult(category,location,type);
    }
}

