package com.example.win.jobready365.ksw.Services;

import com.example.win.jobready365.ksw.PojoJavaClasses.Applicant;
import com.example.win.jobready365.ksw.PojoJavaClasses.Education;
import com.example.win.jobready365.ksw.PojoJavaClasses.Experience;
import com.example.win.jobready365.ksw.PojoJavaClasses.GetResult;
import com.example.win.jobready365.ksw.PojoJavaClasses.Refree;
import com.example.win.jobready365.ksw.PojoJavaClasses.Skill;
import com.example.win.jobready365.ksw.PojoJavaClasses.login;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface Interface {
    @Headers({
            "Accept: application/json",
           "Content-Type: application/json",
           //  "Authorization: Basic ZWlwaHl1cGh5dWhsYWluZ0BnbWFpbC5jb206MTIzNDU2Nzg="
    })
    //@FormUrlEncoded
    @POST("/api/login")
    //Call<ServerResponse> post(@Body @Root("email") String email,@Root("password") String password);
    Call<ServerResponse> post(@Body login body);
    //Call<ServerResponse> post(@Body login login);
   /* Call<ServerResponse> post(
            //@Field("method") String method,
            @Field("email") String username,
            @Field("password") String password
    );*/

    @POST("/api/getResult")
        //Call<ServerResponse> post(@Body @Root("email") String email,@Root("password") String password);
    Call<ServerResponse> postGetResult(@Body GetResult body );
    //Call<ServerResponse> post(@Body login login);
   /* Call<ServerResponse> post(
            //@Field("method") String method,
            @Field("email") String username,
            @Field("password") String password
    );*/

//    @GET("/api/jobcat")
 //   Call<ServerResponse> getJobcat(@Query("token"), @Path("JobCategory"));

 //   @GET("/api/location")
//    Call<ServerResponse> getJobLocation(@Query("token"),@Path("city"));

 //   @GET("/api/type")
 //   Call<ServerResponse> getJobtype(@Query("token"),@Path("Jobtype"));

 //   @GET("/api/type")
 //   Call<ServerResponse> getJobtype(@Query("token"),@Path("Jobtype"));



    @GET("/api/login")
    Call<ServerResponse> get(// @Query("method") String method
                             @Query("login_name") String username,
                             @Query("password") String password
    );

  //  @POST("/api/getResult")
  //  Call<ServerResponse> getResult(@Query("") String);

    @POST("/api/jobseeker")
    Call<ServerResponse> createApplicant(@Body Applicant body);

    @GET("/api/jobseeker/{user_id}")
    Call<ServerResponse> getApplicant(@Path("user_id") String userId , @Query("token") String apiKey);

    @POST("/api/skill")
    Call<ServerResponse> insertSkill(@Body Skill body, @Query("token") String token);

    @POST("/api/experience")
    Call<ServerResponse> insertExperience(@Body Experience body, @Query("token") String token);

    @POST("/api/education")
    Call<ServerResponse> insertEducation(@Body Education body,@Query("token") String token);

    @POST("/api/refree")
    Call<ServerResponse> insertReferee(@Body Refree body,@Query("token") String token);


}