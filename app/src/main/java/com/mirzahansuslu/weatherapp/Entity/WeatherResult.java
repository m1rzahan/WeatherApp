

        package com.mirzahansuslu.weatherapp.Entity; ;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;



public class WeatherResult {
    public WeatherResult() {
    }

    @SerializedName("success")
    @Expose
    private Boolean success;
    @SerializedName("city")
    @Expose
    private String city;
    @SerializedName("result")
    @Expose
    private List<Result> result = null;

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public List<Result> getResult() {
        return result;
    }

    public void setResult(List<Result> result) {
        this.result = result;
    }

}