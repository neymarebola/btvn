package com.example.btvn.ApiService;

import com.example.btvn.models.Item;
import com.example.btvn.models.Root;
import com.example.btvn.models.Root_detail;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface JsonplaceholderApi {

    @GET("newsfeed.json")
    Call<Root> getListNewFeed();

    @GET("detail.json")
    Call<Root_detail> getDetailNewFeed();
}
