package com.jimingxin.newsdemo.main.presenter;

import com.jimingxin.newsdemo.R;
import com.jimingxin.newsdemo.main.view.MainView;

/**
 * Created by jimingxin on 2016/12/19.
 */

public class MainPresenterImpl implements MainPresenter {


    private MainView mMainVie;

    public MainPresenterImpl(MainView mMainVie) {
        this.mMainVie = mMainVie;
    }

    @Override
    public void switchNavigation(int id) {

        switch (id){
            case R.id.navigation_item_news:
                mMainVie.switch2News();
                break;
            case R.id.navigation_item_images:
                mMainVie.switch2Images();
                break;
            case R.id.navigation_item_weather:
                mMainVie.switch2Weather();
                break;
            case R.id.navigation_item_about:
                mMainVie.switch2Ablout();
                break;

        }

    }
}
