package com.example.aston_intensiv_2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class TextPassagesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_text_passages)

        setPassages()
    }

    private fun setPassages(){
        val passagesTextView = findViewById<TextView>(R.id.passagesTextView)
        when(intent.getIntExtra("passage_name", 0)){
            1 -> passagesTextView.text = getString(R.string.firstPiece)
            2 -> passagesTextView.text = getString(R.string.secondPiece)
            3 -> passagesTextView.text = getString(R.string.thirdPiece)
        }
    }
}