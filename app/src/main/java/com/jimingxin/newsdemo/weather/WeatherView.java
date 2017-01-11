package com.jimingxin.newsdemo.weather;

import com.jimingxin.newsdemo.beans.WeatherBean;

import java.util.List;

/**
 * Created by jimingxin on 2016/12/29.
 */

public interface WeatherView {

    void showProgress();
    void hideProgress();
    void showWeatherLayout();

    void setCity(String city);
    void setToday(String data);
    void setTemperature(String temperature);
    void setWind(String wind);
    void setWeather(String weather);
    void setWeatherImage(int res);
    void setweatherData(List<WeatherBean> lists);

    void showErrorToast(String msg);

}
