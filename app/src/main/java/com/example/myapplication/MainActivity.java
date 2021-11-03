package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
public class MainActivity extends AppCompatActivity {
    APIInterface apiInterface;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        apiInterface = APIClient.getClient().create(APIInterface.class);
        Call<com.example.myapplication.Response> call = apiInterface.login();
        call.enqueue(new Callback<com.example.myapplication.Response>() {
            @Override
            public void onResponse(Call<com.example.myapplication.Response> call, Response<com.example.myapplication.Response> response) {
                Log.d("TAG",response.code()+"");

            }

            @Override
            public void onFailure(Call<com.example.myapplication.Response> call, Throwable t) {
                call.cancel();
            }
        });
    }
}