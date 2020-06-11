package com.movie.financial.contact;



import com.movie.financial.net.RequestCallback;

import java.util.HashMap;

import okhttp3.MultipartBody;

public interface BaseContract {
    abstract class BasePresenter{
        public abstract void showGet(String apiUrl, HashMap<String, Object> params);
        public abstract void showPost(String apiUrl, HashMap<String, Object> params);
        public abstract void showTwoPost(String apiUrl, HashMap<String, Object> params);
        public abstract void showtowGet(String apiUrl, HashMap<String, Object> params);
        public abstract void showPostPic(String url, MultipartBody.Part multipartBody);
    }
    interface IBaseModel{
        void doGet(String apiUrl, HashMap<String, Object> params, RequestCallback requestCallback);
        void doPost(String apiUrl, HashMap<String, Object> params, RequestCallback requestCallback);
        void doTwoPost(String apiUrl, HashMap<String, Object> params, RequestCallback requestCallback);
        void dotowGet(String apiUrl, HashMap<String, Object> params, RequestCallback requestCallback);
        void doPostPic(String url, MultipartBody.Part multipartBody, RequestCallback callback);
    }
    interface IBaseView{
        void onFailUre(String msg);
        void onSuccessShowGet(String result);
        void onSuccessShowTowGet(String result);
        void onSuccessShowTwoPost(String result);
        void onSuccessShowPost(String result);
    }
}
