package com.example.dicegame

import android.graphics.BitmapFactory
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.example.dicegame.databinding.ActivityMainBinding
import java.io.IOException
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    private lateinit var tasarim: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        tasarim = ActivityMainBinding.inflate(layoutInflater)
        setContentView(tasarim.root)

        tasarim.button3.setOnClickListener {
            val dice1 = Random.nextInt(1, 7) // 1 ile 6 dahil rastgele birinci sayı
            val dice2 = Random.nextInt(1, 7) // 1 ile 6 dahil rastgele ikinci sayı
            ShowTheScreen(dice1, dice2)
        }
    }

    private fun ShowTheScreen(random1: Int, random2: Int) {
        val diceImageView: ImageView = tasarim.imageView
        val diceImageView2: ImageView = tasarim.imageView2

        // Rastgele üretilen zar değerlerini görsellerle eşleştir
        loadDiceImage(random1, diceImageView)
        loadDiceImage(random2, diceImageView2)
    }

    private fun loadDiceImage(diceNumber: Int, imageView: ImageView) {
        try {
            // Zar görselinin adını belirleyelim
            val fileName = "$diceNumber.png"

            // Görseli assets klasöründen yükleyip ImageView'e yerleştirelim
            val inputStream = assets.open(fileName)
            val bitmap = BitmapFactory.decodeStream(inputStream)
            imageView.setImageBitmap(bitmap)
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }
}
