package com.example.raga

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface ApiInterface {

    @Headers("X-RapidAPI-Key: bd8d5a0e20mshe401575774f1f65p100ef1jsn5a5b7bfb2e0e",
            "X-RapidAPI-Host: deezerdevs-deezer.p.rapidapi.com")
    @GET("search")
    fun getData(@Query("q")query: String): Call<MyData>
}