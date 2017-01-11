package com.jimingxin.newsdemo.news.view;

import com.jimingxin.newsdemo.beans.NewsBean;

import java.util.List;

/**
 * Created by jimingxin on 2016/12/20.
 */

public interface NewsView {

    void showProgress();

    void addNews(List<NewsBean> newsList);

    void hideProgress();

    void showLoadFailMsg();

}
