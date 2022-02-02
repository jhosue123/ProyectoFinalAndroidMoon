package com.example.proyectofinalandroid

import retrofit2.Call
import retrofit2.http.GET

interface ServiceCombos {
    @GET("listar_combos")
    fun getAllProductos(): Call<List<ProductoModel>>
}