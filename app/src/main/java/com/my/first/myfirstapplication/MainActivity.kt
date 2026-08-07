package com.my.first.myfirstapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val nombreUsuario: EditText = findViewById(R.id.nombre_usuario)
        val boton: Button = findViewById(R.id.boton_enviar_dato)

        boton.setOnClickListener {
            val intent = Intent(this, MySecondActivity::class.java)
            intent.putExtra("nombre_usuario", nombreUsuario.text.toString())
            startActivity(intent)
        }
    }
}
