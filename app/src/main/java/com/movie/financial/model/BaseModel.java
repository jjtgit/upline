package com.movie.financial.model;



import com.movie.financial.contact.BaseContract;
import com.movie.financial.net.OKHttpCallback;
import com.movie.financial.net.RequestCallback;
import com.movie.financial.utils.OkHttpUtils;

import java.util.HashMap;

import okhttp3.MultipartBody;


public class BaseModel implements BaseContract.IBaseModel {

    @Override
    public void doGet(String apiUrl, HashMap<String, Object> params, final RequestCallback requestCallback) {
        OkHttpUtils.getInstance().doGet(apiUrl, params, new OKHttpCallback() {
            @Override
            public void onFailUre(String msg) {
                if (requestCallback!=null){
                    requestCallback.onFailUre("网络异常，请稍后再试");
                }
            }

            @Override
            public void onSuccess(String result) {
                if (requestCallback!=null){
                    requestCallback.onSuccess(result);
                }
            }
        });
    }

    @Override
    public void doPost(String apiUrl, HashMap<String, Object> params, final RequestCallback requestCallback) {
        OkHttpUtils.getInstance().doPost(apiUrl, params, new OKHttpCallback() {
            @Override
            public void onFailUre(String msg) {
                if (requestCallback!=null){
                    requestCallback.onFailUre("网络异常，请稍后再试");
                }
            }

            @Override
            public void onSuccess(String result) {
                if (requestCallback!=null){
                    requestCallback.onSuccess(result);
                }
            }
        });
    }

    @Override
    public void doTwoPost(String apiUrl, HashMap<String, Object> params, final RequestCallback requestCallback) {
        OkHttpUtils.getInstance().doTwoPost(apiUrl, params, new OKHttpCallback() {
            @Override
            public void onFailUre(String msg) {
                if (requestCallback!=null){
                    requestCallback.onFailUre("网络异常，请稍后再试");
                }
            }

            @Override
            public void onSuccess(String result) {
                if (requestCallback!=null){
                    requestCallback.onSuccess(result);
                }
            }
        });
    }

    @Override
    public void dotowGet(String apiUrl, HashMap<String, Object> params, final RequestCallback requestCallback) {
        OkHttpUtils.getInstance().doTwoGet(apiUrl, params, new OKHttpCallback() {
            @Override
            public void onFailUre(String msg) {
                if (requestCallback!=null){
                    requestCallback.onFailUre("网络异常，请稍后再试");
                }
            }

            @Override
            public void onSuccess(String result) {
                if (requestCallback!=null){
                    requestCallback.onSuccess(result);
                }
            }
        });
    }

    @Override
    public void doPostPic(String url, MultipartBody.Part multipartBody, final RequestCallback callback) {
        OkHttpUtils.getInstance().doPostPic(url, multipartBody, new OKHttpCallback() {
            @Override
            public void onFailUre(String msg) {
                if (callback!=null){
                    callback.onFailUre("网络异常，请稍后再试");
                }
            }

            @Override
            public void onSuccess(String result) {
                if (callback!=null){
                    callback.onSuccess(result);
                }
            }
        });
    }
}
