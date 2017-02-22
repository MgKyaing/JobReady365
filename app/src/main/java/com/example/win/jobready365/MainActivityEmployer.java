package com.example.win.jobready365;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.win.jobready365.znk.Authentication.LoginActivity;
import com.example.win.jobready365.znk.Authentication.LoginActivity;

public class MainActivityEmployer extends AppCompatActivity {
    private  Button gotologin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_employer);
        gotologin=(Button)findViewById(R.id.button_to_next);
        gotologin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(MainActivityEmployer.this,LoginActivity.class);
                startActivity(intent);
            }
        });
    }
}
