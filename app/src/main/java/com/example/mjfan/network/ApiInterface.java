package com.example.mjfan.network;

import com.example.mjfan.network.response.BaseResponse;
import com.example.mjfan.network.response.SongsModel;

import io.reactivex.Single;
import retrofit2.http.GET;

public interface ApiInterface {

    @GET("search?term=Michael+jackson")
    Single<BaseResponse<SongsModel>> fetchData();
}
