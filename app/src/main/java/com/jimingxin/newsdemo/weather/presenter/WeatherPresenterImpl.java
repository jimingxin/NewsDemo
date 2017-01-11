package com.jimingxin.newsdemo.weather.presenter;

import android.content.Context;

import com.jimingxin.newsdemo.beans.WeatherBean;
import com.jimingxin.newsdemo.utils.ToolsUtil;
import com.jimingxin.newsdemo.weather.WeatherView;
import com.jimingxin.newsdemo.weather.model.WeatherModel;
import com.jimingxin.newsdemo.weather.model.WeatherModelImpl;

import java.util.List;

/**
 * Created by jimingxin on 2016/12/29.
 */

public class WeatherPresenterImpl implements WeatherPresenter,WeatherModelImpl.LoadWeatherListener{

    private WeatherView mWeatherView;
    private WeatherModel mWeatherModel;
    private Context mContext;

    public WeatherPresenterImpl( Context mContext,WeatherView mWeatherView) {
        this.mWeatherView = mWeatherView;
        this.mContext = mContext;
        mWeatherModel = new WeatherModelImpl();
    }

    @Override
    public void loadWeatherData() {
        mWeatherView.showProgress();
        if (!ToolsUtil.isNetworkAvailable(mContext)) {
            mWeatherView.hideProgress();
            mWeatherView.showErrorToast("无网络连接");
            return;
        }

        WeatherModelImpl.LoadLocationListener listener = new WeatherModelImpl.LoadLocationListener() {
            @Override
            public void onSuccess(String cityName) {
                //定位成功，获取定位城市天气预报
                mWeatherView.setCity(cityName);
                mWeatherModel.loadWeatherData(cityName,WeatherPresenterImpl.this);
            }

            @Override
            public void onFailure(String msg, Exception e) {
                mWeatherView.showErrorToast("定位失败");
                mWeatherView.setCity("深圳");
                mWeatherModel.loadWeatherData("深圳",WeatherPresenterImpl.this);
            }
        };

        //获取定位信息
        mWeatherModel.loadLocation(mContext,listener);
    }

    @Override
    public void onSuccess(List<WeatherBean> list) {
        if(list != null && list.size() > 0) {
            WeatherBean todayWeather = list.remove(0);
            mWeatherView.setToday(todayWeather.getDate());
            mWeatherView.setTemperature(todayWeather.getTemperature());
            mWeatherView.setWeather(todayWeather.getWeather());
            mWeatherView.setWind(todayWeather.getWind());
            mWeatherView.setWeatherImage(todayWeather.getImageRes());
        }
        mWeatherView.setweatherData(list);
        mWeatherView.hideProgress();
        mWeatherView.showWeatherLayout();
    }

    @Override
    public void onFailure(String msg, Exception e) {
        mWeatherView.hideProgress();
        mWeatherView.showErrorToast("获取天气数据失败");
    }
}
