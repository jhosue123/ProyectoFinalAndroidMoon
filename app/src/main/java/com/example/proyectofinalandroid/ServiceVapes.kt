package com.example.proyectofinalandroid

import retrofit2.Call
import retrofit2.http.GET

interface ServiceVapes {
    @GET("listar_vapes")
    fun getAllProductos(): Call<List<ProductoModel>>
}