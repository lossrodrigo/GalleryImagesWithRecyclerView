package com.example.consumingdatawithrecyclerview.network

import android.widget.ImageView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.consumingdatawithrecyclerview.R
import com.example.consumingdatawithrecyclerview.overview.GalleryImageAdapter

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
            // add uma animação ao carregar a imagem, e imagem de erro caso a imagem nao carregue
            .apply(RequestOptions()
                .placeholder(R.drawable.loading_animation)
                .error(R.drawable.ic_broken_image))
            .into(imgView)


    }
}

//bind adapater que inicializa GalleryImageAdapter com uma lista de Image objects
@BindingAdapter("listData")
fun bindRecyclerView(recyclerView: RecyclerView, data: List<Image>?) {
    val adapter =  recyclerView.adapter as GalleryImageAdapter
    adapter.submitList(data)
}