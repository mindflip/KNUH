package com.example.user.knuhui.networkmanager;

import com.example.user.knuhui.BuildConfig;
import com.example.user.knuhui.networkmanager.service.RelayService;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetworkManager {

    public static final String TEST_IP = "http://192.168.0.39:3000";
    public static final String RELAY_URL_GET = "https://navi.knuh.kr/knuh/getreq";
    public static final String RELAY_URL_POST = "https://navi.knuh.kr/knuh/postreq";

    private static NetworkManager instance = null;
    private static RelayService relayService = null;
    private Retrofit retrofit;

    private NetworkManager() {

        OkHttpClient.Builder okHttpBuilder = new OkHttpClient.Builder();

        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        if(BuildConfig.DEBUG) {
            okHttpBuilder.addInterceptor(loggingInterceptor);
        }

        retrofit = new Retrofit.Builder()
                .baseUrl(TEST_IP)
                .addConverterFactory(GsonConverterFactory.create())
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