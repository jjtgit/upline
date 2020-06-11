package com.movie.financial.utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.movie.financial.app.MyApp;


/**
 * Created by 修梦 on 2019/7/3.
 * Describe:SharedPreference工具类
 */
public class SpUtils {
    private static SpUtils minstance;
    private SharedPreferences sharedPreferences;

    private SpUtils(){
        sharedPreferences= MyApp.getContext().getSharedPreferences("sp", Context.MODE_PRIVATE);
    }
    //双重检验锁
    public static SpUtils getMinstance() {
        if (minstance==null){
            synchronized (SpUtils.class){
                if (minstance==null){
                    minstance=new SpUtils();//多线程访问，保证线程安全
                }
            }
        }
        return minstance;
    }
    /**
     * 存储数据
     */
    public void putSp(String key, String value){
        sharedPreferences.edit().putString(key,value).commit();

    }
    /**
     * 存储数据
     */
    public void putInt(String key, int i){
        sharedPreferences.edit().putInt(key,i).commit();

    }
    /**
     * 获取数据
     */
    public String getSp(String key){
        return sharedPreferences.getString(key,"");
    }
    /**
     * 获取boolen方法
     */
    public boolean getboolen(String key){

        return sharedPreferences.getBoolean(key,false);

    }
    /**
     * 添加boolen的方法
     */
    public void setboolen(String key, Boolean values){

        sharedPreferences.edit().putBoolean(key, values).commit();
    }
    /**
     * 清除所有数据
     */
    public void clear(){

    }
}
