package com.msa.retrofitsample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    List<SamplePojo>samplePojoList;
    SampleAdapter sampleAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recycler_view);

        recyclerView.setHasFixedSize(true);
        samplePojoList = new ArrayList<>();

        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        APIInterface apiInterface = RestAPIClient.getClient().create(APIInterface.class);

        apiInterface.callApi().enqueue(new Callback<List<SamplePojo>>() {
            @Override
            public void onResponse(Call<List<SamplePojo>> call, Response<List<SamplePojo>> response) {
                samplePojoList = response.body();
                sampleAdapter = new SampleAdapter(getApplicationContext(),samplePojoList);
                recyclerView.setAdapter(sampleAdapter);
                //Log.e("MainActivity", String.valueOf(samplePojoList.get(0)));
            }

            @Override
            public void onFailure(Call<List<SamplePojo>> call, Throwable t) {

                Log.e("MainActivity",t.getMessage());
            }
        });


    }

    private JsonObject myJSON(){
        JsonRequestPojo jsonRequestPojo = new JsonRequestPojo();
        jsonRequestPojo.setPosts("posts");

        return new Gson().toJsonTree(jsonRequestPojo).getAsJsonObject();
    }


}