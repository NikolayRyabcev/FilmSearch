package com.example.filmsearch

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    val filmBaseUrl = "https://imdb-api.com"
    private val retrofit = Retrofit.Builder()
        .baseUrl(filmBaseUrl)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    private val movieService = retrofit.create(MovieAPI::class.java)
    private var movies = ArrayList<Movie>()
    private var adapter = MovieAdapter (movies)

    private lateinit var searchButton: Button
    private lateinit var queryInput: EditText
    private lateinit var placeholderMessage: TextView
    private lateinit var moviesList: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        searchButton=findViewById(R.id.searchButton)
        queryInput=findViewById(R.id.queryInput)
        placeholderMessage=findViewById(R.id.placeholderMessage)
        moviesList=findViewById(R.id.movies)

        adapter.movies=movies
        moviesList.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        moviesList.adapter = adapter
    }
}