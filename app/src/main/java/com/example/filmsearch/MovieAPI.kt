package com.example.filmsearch

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface MovieAPI {
    @GET("/en/API/SearchMovie/k_2w1hk737/{expression}")
    fun getMovies (@Path("expression") expression: String) : Call<Movie>
}