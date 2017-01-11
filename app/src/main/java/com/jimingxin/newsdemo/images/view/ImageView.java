package com.jimingxin.newsdemo.images.view;

import com.jimingxin.newsdemo.beans.ImageBean;

import java.util.List;

/**
 * Created by jimingxin on 2016/12/27.
 */

public interface ImageView {
    void addImages(List<ImageBean> list);
    void showProgress();
    void hideProgress();
    void showLoadFailMsg();
}
