package com.example.basicintentpractice

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val displayButton = findViewById<Button>(R.id.display)
        val shareButton = findViewById<Button>(R.id.share)

        //Явная реализация
        displayButton.setOnClickListener {
            val displayIntent = Intent(this, MessageActivity::class.java)
            startActivity(displayIntent)
        }

        //Неявная
        shareButton.setOnClickListener {
            val message = "Привет, Android разработка — это круто!"
            val shareIntent = Intent(Intent.ACTION_SENDTO)
            shareIntent.data = Uri.parse("mailto:")
            shareIntent.putExtra(Intent.EXTRA_EMAIL, arrayOf("yourEmail@ya.ru"))
            shareIntent.putExtra(Intent.EXTRA_TEXT, message)
            startActivity(shareIntent)
        }
    }
}