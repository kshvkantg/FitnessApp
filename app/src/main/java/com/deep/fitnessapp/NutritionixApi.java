package com.deep.fitnessapp;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface NutritionixApi {
    @GET("posts")
    Call<List<POST>> getPosts();
}
