package com.example.consumingdatawithrecyclerview.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "https://picsum.photos"

//moshi
private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

//retofit object
private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()


//retrofit service
interface ImageGalleryApiService {

    @GET("/v2/list")
    suspend fun getGalleryImages(): List<Image>
}


//retrofit object service
object ImageGalleryApi {
    val retrofitService: ImageGalleryApiService by lazy { retrofit.create(ImageGalleryApiService::class.java) }
}