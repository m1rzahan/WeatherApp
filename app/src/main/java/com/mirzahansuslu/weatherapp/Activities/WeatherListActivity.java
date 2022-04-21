package com.mirzahansuslu.weatherapp.Activities;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.mirzahansuslu.weatherapp.R;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class WeatherListActivity extends AppCompatActivity {
    private String cityName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather_list);

        // sehir ismi bilgisini Bundle ile al
        Bundle bundle = getIntent().getExtras();
        cityName ="";
        if(bundle!=null) {
            cityName = bundle.getString("city_name");
        }
        getWeatherListFromNetwork();


        //networkten  data al
        // recycler view içerinde data göster

    }
    private  void getWeatherListFromNetwork() {
        String APIKEY = "put your api key";
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        Request request = new Request.Builder()
                .url("https://api.collectapi.com/weather/getWeather?data.lang=tr&data.city=ankara")
                .method("GET", null)
                .addHeader("authorization", APIKEY)
                .addHeader("content-type", "application/json")
                .build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {
                Log.d(TAG, "onFailure: ");

            }

            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
            if(response.isSuccessful()) {
                final String responseBody = response.body().string();


            }
            }
        });
    }
}