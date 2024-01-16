package com.example.pantallacompartir

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.pantallacompartir.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnCompartir.setOnClickListener { compartir() }
    }
    fun compartir(){
        val intent= Intent().apply {
            action= Intent.ACTION_SEND
            putExtra(Intent.EXTRA_TEXT,"COMPARTIR")
            type="text/plain"
        }
        val compartirIntent= Intent.createChooser(intent,null)
        startActivity(compartirIntent)
    }
}