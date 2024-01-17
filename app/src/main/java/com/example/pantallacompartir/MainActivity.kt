package com.example.pantallacompartir

import android.content.Intent
import android.net.Uri
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
        binding.btnCompartirImagen.setOnClickListener { compartirImagen() }
        binding.btnCompartirImagenes.setOnClickListener { compartirImagenes() }
    }

    private fun compartirImagenes() {
        val uriArray:ArrayList<Uri> = arrayListOf(Uri.EMPTY, Uri.EMPTY)
        val intent=Intent().apply {
            action=Intent.ACTION_SEND_MULTIPLE
            putParcelableArrayListExtra(Intent.EXTRA_STREAM, uriArray)
            type="image/*"
            putExtra(Intent.EXTRA_TITLE,"Compartir Imagen")

        }
        startActivity(Intent.createChooser(intent,null))
    }

    private fun compartirImagen() {
        val intent=Intent().apply {
            action=Intent.ACTION_SEND
            putExtra(Intent.EXTRA_STREAM, Uri.EMPTY)
            type="image/jpeg"
            putExtra(Intent.EXTRA_TITLE,"Compartir Imagen")

        }
        startActivity(Intent.createChooser(intent,null))
    }

    fun compartir(){
        val intent= Intent().apply {
            action= Intent.ACTION_SEND
            putExtra(Intent.EXTRA_TEXT,"COMPARTIR")
            type="text/plain"
            putExtra(Intent.EXTRA_TITLE,"Pantalla Compartir")
        }
        val compartirIntent= Intent.createChooser(intent,null)
        startActivity(compartirIntent)
    }
}