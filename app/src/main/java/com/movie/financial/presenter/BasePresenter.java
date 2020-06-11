package com.movie.financial.presenter;


import com.movie.financial.contact.BaseContract;
import com.movie.financial.model.BaseModel;
import com.movie.financial.net.RequestCallback;

import java.util.HashMap;

import okhttp3.MultipartBody;

/**
 * Created by 修梦 on 2019/10/23.
 * Describe:
 */
public class BasePresenter extends BaseContract.BasePresenter{

    private BaseModel model;
    private BaseContract.IBaseView view;

    public BasePresenter(BaseContract.IBaseView view) {
        this.model=new BaseModel();
        this.view = view;
    }

    @Override
    public void showGet(String apiUrl, HashMap<String, Object> params) {
        if (model!=null){
            model.doGet(apiUrl, params, new RequestCallback() {
                @Override
                public void onSuccess(String result) {
                    if (view!=null){
                        view.onSuccessShowGet(result);
                    }
                }

                @Override
                public void onFailUre(String msg) {
                    if (view!=null){
                        view.onFailUre(msg);
                    }
                }
            });
        }
    }

    @Override
    public void showPost(String apiUrl, HashMap<String, Object> params) {
        if (model!=null){
            model.doPost(apiUrl, params, new RequestCallback() {
                @Override
                public void onSuccess(String result) {
                    if (view!=null){
                        view.onSuccessShowPost(result);
                    }
                }

                @Override
                public void onFailUre(String msg) {
                    if (view!=null){
                        view.onFailUre(msg);
                    }
                }
            });
        }
    }

    @Override
    public void showTwoPost(String apiUrl, HashMap<String, Object> params) {
        if (model!=null){
            model.doTwoPost(apiUrl, params, new RequestCallback() {
                @Override
                public void onSuccess(String result) {
                    if (view!=null){
                        view.onSuccessShowTwoPost(result);
                    }
                }

                @Override
                public void onFailUre(String msg) {
                    if (view!=null){
                        view.onFailUre(msg);
                    }
                }
            });
        }
    }

    @Override
    public void showtowGet(String apiUrl, HashMap<String, Object> params) {
        if (model!=null){
            model.dotowGet(apiUrl, params, new RequestCallback() {
                @Override
                public void onSuccess(String result) {
                    if (view!=null){
                        view.onSuccessShowTowGet(result);
                    }
                }

                @Override
                public void onFailUre(String msg) {
                    if (view!=null){
                        view.onFailUre(msg);
                    }
                }
            });
        }
    }

    @Override
    public void showPostPic(String url, MultipartBody.Part multipartBody) {
        if (model!=null){
            model.doPostPic(url, multipartBody,new RequestCallback() {
                @Override
                public void onSuccess(String result) {
                    if (view!=null){
                        view.onSuccessShowPost(result);
                    }
                }

                @Override
                public void onFailUre(String msg) {
                    if (view!=null){
                        view.onFailUre(msg);
                    }
                }
            });
        }
    }

    public void destroy(){
        if (view!=null){
            view=null;
        }
        if (model!=null){
            model=null;
        }
    }
}
