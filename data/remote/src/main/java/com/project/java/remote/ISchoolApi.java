package com.project.java.remote;

import com.project.java.models.SATScores;
import com.project.java.models.SchoolDirectory;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

public interface ISchoolApi {
    @Headers({"Content-Type: application/json"})
    @GET("resource/s3k6-pzi2.json")
    Observable<Response<List<SchoolDirectory>>> getListOfSchools(@Query("$limit") int limit);
    @Headers({"Content-Type: application/json"})
    @GET("resource/f9bf-2cp4.json")
    Observable<Response<List<SATScores>>> getSATScores(@Query("$q") String id);
}
