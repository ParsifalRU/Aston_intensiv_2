package com.example.aston_intensiv_2

import android.annotation.SuppressLint
import android.content.Intent
import android.content.res.Configuration
import android.content.res.Configuration.SCREENLAYOUT_SIZE_XLARGE
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity(), OnClickListener {

    private val helloTextView by lazy { getTextView(R.id.helloTextView) }
    private val counterTextView by lazy { getTextView(R.id.counterTextView) }
    private val zeroButton by lazy { getButton(R.id.zero) }
    private val toastButton by lazy { getButton(R.id.toast) }
    private val countButton by lazy { getButton(R.id.count) }
    private val editTextActivityButton by lazy { getButton(R.id.edit_text_button) }
    private val intentActivityButton by lazy { getButton(R.id.intent_activity_button) }
    private val firstPassageButton by lazy { getButton(R.id.passageFirstButton) }
    private val secondPassageButton by lazy { getButton(R.id.passageSecondButton) }
    private val thirdPassageButton by lazy { getButton(R.id.passageThirdButton) }
    private val shoppingListButton by lazy { getButton(R.id.shoppingListButton) }
    private val implicitButton by lazy { getButton(R.id.implicit_button) }

    private var result = 0

    private fun getTextView(idTextView: Int): TextView = findViewById(idTextView)
    private fun getButton(idButton: Int): Button = findViewById(idButton)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        codeLab9()

        codeLab8()

        codeLab7()

        codeLab6()

        codeLab5()

        codeLab4()

        codeLab3()

        codeLab2()

        codeLab1()
    }


    @SuppressLint("SwitchIntDef")
    private fun setOrientation(): Any {
        return when (resources.configuration.orientation) {
            Configuration.ORIENTATION_PORTRAIT -> setContentView(R.layout.activity_main)
            Configuration.ORIENTATION_LANDSCAPE -> setContentView(R.layout.activity_main_landscape)
            SCREENLAYOUT_SIZE_XLARGE -> setContentView(R.layout.activity_main_xlarge)
            else -> { Log.d("LOGTAG", "orientation not found")}
        }
    }

    private fun initButton(){
        zeroButton.setOnClickListener(this)
        countButton.setOnClickListener(this)
        toastButton.setOnClickListener(this)
        intentActivityButton.setOnClickListener(this)
        editTextActivityButton.setOnClickListener(this)
        firstPassageButton.setOnClickListener(this)
        secondPassageButton.setOnClickListener(this)
        thirdPassageButton.setOnClickListener(this)
        shoppingListButton.setOnClickListener(this)
        implicitButton.setOnClickListener(this)
    }

    private fun getData(){
        val prefs = getSharedPreferences("MY_PREFS", MODE_PRIVATE)
        result =  prefs.getInt("result_count", 0)
        counterTextView.text = result.toString()
        customZeroButton()
    }

    private fun codeLab1(){
        helloTextView.text = getString(R.string.hello_text_view)
        try {
            10 / 0
        } catch (e: Exception) {
            Log.e("LOGTAG", "exception = ", e)
        }catch (e: Error) {
            Log.d("LOGTAG", "error = ", e)
        }catch (t: Throwable) {
            Log.v("LOGTAG", "throwable = ", t)
        }
    }

    private fun codeLab2(){
        setOrientation()
        getData()
        initButton()
    }

    private fun codeLab3(){
        Log.d("LOGTAG", "ADD ScrollView")
    }

    private fun codeLab4(){
        Log.d("LOGTAG", "Change icon app")
    }

    private fun codeLab5(){
        Log.d("LOGTAG", "Intent Red Button")
    }

    private fun codeLab6(){
        Log.d("LOGTAG", "Intent orange Button")
    }

    private fun codeLab7(){
        Log.d("LOGTAG", "First, second, third passages")
    }

    private fun codeLab8(){
        Log.d("LOGTAG", "Shopping List")
    }

    private fun codeLab9(){
        Log.d("LOGTAG", "Implicit Intents")
    }

    private fun intentHelloActivity(){
        val intent = Intent(this, HelloActivity::class.java)
        intent.putExtra("name", "$result")
        startActivity(intent)
    }

    private fun intentShoppingListActivity(){
        val intent = Intent(this, ShoppingListActivity::class.java)
        startActivity(intent)
    }

    private fun intentImplicitActivity(){
        val intent = Intent(this, ImplicitActivity::class.java)
        startActivity(intent)
    }

    private fun intentTextPassagesActivity(choosePassage: Int){
        val intent = Intent(this, TextPassagesActivity::class.java)
        intent.putExtra("passage_name", choosePassage)
        startActivity(intent)
    }

    private fun intentEditTextActivity(){
        val intent = Intent(this, EditTextSaveActivity::class.java)
        startActivity(intent)
    }

    override fun onClick(v: View) {
        when(v){
            countButton -> {
                result++
                counterTextView.text = result.toString()
            }
            toastButton -> {
                Toast.makeText(this, "Count = $result", Toast.LENGTH_SHORT).show()
            }
            zeroButton -> {
                zeroButton.background.setTint(ContextCompat.getColor(this, R.color.grey))
                result = 0
                counterTextView.text = result.toString()
            }
            intentActivityButton -> {
                intentHelloActivity()
            }
            editTextActivityButton -> {
                intentEditTextActivity()
            }
            firstPassageButton -> {
                intentTextPassagesActivity(1)
            }
            secondPassageButton -> {
                intentTextPassagesActivity(2)
            }
            thirdPassageButton -> {
                intentTextPassagesActivity(3)
            }
            shoppingListButton -> {
                intentShoppingListActivity()
            }
            implicitButton -> {
                intentImplicitActivity()
            }
        }
       customZeroButton()
       saveData()
    }

    private fun customZeroButton(){
        if (result>0){
            zeroButton.background.setTint(ContextCompat.getColor(this, R.color.black))
            if (result % 2 == 0){
                zeroButton.background.setTint(ContextCompat.getColor(this, R.color.pink))
            }else {
                zeroButton.background.setTint(ContextCompat.getColor(this, R.color.yellow))
            }
        }
    }

    private fun saveData(){
        val editor = getSharedPreferences("MY_PREFS", MODE_PRIVATE).edit()
        editor.putInt("result_count", result)
        editor.apply()
    }
}

