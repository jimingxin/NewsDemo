package com.jimingxin.newsdemo.images.model;

import com.jimingxin.newsdemo.beans.ImageBean;
import com.jimingxin.newsdemo.commons.Urls;
import com.jimingxin.newsdemo.images.utils.ImageJsonUtils;
import com.jimingxin.newsdemo.utils.OkHttpUtils;

import java.util.List;

/**
 * Description :
 * Author : lauren
 * Email  : lauren.liuling@gmail.com
 * Blog   : http://www.liuling123.com
 * Date   : 15/12/22
 */
public class ImageModelImpl implements ImageModel {

    /**
     * 获取图片列表
     * @param listener
     */
    @Override
    public void loadImageList(final OnLoadImageListListener listener) {
        String url = Urls.IMAGES_URL;
        OkHttpUtils.ResultCallback<String> loadNewsCallback = new OkHttpUtils.ResultCallback<String>() {
            @Override
            public void onSuccess(String response) {
                List<ImageBean> iamgeBeanList = ImageJsonUtils.readJsonImageBeans(response);
                listener.onSuccess(iamgeBeanList);
            }

            @Override
            public void onFailure(Exception e) {
                listener.onFailure("load image list failure.", e);
            }
        };
        OkHttpUtils.get(url, loadNewsCallback);
    }

    public interface OnLoadImageListListener {
        void onSuccess(List<ImageBean> list);
        void onFailure(String msg, Exception e);
    }
}
