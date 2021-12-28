package com.example.consumingdatawithrecyclerview.network

import android.widget.ImageView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

//Bind adapter são extensions methods que se situam entre a view e o bound data, fornecendo
// um comportamento customizado. Neste caso o comportamento será chamar o Glide
// para carregar a imagem de uma URL dentro de uma view
@BindingAdapter("imageUrl")
fun bindImage(imgView: ImageView, imgUrl: String?){
    imgUrl?.let {
        //transformando a string url em um objeto Uri
        val imgUri = imgUrl.toUri().buildUpon().scheme("https").build()
        //chamando glide.with para carregar a imagem do objeto Uri dentro da imageView
        Glide.with(imgView.context)
            .load(imgUri)
            .into(imgView)
        // add uma animação ao carregar a imagem, e imagem de erro caso a imagem nao carregue

    }
}