package com.example.consumingdatawithrecyclerview.network

import com.squareup.moshi.Json

data class Image(val id: String,
                val author: String,
                val width: String,
                val height: String,
                val url: String,
                val download_url: String
                )
