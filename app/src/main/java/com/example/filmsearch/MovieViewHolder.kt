package com.example.filmsearch

import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.view.menu.MenuView.ItemView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class MovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {


    val poster: ImageView = itemView.findViewById(R.id.poster)
    val filmName: TextView = itemView.findViewById(R.id.filmName)
    val filmDescript: TextView = itemView.findViewById(R.id.filmDescript)

    fun bind(item:Movie) {
        val adaptFilmName=item.title
        val adaptfilmDescript=item.description

        Glide.with(itemView)
            .load(item.image)
            .into(poster)

        filmName.text=adaptFilmName
        filmDescript.text=adaptfilmDescript
    }

}


