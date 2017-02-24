package com.example.win.jobready365;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.win.jobready365.ksw.PojoJavaClasses.User;
import com.example.win.jobready365.ksw.Services.BusProvider;
import com.example.win.jobready365.ksw.Services.Communicator;
import com.example.win.jobready365.ksw.Services.Event.ErrorEvent;
import com.example.win.jobready365.ksw.Services.Event.ServerEvent;
import com.squareup.otto.Subscribe;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;


import com.example.win.jobready365.ksw.Language.LanguageHandler;
import com.example.win.jobready365.ksw.Services.*;

import java.util.List;

public class MainActivity5 extends AppCompatActivity {
    ProgressDialog progressDialog;
    private Communicator communicator;
    private String username, password;
    private EditText usernameET, passwordET;
    private Button loginButtonPost, loginButtonGet, bottonMm, bottonEng ;
    static String token;
     static String userId;
    Animation animation;

    private TextView information, extraInformation;
    static User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        communicator = new Communicator();

        usernameET = (EditText) findViewById(R.id.usernameInput);
        passwordET = (EditText) findViewById(R.id.passwordInput);

        bottonEng = (Button) findViewById(R.id.btn_eng);
        bottonMm = (Button) findViewById(R.id.btn_mm);

     //   View v = (View)findViewById( R.id.content_main);
     //   animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.myanimation);
      //  v.startAnimation(animation);


        // flashing the background color
/*
        ValueAnimator skyAnim = ObjectAnimator.ofInt
                (findViewById(R.id.loginButtonPost), "backgroundColor",
                        Color.rgb(250,240,230), Color.rgb(100,255,100));
        skyAnim.setDuration(3000);
        skyAnim.setRepeatCount(ValueAnimator.REVERSE);
        skyAnim.setRepeatMode(ValueAnimator.REVERSE);
        skyAnim.setEvaluator(new ArgbEvaluator());
        skyAnim.start();
*/








        bottonMm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                LanguageHandler.changeLocale(getResources(), "my");
                restartActivity();

                overridePendingTransition(R.anim.move,R.anim.fade_out);



            }
        });

        bottonEng.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // LanguageHandler.changeLocale(getResources(), "en");
               // restartActivity();

               // overridePendingTransition(R.anim.move,R.anim.fade_out);

                Intent intent = new Intent(MainActivity5.this,ProfileActivity.class);
                startActivity(intent);


            }
        });

        loginButtonPost = (Button) findViewById(R.id.loginButtonPost);

        loginButtonPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                username = usernameET.getText().toString();
                password = passwordET.getText().toString();
                if ((!(username.isEmpty()) & (!password.isEmpty()))) {
                    usePost(username, password);
                } else if (username.isEmpty() & password.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Enter your username and password again", Toast.LENGTH_SHORT).show();
                } else if (username.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Enter your username again", Toast.LENGTH_SHORT).show();
                } else if (password.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Enter your password again", Toast.LENGTH_SHORT).show();
                }

                progressDialog = new ProgressDialog(MainActivity5.this);
                progressDialog.setMessage("logging in ...");
                progressDialog.setCancelable(false);
                progressDialog.show();

            }
        });
/*
        loginButtonGet = (Button) findViewById(R.id.loginButtonGet);
        loginButtonGet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                username = usernameET.getText().toString();
                password = passwordET.getText().toString();
                useGet(username, password);
            }
        });
*/
        // information = (TextView) findViewById(R.id.information);
        //   extraInformation = (TextView) findViewById(R.id.extraInformation);

       /* bus = new Bus(ThreadEnforcer.MAIN);
        bus.register(this);*/

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

    private void restartActivity() {
        Intent intent = getIntent();
        finish();
        startActivity(intent);
    }


    private void usePost(String username, String password) {
        communicator.loginPost(username, password);
    }

    private void useGet(String username, String password) {
        communicator.loginGet(username, password);
    }




    @Subscribe
    public void onServerEvent(ServerEvent serverEvent) {
        progressDialog.hide();
        //  Intent intent = new Intent(MainActivity5.this,Main2Activity.class);
        //  startActivity(intent);

        // Toast.makeText(getApplicationContext(), "onServerEvent sucess " + serverEvent.getServerResponse().getToken(), Toast.LENGTH_SHORT).show();
        if (serverEvent.getServerResponse() == null) {
            Toast.makeText(getApplicationContext(), "Invalid credentials", Toast.LENGTH_SHORT).show();

        }

         else if (serverEvent.getServerResponse().getUserList() != null) {
            List<User> userList = serverEvent.getServerResponse().getUserList();
           user = userList.get(0);
            userId= user.getId();

            Toast.makeText(getApplicationContext(), "onServerEvent success " + userId, Toast.LENGTH_SHORT).show();
            token = serverEvent.getServerResponse().getToken();

               Intent intent = new Intent(MainActivity5.this,Main3Activity.class);
              intent.putExtra("TOKEN",token);

             startActivity(intent);
            overridePendingTransition(R.anim.move,R.anim.fade_in);
/*
               }else if (serverEvent.getServerResponse().getToken() != null) {
            Intent intent = new Intent(MainActivity5.this, Main2Activity.class);
            intent.putExtra("TOKEN", token);

            startActivity(intent);

*/
     /*   if (serverEvent.getServerResponse().getToken() != null) {
            information.setText("Username: " + serverEvent.getServerResponse().getUsername() + " || Password: " + serverEvent.getServerResponse().getPassword());
        }
        extraInformation.setText("" + serverEvent.getServerResponse().getMessage());  */
        }}

        @Subscribe
        public void onErrorEvent (ErrorEvent errorEvent){
            Toast.makeText(this, "onErrorEvent fail " + errorEvent.getErrorMsg(), Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onResume () {
            super.onResume();
            BusProvider.getInstance().register(this);
        }

        @Override
        public void onPause () {
            super.onPause();
            BusProvider.getInstance().unregister(this);
        }

        @Override
        public boolean onCreateOptionsMenu (Menu menu){
            // Inflate the menu; this adds items to the action bar if it is present.
            getMenuInflater().inflate(R.menu.menu_main, menu);
            return true;
        }

        @Override
        public boolean onOptionsItemSelected (MenuItem item){
            // Handle action bar item clicks here. The action bar will
            // automatically handle clicks on the Home/Up button, so long
            // as you specify a parent activity in AndroidManifest.xml.
            int id = item.getItemId();

            //noinspection SimplifiableIfStatement
            if (id == R.id.action_settings) {
                return true;
            }

            return super.onOptionsItemSelected(item);
        }

    //animation functions
    public void clockwise(View view){
        ImageView image = (ImageView)findViewById(R.id.imageView);
        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.clockwise);
        image.startAnimation(animation);
    }

    public void zoom(View view){
        ImageView image = (ImageView)findViewById(R.id.imageView);
        Animation animation1 = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.clockwise);
        image.startAnimation(animation1);
    }

    public void fade(View view){
        ImageView image = (ImageView)findViewById(R.id.imageView);
        Animation animation1 =
                AnimationUtils.loadAnimation(getApplicationContext(),
                        R.anim.fade);
        image.startAnimation(animation1);
    }

    public void blink(View view){
        ImageView image = (ImageView)findViewById(R.id.imageView);
        Animation animation1 =
                AnimationUtils.loadAnimation(getApplicationContext(),
                        R.anim.blink);
        image.startAnimation(animation1);
    }

    public void move(View view){
        ImageView image = (ImageView)findViewById(R.id.imageView);
        Animation animation1 =
                AnimationUtils.loadAnimation(getApplicationContext(), R.anim.move);
        image.startAnimation(animation1);
    }


    public void slide(View view){
        ImageView image = (ImageView)findViewById(R.id.imageView);
        Animation animation1 =
                AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide);
        image.startAnimation(animation1);
    }
    public void sequential(View view){
        ImageView image = (ImageView)findViewById(R.id.imageView);
        Animation animation1 =
                AnimationUtils.loadAnimation(getApplicationContext(), R.anim.sequential);
        image.startAnimation(animation1);
    }

    public void together(View view){
        ImageView image = (ImageView)findViewById(R.id.imageView);
        Animation animation1 =
                AnimationUtils.loadAnimation(getApplicationContext(), R.anim.together);
        image.startAnimation(animation1);
        image.clearColorFilter();

    }

    public void slideDown(View view){
        ImageView image = (ImageView)findViewById(R.id.imageView);
        Animation animation1 =
                AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_down);
        image.startAnimation(animation1);

    }




}
