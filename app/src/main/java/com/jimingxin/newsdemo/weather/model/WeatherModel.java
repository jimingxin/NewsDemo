package com.jimingxin.newsdemo.weather.model;

import android.content.Context;

/**
 * Created by jimingxin on 2016/12/29.
 */

public interface WeatherModel {

    void loadWeatherData(String cityName,WeatherModelImpl.LoadWeatherListener listener);
    void loadLocation(Context context, WeatherModelImpl.LoadLocationListener listener);
}
