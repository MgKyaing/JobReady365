package com.example.win.jobready365;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.Toast;
import com.example.win.jobready365.ksw.PojoJavaClasses.*;
import com.example.win.jobready365.ksw.PojoJavaClasses.Employer;
import com.example.win.jobready365.ksw.Services.BusProvider;
import com.example.win.jobready365.ksw.Services.Communicator;
import com.example.win.jobready365.ksw.Services.Event.ErrorEvent;
import com.example.win.jobready365.ksw.Services.Event.ServerEvent;
import com.squareup.otto.Subscribe;
import java.util.ArrayList;
import static com.example.win.jobready365.ksw.RawData.DataSet.allJobcategory;
import static com.example.win.jobready365.ksw.RawData.DataSet.city_div;
import static com.example.win.jobready365.ksw.RawData.DataSet.contractType;

public class Main2Activity extends AppCompatActivity {
    Button button;
    ProgressDialog progressDialog;
    AutoCompleteTextView autoCompleteTextView1,autoCompleteTextView2,autoCompleteTextView3;
    private Communicator communicator;
   public static ArrayList<Employer> employers;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        communicator = new Communicator();
        setContentView(R.layout.activity_main2);
        button =(Button)findViewById(R.id.btn_search_jobs);
        autoCompleteTextView1 = (AutoCompleteTextView) findViewById(R.id.autoCompleteTextView_category);
        autoCompleteTextView2 = (AutoCompleteTextView) findViewById(R.id.autoCompleteTextView_location);
        autoCompleteTextView3 = (AutoCompleteTextView) findViewById(R.id.autoCompleteTextView_type);


        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, allJobcategory);
        autoCompleteTextView1.setAdapter(adapter);
        autoCompleteTextView1.setThreshold(1);

        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, city_div);
        autoCompleteTextView2.setAdapter(adapter1);
        autoCompleteTextView2.setThreshold(1);

        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, contractType);
        autoCompleteTextView3.setAdapter(adapter2);
        autoCompleteTextView3.setThreshold(1);

        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
              //  Intent intent = new Intent(Main2Activity.this,Main3Activity.class);
              //  startActivity(intent);
                progressDialog = new ProgressDialog(Main2Activity.this);
                progressDialog.setMessage("Fetching Jobs...");
                progressDialog.setCancelable(false);
                progressDialog.show();
                String category = (autoCompleteTextView1.getText().toString());
                String location = (autoCompleteTextView2.getText().toString());
                String type = (autoCompleteTextView3.getText().toString());
                useGetResult(category,location,type);




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
          employers =  serverEvent.getServerResponse().getEmployerList();
     //   String path = employers.get(0).getLogo();
         //   Toast.makeText(getApplicationContext(),"bla"+path,Toast.LENGTH_LONG).show();
          progressDialog.hide();

          Intent intent = new Intent(Main2Activity.this,Main4Activity.class);
           startActivity(intent);
        }
    }
    @Subscribe
    public void onErrorEvent(ErrorEvent errorEvent) {
        progressDialog.hide();
        Toast.makeText(this, "onErrorEvent fail " + errorEvent.getErrorMsg(), Toast.LENGTH_SHORT).show();
        Dialog dia = new Dialog(Main2Activity.this);
        dia.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dia.setContentView(R.layout.error_alert_dialog);
        dia.setTitle("this is a custom dialog");
        dia.show();
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
}
