package com.example.user.knuhui.networkmanager;

import com.example.user.knuhui.BuildConfig;
import com.example.user.knuhui.networkmanager.service.RelayService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;

public class NetworkManager {

    public static final String TEST_IP = "http://192.168.0.39:3000";
    public static final String RELAY_URL = "https://navi.knuh.kr/knuh13/";

    private static NetworkManager instance = null;
    private static RelayService relayService;
    private Retrofit retrofit;

    private NetworkManager() {

        OkHttpClient.Builder okHttpBuilder = new OkHttpClient.Builder();

        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        if(BuildConfig.DEBUG) {
            okHttpBuilder.addInterceptor(loggingInterceptor);
        }

        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        retrofit = new Retrofit.Builder()
                .baseUrl(RELAY_URL)
//                .addConverterFactory(GsonConverterFactory.create(gson))
                .addConverterFactory(SimpleXmlConverterFactory.create())
                .client(okHttpBuilder.build())
                .build();

        relayService = retrofit.create(RelayService.class);
    }

    public static NetworkManager getInstance() {
        if (instance == null) {
            instance = new NetworkManager();
        }
        return instance;
    }

    public static RelayService getRelayService() {
        return relayService;
    }
}