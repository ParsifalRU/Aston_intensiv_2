package com.example.aston_intensiv_2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class EditTextSaveActivity : AppCompatActivity(),OnClickListener {

    private val countButton by lazy { getButton(R.id.count_btn) }
    private val countNumberTextView by lazy { getTextView(R.id.countNumberTextView) }
    private val editText by lazy { getEditText(R.id.edit_text) }
    private var result = 0

    private fun getTextView(idTextView: Int): TextView = findViewById(idTextView)
    private fun getButton(idButton: Int): Button = findViewById(idButton)
    private fun getEditText(idEditText: Int): EditText = findViewById(idEditText)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_text_save)

        if (savedInstanceState  != null){
            result = savedInstanceState.getInt("count_key")
            countNumberTextView.text = result.toString()
            editText.setText(savedInstanceState.getString("edit_text_key"))
        }
        initButton()
    }

    private fun initButton(){
        countButton.setOnClickListener(this)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("count_key", result)
        outState.putString("edit_text_key", editText.text.toString())
    }

    override fun onClick(v: View) {
        when(v){
            countButton -> {
                result++
                countNumberTextView.text = result.toString()
            }
        }
    }
}