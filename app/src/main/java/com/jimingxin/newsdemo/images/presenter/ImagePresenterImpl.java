package com.jimingxin.newsdemo.images.presenter;


import com.jimingxin.newsdemo.beans.ImageBean;
import com.jimingxin.newsdemo.images.model.ImageModel;
import com.jimingxin.newsdemo.images.model.ImageModelImpl;
import com.jimingxin.newsdemo.images.view.ImageView;

import java.util.List;

/**
 * Created by jimingxin on 2016/12/27.
 */

public class ImagePresenterImpl implements ImagePresenter,ImageModelImpl.OnLoadImageListListener {

    private ImageModel mImageModel;
    private ImageView mImageView;

    public ImagePresenterImpl(ImageView imageView) {
        this.mImageModel = new ImageModelImpl();
        this.mImageView = imageView;
    }


    @Override
    public void loadImageList() {
        mImageView.showProgress();
        mImageModel.loadImageList(this);
    }

    @Override
    public void onSuccess(List<ImageBean> list) {
        mImageView.addImages(list);
        mImageView.hideProgress();
    }

    @Override
    public void onFailure(String msg, Exception e) {
        mImageView.hideProgress();
        mImageView.showLoadFailMsg();
    }
}
