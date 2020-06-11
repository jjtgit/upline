package com.movie.financial.net;


public interface RequestCallback {
    void onSuccess(String result);
    void onFailUre(String msg);
}
