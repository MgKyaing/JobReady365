package com.example.win.jobready365;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.win.jobready365.ksw.Adapters.EmpRecycleViewAdapter;
import com.example.win.jobready365.ksw.PojoJavaClasses.Employer;

import java.util.ArrayList;

public class Main4Activity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    private SwipeRefreshLayout swipeContainer;
    private static String LOG_TAG = "Main4Activity";
    private TextView Disconnected;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        //https://guides.codepath.com/android/Implementing-Pull-to-Refresh-Guide
        swipeContainer = (SwipeRefreshLayout) findViewById(R.id.swipeContainer);

        // Configure the refreshing colors
        swipeContainer.setColorSchemeResources(android.R.color.holo_orange_dark);
        swipeContainer.setRefreshing(false);
      //  pd.hide();
        swipeContainer.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
               // loadJSON();


                Toast.makeText(Main4Activity.this, "Jobs List Refreshed.", Toast.LENGTH_SHORT).show();
            }
        });

        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        mRecyclerView.setHasFixedSize(true);

        // mRecyclerView.setAnimation();
        RecyclerView.ItemAnimator itemAnimator = new DefaultItemAnimator();
        itemAnimator.setAddDuration(100);

        itemAnimator.setRemoveDuration(100);
        mRecyclerView.setItemAnimator(itemAnimator);


        mRecyclerView.smoothScrollToPosition(0);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new EmpRecycleViewAdapter(this,Main2Activity.employers);
        mRecyclerView.setAdapter(mAdapter);





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
/*
    @Override
    protected void onResume() {
        super.onResume();
        ((EmpRecycleViewAdapter) mAdapter).setOnItemClickListener(new EmpRecycleViewAdapter
                .MyClickListener() {
            @Override
            public void onItemClick(int position, View v) {
                Log.i(LOG_TAG, " Clicked on Item " + position);
            }
        });
    }

*/ private ArrayList<Employer> getDataSet() {
        ArrayList results = new ArrayList<Employer>();

        for (int index = 0; index < 20; index++) {
            Employer obj = new Employer("Some Primary Text " + index
            );
            results.add(index, obj);
        }
        return results;
    }




}
