package com.jimingxin.newsdemo.images.utils;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.jimingxin.newsdemo.beans.ImageBean;
import com.jimingxin.newsdemo.utils.JsonUtils;
import com.jimingxin.newsdemo.utils.LogUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jimingxin on 2016/12/26.
 */

public class ImageJsonUtils {

    private final static String TAG = "ImageJsonUtils";

    public static List<ImageBean> readJsonImageBeans(String res){
        List<ImageBean> beans = new ArrayList<ImageBean>();

        try {
            JsonParser parser = new JsonParser();
            JsonArray jsonArray = parser.parse(res).getAsJsonArray();
            for (int i = 1; i < jsonArray.size();i++){

                JsonObject jo = jsonArray.get(i).getAsJsonObject();
                ImageBean news = JsonUtils.deserialize(jo,ImageBean.class);
                beans.add(news);
            }
        }catch (Exception e){

            LogUtils.e(TAG,"readJsonImageBeans error", e);
        }
        return beans;
    }

}
