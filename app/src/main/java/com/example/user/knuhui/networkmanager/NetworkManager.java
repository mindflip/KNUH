package com.example.user.knuhui.networkmanager;

import com.example.user.knuhui.BuildConfig;
import com.example.user.knuhui.networkmanager.service.RelayService;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetworkManager {

    public static final String TEST_IP = "http://192.168.0.39:3000";
    public static final String RELAY_URL_GET = "https://navi.knuh.kr/knuh/";
    public static final String RELAY_URL_POST = "https://navi.knuh.kr/knuh/";

    private NetworkManager instance = null;
    private RelayService relayService;
    private Retrofit retrofit;

    public NetworkManager(String baseUrl) {

        OkHttpClient.Builder okHttpBuilder = new OkHttpClient.Builder();

        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        if(BuildConfig.DEBUG) {
            okHttpBuilder.addInterceptor(loggingInterceptor);
        }

        retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpBuilder.build())
                .build();

        relayService = retrofit.create(RelayService.class);
    }

    public RelayService getRelayService() {
        return relayService;
    }
}