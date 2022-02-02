package com.example.proyectofinalandroid

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import com.google.firebase.auth.FirebaseAuth

class UserActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user)
        redirec()

        salir()

        val bundle= intent.extras
        val email=bundle?.getString("email")
        setup(email?:"")

    }


    private fun redirec(){

        val btnUser=findViewById<ImageButton>(R.id.btn_home)
        btnUser.setOnClickListener{
            startActivity(Intent(this,HomeActivity::class.java))
        }

    }

    private fun salir()
    {
        val btnSalir=findViewById<Button>(R.id.btn_salir)
        btnSalir.setOnClickListener{

           FirebaseAuth.getInstance().signOut()
            startActivity(Intent(this,LoginActivity::class.java))
            Toast.makeText(this,"cierre de sesion Exitoso!!", Toast.LENGTH_SHORT).show()
        }
    }

    private  fun setup(email:String)
    {
        val correo=findViewById<TextView>(R.id.email_View)
        correo.text=email
    }
}