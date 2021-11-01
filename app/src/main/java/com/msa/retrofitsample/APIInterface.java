package com.msa.retrofitsample;

import com.google.gson.JsonObject;

import org.json.JSONObject;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;

public interface APIInterface {


    @GET("/posts")
    Call<List<SamplePojo>> callApi();
}
