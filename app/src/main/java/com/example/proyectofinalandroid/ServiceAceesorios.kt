package com.example.proyectofinalandroid

import retrofit2.Call
import retrofit2.http.GET

interface ServiceAceesorios {
    @GET("listar_accesorios")
    fun getAllProductos(): Call<List<ProductoModel>>
}