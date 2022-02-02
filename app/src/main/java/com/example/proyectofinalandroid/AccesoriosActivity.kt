package com.example.proyectofinalandroid

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageButton
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class AccesoriosActivity : AppCompatActivity() {


    lateinit var service: ServiceAceesorios
    lateinit var recyaccesorios: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_accesorios)

             val retrofit: Retrofit = Retrofit.Builder()
               .baseUrl("https://my-json-server.typicode.com/jhosue123/JsonRepo/")
                .addConverterFactory(GsonConverterFactory.create())
               .build()
            recyaccesorios = findViewById(R.id.recycler_accesorios)
           recyaccesorios.layoutManager = LinearLayoutManager(this)
            service = retrofit.create<ServiceAceesorios>(ServiceAceesorios::class.java)
            obtenerDataApiRest()

        redirec()


        val btnWassap=findViewById<ImageButton>(R.id.btn_wap)
        btnWassap.setOnClickListener{
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse("https://wa.me/51977674409?text=Hola%20necesito%20informacion......")
            startActivity(intent)
        }
    }

    private fun obtenerDataApiRest() {
        service.getAllProductos().enqueue(object : Callback<List<ProductoModel>> {
            override fun onResponse(call: Call<List<ProductoModel>>, response: Response<List<ProductoModel>>) {

                val acces = response?.body()

                recyaccesorios.adapter = AdapterAccesorios(acces!!)
            }

            override fun onFailure(call: Call<List<ProductoModel>>, t: Throwable) {
                Log.e("Errorrrrrrrrrrrrrr",t.message.toString())
            }

        })
    }

    private fun redirec(){

        val btnUser=findViewById<ImageButton>(R.id.btn_home)
        btnUser.setOnClickListener{
            startActivity(Intent(this,HomeActivity::class.java))
        }

    }
}