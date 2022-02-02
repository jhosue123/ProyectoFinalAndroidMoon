package com.example.proyectofinalandroid

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.constraintlayout.widget.ConstraintLayout
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        Thread.sleep(1000)
        setTheme(R.style.ThemeFlash)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)


        logeo()

    }



    private  fun logeo(){
        title="Autentication"
        val btnregistrar=findViewById<Button>(R.id.btn_registrar)
        val btnlogin=findViewById<Button>(R.id.btn_login)
        val correo=findViewById<EditText>(R.id.editTextCorreo)
        val contra=findViewById<EditText>(R.id.editTextPassword)

        btnregistrar.setOnClickListener {
            if(correo.text.isNotEmpty()&& contra.text.isNotEmpty())
            {
                FirebaseAuth.getInstance()
                    .createUserWithEmailAndPassword(correo.text.toString(),
                        contra.text.toString()).addOnCompleteListener {
                        if(it.isSuccessful)
                        {
                            Home(it.result?.user?.email?:"")



                        }else
                        {
                            Alerta()
                        }
                    }
            }
        }

        btnlogin.setOnClickListener{
            if(correo.text.isNotEmpty()&& contra.text.isNotEmpty())
            {
                FirebaseAuth.getInstance()
                    .signInWithEmailAndPassword(correo.text.toString(),
                        contra.text.toString()).addOnCompleteListener {
                        if(it.isSuccessful)
                        {
                            Home(it.result?.user?.email?:"")

                            Toast.makeText(this,"Credenciales Correctas", Toast.LENGTH_SHORT).show()
                        }
                        else
                        {
                            Alerta()
                        }
                    }
            }
        }
    }



    private  fun Home(email:String) {
        val homeIntent =Intent(this,HomeActivity::class.java).apply {
            putExtra("email",email)
        }
        startActivity(homeIntent)
    }





    private  fun Alerta()
    {
        val builder= AlertDialog.Builder(this)
        builder.setTitle("Error")
        builder.setMessage("Seha producido un error al autentificar al usuario")
        builder.setPositiveButton("Aceptar",null)
        val dialog: AlertDialog =builder.create()
        dialog.show()
    }
}