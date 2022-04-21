package com.mirzahansuslu.weatherapp.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.icu.text.AlphabeticIndex;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.mirzahansuslu.weatherapp.R;

public class MainActivity extends Activity {
    private EditText city_input_edit_Text;
    private Button showSavedDataBtn;
    private Button showDataBtn;
    private String cityName;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        city_input_edit_Text = findViewById(R.id.city_input_edit_Text);
        showSavedDataBtn = findViewById(R.id.showSavedDataBtn);
        showDataBtn = findViewById(R.id.showDataBtn);
        showSavedDataBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navigateRecordedWeatherActivity();
            }
        });
        showDataBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                saveCityNameToLocalDataSource(city_input_edit_Text.getText().toString());
                navigateWeatherListActivity();
            }
        });
         cityName = getCityNameFromLocalDataSource();

        if (cityName.length() > 0) {
            navigateWeatherListActivity();

        }
    }
    private void navigateRecordedWeatherActivity () {
        Intent recordedWeatherIntent = new Intent(MainActivity.this, RecordedWeatherActivity.class);
    startActivity(recordedWeatherIntent);
    }
    private void saveCityNameToLocalDataSource(String cityName) {
        // Validation
        // cityName bilgisini local data source save
        String CONST_DATA = "CITY_NAME";
        SharedPreferences preferences = this.getSharedPreferences(CONST_DATA, getApplicationContext().MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(CONST_DATA,String.valueOf(cityName));
        editor.apply();
    }
    private String getCityNameFromLocalDataSource() {
        String result;
String CONST_DATA = "CITY_NAME";
SharedPreferences preferences= this.getSharedPreferences(CONST_DATA,getApplicationContext().MODE_PRIVATE);
result = preferences.getString(CONST_DATA,"");
        return result;

    }
    private void navigateWeatherListActivity() {
        Intent weatherListIntent = new Intent(MainActivity.this,WeatherListActivity.class);
        weatherListIntent.putExtra("city_name", cityName);
        startActivity(weatherListIntent);

    }



}