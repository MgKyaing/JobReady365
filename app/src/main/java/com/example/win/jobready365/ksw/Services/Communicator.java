package com.example.win.jobready365.ksw.Services;

import android.util.Log;


import com.example.win.jobready365.ksw.PojoJavaClasses.Applicant;
import com.example.win.jobready365.ksw.PojoJavaClasses.Education;
import com.example.win.jobready365.ksw.PojoJavaClasses.Experience;
import com.example.win.jobready365.ksw.PojoJavaClasses.GetResult;
import com.example.win.jobready365.ksw.PojoJavaClasses.Refree;
import com.example.win.jobready365.ksw.PojoJavaClasses.Skill;
import com.example.win.jobready365.ksw.PojoJavaClasses.login;
import com.example.win.jobready365.ksw.Services.Event.ErrorEvent;
import com.example.win.jobready365.ksw.Services.Event.ServerEvent;
import com.squareup.otto.Produce;

import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class Communicator {
    private static  final String TAG = "Communicator";
    private static final String SERVER_URL = "http://goldenictsolutions.com/";

    public void loginPost(String login_name, String password){

        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(logging);

        Retrofit retrofit = new Retrofit.Builder()
                .client(httpClient.build())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(SERVER_URL)
                .build();

        Interface service = retrofit.create(Interface.class);

        //Call<ServerResponse> call = service.post("login",username,password);
            //Call<ServerResponse> call = service.post(username,password);
            Call<ServerResponse> call = service.post(new login(login_name,password));
            //Call<ServerResponse> call = service.post(username,password);
            call.enqueue(new Callback<ServerResponse>() {
                @Override
                public void onResponse(Call<ServerResponse> call, Response<ServerResponse> response) {
                    // response.isSuccessful() is true if the response code is 2xx
                    Log.e(TAG, "Success"+response.code());
                    Log.e(TAG, "Success"+response.body());
                    Log.e(TAG, "Success"+response.message());
                    BusProvider.getInstance().post(new ServerEvent(response.body()));
                    Log.e(TAG, "Success");

                }

                @Override
                public void onFailure(Call<ServerResponse> call, Throwable t) {
                    // handle execution failures like no internet connectivity
                    Log.e(TAG, "Failure "+t.getMessage());
                    BusProvider.getInstance().post(new ErrorEvent(-2, t.getMessage()));
                }
            });
    }

    public void loginGet(String username, String password){

        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(logging);

        Retrofit retrofit = new Retrofit.Builder()
                .client(httpClient.build())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(SERVER_URL)
                .build();

        Interface service = retrofit.create(Interface.class);

        //Call<ServerResponse> call = service.get("login",username,password);
        Call<ServerResponse> call = service.get(username,password);

        call.enqueue(new Callback<ServerResponse>() {
            @Override
            public void onResponse(Call<ServerResponse> call, Response<ServerResponse> response) {
                // response.isSuccessful() is true if the response code is 2xx
                BusProvider.getInstance().post(new ServerEvent(response.body()));
                Log.e(TAG,"Success");
            }

            @Override
            public void onFailure(Call<ServerResponse> call, Throwable t) {
                // handle execution failures like no internet connectivity
                BusProvider.getInstance().post(new ErrorEvent(-2,t.getMessage()));
            }
        });
    }

    public void getResult( String category, String location, String type){

        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(logging);

        Retrofit retrofit = new Retrofit.Builder()
                .client(httpClient.build())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(SERVER_URL)
                .build();

        Interface service = retrofit.create(Interface.class);


        Call<ServerResponse> call = service.postGetResult(new GetResult(category,location,type));

        call.enqueue(new Callback<ServerResponse>() {
            @Override
            public void onResponse(Call<ServerResponse> call, Response<ServerResponse> response) {
                // response.isSuccessful() is true if the response code is 2xx
                Log.e(TAG, "Success"+response.code());
                Log.e(TAG, "Success"+response.body());
               Log.e(TAG, "Success"+response.message());
               BusProvider.getInstance().post(new ServerEvent(response.body()));
                Log.e(TAG, "Success");

            }

            @Override
            public void onFailure(Call<ServerResponse> call, Throwable t) {
                // handle execution failures like no internet connectivity
                Log.e(TAG, "Failure "+t.getMessage());
                BusProvider.getInstance().post(new ErrorEvent(-2, t.getMessage()));
            }
        });
    }

    public void createApplicant(String userId, String firstName, String lastName,
                                String maritalStatus, String gender, String dateOfBirth,
                                String mobileNo, String email, String address, String township,
                                String postalCode, String city, String country, List<Education> educationList,
                                List<Skill> skillList, List<Experience> experienceList,
                                List<Refree> refreeList){

        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(logging);

        Retrofit retrofit = new Retrofit.Builder()
                .client(httpClient.build())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(SERVER_URL)
                .build();

        Interface service = retrofit.create(Interface.class);


        Call<ServerResponse> call = service.createApplicant(new Applicant(userId,firstName,lastName,maritalStatus,
                gender,dateOfBirth,mobileNo,email,address,township,postalCode,city,country,educationList,skillList,
                experienceList,refreeList));

        call.enqueue(new Callback<ServerResponse>() {
            @Override
            public void onResponse(Call<ServerResponse> call, Response<ServerResponse> response) {
                // response.isSuccessful() is true if the response code is 2xx
                Log.e(TAG, "Success"+response.code());

                Log.e(TAG, "Success"+response.body());
                Log.e(TAG, "Success"+response.message());
                BusProvider.getInstance().post(new ServerEvent(response.body()));
                Log.e(TAG, "Success");

            }

            @Override
            public void onFailure(Call<ServerResponse> call, Throwable t) {
                // handle execution failures like no internet connectivity
                Log.e(TAG, "Failure "+t.getMessage());
                BusProvider.getInstance().post(new ErrorEvent(-2, t.getMessage()));
            }
        });
    }

    public void getApplicant(String userId, String api_key){

        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(logging);

        Retrofit retrofit = new Retrofit.Builder()
                .client(httpClient.build())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(SERVER_URL)
                .build();

        Interface service = retrofit.create(Interface.class);


        Call<ServerResponse> call = service.getApplicant(userId,api_key);

        call.enqueue(new Callback<ServerResponse>() {
            @Override
            public void onResponse(Call<ServerResponse> call, Response<ServerResponse> response) {
                // response.isSuccessful() is true if the response code is 2xx
                Log.e(TAG, "Success"+response.code());

                Log.e(TAG, "Success"+response.body());
                Log.e(TAG, "Success"+response.message());
                BusProvider.getInstance().post(new ServerEvent(response.body()));
                Log.e(TAG, "Success");

            }

            @Override
            public void onFailure(Call<ServerResponse> call, Throwable t) {
                // handle execution failures like no internet connectivity
                Log.e(TAG, "Failure "+t.getMessage());
                BusProvider.getInstance().post(new ErrorEvent(-2, t.getMessage()));
            }
        });
    }

    public void insertSkill(String userId,String  skillType,String skillLevel, String token){

        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(logging);

        Retrofit retrofit = new Retrofit.Builder()
                .client(httpClient.build())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(SERVER_URL)
                .build();

        Interface service = retrofit.create(Interface.class);


        Call<ServerResponse> call = service.insertSkill(new Skill(userId,skillType,skillLevel),token);

        call.enqueue(new Callback<ServerResponse>() {
            @Override
            public void onResponse(Call<ServerResponse> call, Response<ServerResponse> response) {
                // response.isSuccessful() is true if the response code is 2xx
                Log.e(TAG, "Success"+response.code());

                Log.e(TAG, "Success"+response.body());
                Log.e(TAG, "Success"+response.message());
                BusProvider.getInstance().post(new ServerEvent(response.body()));
                Log.e(TAG, "Success");

            }

            @Override
            public void onFailure(Call<ServerResponse> call, Throwable t) {
                // handle execution failures like no internet connectivity
                Log.e(TAG, "Failure "+t.getMessage());
                BusProvider.getInstance().post(new ErrorEvent(-2, t.getMessage()));
            }
        });
    }

    public void insertExperience(String userId,String expOrganization,String expRank, String expStartDate, String expEndDate, String token){

        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(logging);

        Retrofit retrofit = new Retrofit.Builder()
                .client(httpClient.build())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(SERVER_URL)
                .build();

        Interface service = retrofit.create(Interface.class);


        Call<ServerResponse> call = service.insertExperience(new Experience(userId,expOrganization,expRank,expStartDate,expEndDate),token);

        call.enqueue(new Callback<ServerResponse>() {
            @Override
            public void onResponse(Call<ServerResponse> call, Response<ServerResponse> response) {
                // response.isSuccessful() is true if the response code is 2xx
                Log.e(TAG, "Success"+response.code());

                Log.e(TAG, "Success"+response.body());
                Log.e(TAG, "Success"+response.message());
                BusProvider.getInstance().post(new ServerEvent(response.body()));
                Log.e(TAG, "Success");

            }

            @Override
            public void onFailure(Call<ServerResponse> call, Throwable t) {
                // handle execution failures like no internet connectivity
                Log.e(TAG, "Failure "+t.getMessage());
                BusProvider.getInstance().post(new ErrorEvent(-2, t.getMessage()));
            }
        });
    }

    public void insertEducation(String userId,String university,String degree, String year,String token){

        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(logging);

        Retrofit retrofit = new Retrofit.Builder()
                .client(httpClient.build())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(SERVER_URL)
                .build();

        Interface service = retrofit.create(Interface.class);


        Call<ServerResponse> call = service.insertEducation(new Education(userId,university,degree,year),token);

        call.enqueue(new Callback<ServerResponse>() {
            @Override
            public void onResponse(Call<ServerResponse> call, Response<ServerResponse> response) {
                // response.isSuccessful() is true if the response code is 2xx
                Log.e(TAG, "Success"+response.code());

                Log.e(TAG, "Success"+response.body());
                Log.e(TAG, "Success"+response.message());
                BusProvider.getInstance().post(new ServerEvent(response.body()));
                Log.e(TAG, "Success");

            }

            @Override
            public void onFailure(Call<ServerResponse> call, Throwable t) {
                // handle execution failures like no internet connectivity
                Log.e(TAG, "Failure "+t.getMessage());
                BusProvider.getInstance().post(new ErrorEvent(-2, t.getMessage()));
            }
        });
    }

    public void insertReferee(String userId,String firstName,String lastName, String organization,
                              String rank, String mobileNo, String email, String token){

        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(logging);

        Retrofit retrofit = new Retrofit.Builder()
                .client(httpClient.build())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(SERVER_URL)
                .build();

        Interface service = retrofit.create(Interface.class);


        Call<ServerResponse> call = service.insertReferee(new Refree(userId,firstName,lastName,organization,rank,mobileNo,email),token);

        call.enqueue(new Callback<ServerResponse>() {
            @Override
            public void onResponse(Call<ServerResponse> call, Response<ServerResponse> response) {
                // response.isSuccessful() is true if the response code is 2xx
                Log.e(TAG, "Success"+response.code());

                Log.e(TAG, "Success"+response.body());
                Log.e(TAG, "Success"+response.message());
                BusProvider.getInstance().post(new ServerEvent(response.body()));
                Log.e(TAG, "Success");

            }

            @Override
            public void onFailure(Call<ServerResponse> call, Throwable t) {
                // handle execution failures like no internet connectivity
                Log.e(TAG, "Failure "+t.getMessage());
                BusProvider.getInstance().post(new ErrorEvent(-2, t.getMessage()));
            }
        });
    }



    @Produce
    public ServerEvent produceServerEvent(ServerResponse serverResponse) {
        return new ServerEvent(serverResponse);
    }

    @Produce
    public ErrorEvent produceErrorEvent(int errorCode, String errorMsg) {
        return new ErrorEvent(errorCode, errorMsg);
    }
}
