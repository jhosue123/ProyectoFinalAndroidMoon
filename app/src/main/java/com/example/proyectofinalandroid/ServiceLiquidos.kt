package com.example.proyectofinalandroid

import retrofit2.Call
import retrofit2.http.GET

interface ServiceLiquidos {
    @GET("listar_liquidos")
    fun getAllProductos(): Call<List<ProductoModel>>
}