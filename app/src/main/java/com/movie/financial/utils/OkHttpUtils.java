package com.movie.financial.utils;


import com.movie.financial.api.BaseApi;
import com.movie.financial.net.OKHttpCallback;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.HttpUrl;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

public class OkHttpUtils {

    private OkHttpClient okHttpClient;
    private static OkHttpUtils mInstance;
    private final RetrofitUtils retrofitUtils;

    public OkHttpUtils(){

        //日志拦截器
        HttpLoggingInterceptor loggingInterceptor=new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        okHttpClient=new OkHttpClient.Builder()
                .cookieJar(new CookieJar() {
                    private final HashMap<String, List<Cookie>> cookieStore=new HashMap<>();;
                    @Override
                    public void saveFromResponse(HttpUrl url, List<Cookie> cookies) {
                        cookieStore.put(url.host(),cookies);
                    }

                    @Override
                    public List<Cookie> loadForRequest(HttpUrl url) {
                        List<Cookie> cookies=cookieStore.get(url.host());
                        return cookies!=null?cookies:new ArrayList<Cookie>();
                    }
                })
                .addInterceptor(loggingInterceptor)
                .writeTimeout(10, TimeUnit.SECONDS)
                .connectTimeout(10, TimeUnit.SECONDS)
                .readTimeout(10, TimeUnit.SECONDS)
                .build();
            Retrofit retrofit=new Retrofit.Builder()
                    .client(okHttpClient)
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .baseUrl(BaseApi.BASE_API)
                    .build();
            retrofitUtils=retrofit.create(RetrofitUtils.class);
    }
    //get请求
    public void doGet(String apiUrl, HashMap<String, Object> params, final OKHttpCallback callback){
        retrofitUtils.doGet(apiUrl,params)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<ResponseBody>() {
                    @Override
                    public void accept(ResponseBody responseBody) throws Exception {
                        String result = responseBody.string();
                        if (callback!=null){
                            callback.onSuccess(result);
                        }
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        if (callback!=null){
                            callback.onFailUre("网络异常");
                            String message = throwable.getMessage();
                        }
                    }
                });
    }
    //post请求
    public void doPost(String apiUrl, HashMap<String, Object> parms, final OKHttpCallback callback){
        retrofitUtils.doPost(apiUrl,parms)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<ResponseBody>() {
                    @Override
                    public void accept(ResponseBody responseBody) throws Exception {
                        String result = responseBody.string();
                        if (callback!=null){
                            callback.onSuccess(result);
                        }
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        if (callback!=null){
                            callback.onFailUre("网络异常");
                            String message = throwable.getMessage();
                        }
                    }
                });
    }
    //post请求
    public void doTwoPost(String apiUrl, HashMap<String, Object> parms, final OKHttpCallback callback){
        retrofitUtils.doTwoPost(apiUrl,parms)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<ResponseBody>() {
                    @Override
                    public void accept(ResponseBody responseBody) throws Exception {
                        String result = responseBody.string();
                        if (callback!=null){
                            callback.onSuccess(result);
                        }
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        if (callback!=null){
                            callback.onFailUre("网络异常");
                            String message = throwable.getMessage();
                        }
                    }
                });
    }
    //twoget请求
    public void doTwoGet(String apiUrl, HashMap<String, Object> parms, final OKHttpCallback callback){
        retrofitUtils.doTwoGet(apiUrl,parms)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<ResponseBody>() {
                    @Override
                    public void accept(ResponseBody responseBody) throws Exception {
                        String result = responseBody.string();
                        if (callback!=null){
                            callback.onSuccess(result);
                        }
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        if (callback!=null){
                            callback.onFailUre("网络异常");
                            String message = throwable.getMessage();
                        }
                    }
                });
    }
    //上传图片
    public void doPostPic(String url, MultipartBody.Part multipartBody, final OKHttpCallback callback){
        Observable<ResponseBody> observable = retrofitUtils.doPostPic(url, multipartBody);
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<ResponseBody>() {
                    @Override
                    public void accept(ResponseBody responseBody) throws Exception {
                        String string = responseBody.string().toString();
                        if (callback != null) {
                            callback.onSuccess(string);
                        }
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        if (callback!=null){
                            callback.onSuccess("网络异常，请稍后再试");
                        }
                    }
                });
    }
    // 单例
    public static OkHttpUtils getInstance(){
        if (mInstance==null){
           synchronized (OkHttpUtils.class){
              if(mInstance==null){
                  mInstance=new OkHttpUtils();
               }
           }
        }
        return mInstance;
    }
    //关闭OKHTTP
    public void okHttpCancel(){
        if (okHttpClient!=null){
            okHttpClient.dispatcher().cancelAll();
        }
    }
}
