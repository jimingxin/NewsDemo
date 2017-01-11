package com.jimingxin.newsdemo.images.model;

/**
 * Created by jimingxin on 2016/12/27.
 */

public interface ImageModel {
    void loadImageList(ImageModelImpl.OnLoadImageListListener listener);
}
