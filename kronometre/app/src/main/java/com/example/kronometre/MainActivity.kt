package com.example.kronometre

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import android.view.View
import android.widget.Button
import android.widget.Chronometer
import android.widget.ImageView

class MainActivity : AppCompatActivity() {
    lateinit var btnStart : Button
    lateinit var btnPause : Button
    lateinit var btnReset : Button
    lateinit var imageView : ImageView
    lateinit var kronometre : Chronometer
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnStart = findViewById(R.id.btnStart)
        btnPause = findViewById(R.id.btnPause)
        btnReset = findViewById(R.id.btnReset)
        imageView = findViewById(R.id.imageView)
        kronometre = findViewById(R.id.kronometre)
        var zamaniDurdur:Long = 0 // zamanı durdurduktan sonra kalan zamandan devam edebilmek için kronometre içindeki zamanı bir değişkene aktarıyoruz.

        btnStart.setOnClickListener{
        kronometre.base = SystemClock.elapsedRealtime()+zamaniDurdur // Sistem saatini kronometre içerisine aktarır
        kronometre.start()
        btnStart.visibility = View.GONE
        btnPause.visibility = View.VISIBLE
        imageView.setImageDrawable(getDrawable(R.drawable.pause))
        }
        btnPause.setOnClickListener{
            zamaniDurdur = kronometre.base - SystemClock.elapsedRealtime()
            kronometre.stop()
            btnPause.visibility = View.GONE
            btnStart.visibility = View.VISIBLE
            imageView.setImageDrawable(getDrawable(R.drawable.start))
        }
        btnReset.setOnClickListener{
            kronometre.base = SystemClock.elapsedRealtime()
            kronometre.stop()
            btnPause.visibility = View.GONE
            btnStart.visibility = View.VISIBLE
            imageView.setImageDrawable(getDrawable(R.drawable.start))
        }


    }
}