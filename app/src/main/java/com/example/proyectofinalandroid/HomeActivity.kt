package com.example.proyectofinalandroid

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.widget.ImageButton
import android.widget.TextView

class HomeActivity : AppCompatActivity() {




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)


        val btnWassap=findViewById<ImageButton>(R.id.btn_wap)
        btnWassap.setOnClickListener{
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse("https://wa.me/51977674409?text=Hola%20necesito%20informacion......")
            startActivity(intent)
        }
       redirec()


        val bundle= intent.extras
        val email=bundle?.getString("email")
        User(email?:"")



    }

    private fun redirec(){

    //    val btnUser=findViewById<ImageButton>(R.id.btn_user)
    //    btnUser.setOnClickListener{
     //       startActivity(Intent(this,UserActivity::class.java))

    //    }

        val btnV=findViewById<ImageButton>(R.id.btn_vapes)
        btnV.setOnClickListener{
            startActivity(Intent(this,VapesActivity::class.java))
        }
        val btnL=findViewById<ImageButton>(R.id.btn_liquidos)
        btnL.setOnClickListener{
            startActivity(Intent(this,LiquidosActivity::class.java))
        }
        val btnA=findViewById<ImageButton>(R.id.btn_accesorios)
        btnA.setOnClickListener{
            startActivity(Intent(this,AccesoriosActivity::class.java))
        }
        val btnC=findViewById<ImageButton>(R.id.btn_combos)
        btnC.setOnClickListener{
            startActivity(Intent(this,CombosActivity::class.java))
        }

    }

    private fun User(email: String)
    {

        val btnUser=findViewById<ImageButton>(R.id.btn_user)

        btnUser.setOnClickListener{
            val userIntent = Intent(this, UserActivity::class.java).apply {
                putExtra("email", email)
            }
            startActivity(userIntent)

        }

        }


    }