package com.example.aston_intensiv_2

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity

class ItemActivity : AppCompatActivity(), OnClickListener {

    private val arrayList = arrayListOf<String>()
    private var clickNumbers = 0

    private val appleButton by lazy { getButton(R.id.apple) }
    private val riceButton by lazy { getButton(R.id.rice) }
    private val juiceButton by lazy { getButton(R.id.juice) }
    private val cucumberButton by lazy { getButton(R.id.cucumber) }
    private val cheeseButton by lazy { getButton(R.id.cheese) }
    private val lettuceButton by lazy { getButton(R.id.lettuce) }
    private val watermelonButton by lazy { getButton(R.id.watermelon) }
    private val mangoButton by lazy { getButton(R.id.mango) }
    private val pearButton by lazy { getButton(R.id.pear) }
    private val radishButton by lazy { getButton(R.id.radish) }
    private val breadButton by lazy { getButton(R.id.bread) }
    private val orangeButton by lazy { getButton(R.id.orange) }
    private val pineappleButton by lazy { getButton(R.id.pineapple) }
    private val lemonButton by lazy { getButton(R.id.lemon) }
    private val cabbageButton by lazy { getButton(R.id.cabbage) }

    private fun getButton(idButton: Int): Button = findViewById(idButton)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item)

        initButton()

        val data = savedInstanceState?.getStringArrayList("array_key")
        val counter = savedInstanceState?.getInt("counter_key")
        if (data!= null){
            arrayList.addAll(data)
            clickNumbers = counter!!
        }

        isBackPressed()
    }

    override fun onClick(v: View) {
        if (clickNumbers != 9){
            when(v.id){
                R.id.apple -> {
                    arrayList.add("apple")
                    counter()
                }
                R.id.cheese -> {
                    arrayList.add("cheese")
                    counter()
                }
                R.id.rice -> {
                    arrayList.add("rice")
                    counter()
                }
                R.id.radish -> {
                    arrayList.add("radish")
                    counter()
                }
                R.id.pineapple -> {
                    arrayList.add("pineapple")
                    counter()
                }
                R.id.juice -> {
                    arrayList.add("juice")
                    counter()
                }
                R.id.lettuce -> {
                    arrayList.add("lettuce")
                    counter()
                }
                R.id.mango -> {
                    arrayList.add("mango")
                    counter()
                }
                R.id.bread -> {
                    arrayList.add("bread")
                    counter()
                }
                R.id.lemon -> {
                    arrayList.add("lemon")
                    counter()
                }
                R.id.cucumber -> {
                    arrayList.add("cucumber")
                    counter()
                }
                R.id.watermelon -> {
                    arrayList.add("watermelon")
                    counter()
                }
                R.id.pear -> {
                    arrayList.add("pear")
                    counter()
                }
                R.id.orange -> {
                    arrayList.add("orange")
                    counter()
                }
                R.id.cabbage -> {
                    arrayList.add("cabbage")
                    counter()
                }
            }
        }else{
            Toast.makeText(
                this,
                getString(R.string.products),
                Toast.LENGTH_SHORT).show()
            intentShoppingListActivity()
            finish()
        }
    }
    private fun counter(){
        clickNumbers++
        Toast.makeText(
            this,
            "${getString(R.string.toast1)} $clickNumbers ${getString(R.string.toast2)}",
            Toast.LENGTH_SHORT).show()
    }


    private fun intentShoppingListActivity(){
        val intent = Intent(this, ShoppingListActivity::class.java)
        intent.putStringArrayListExtra("shopping_list_name", arrayList)
        startActivity(intent)
    }

    private fun initButton(){
        appleButton.setOnClickListener(this)
         riceButton.setOnClickListener(this)
        juiceButton.setOnClickListener(this)
        cucumberButton.setOnClickListener(this)
        cheeseButton.setOnClickListener(this)
        lettuceButton.setOnClickListener(this)
        watermelonButton.setOnClickListener(this)
        mangoButton.setOnClickListener(this)
        pearButton.setOnClickListener(this)
        radishButton.setOnClickListener(this)
        breadButton.setOnClickListener(this)
        orangeButton.setOnClickListener(this)
        pineappleButton.setOnClickListener(this)
        lemonButton.setOnClickListener(this)
        cabbageButton.setOnClickListener(this)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putStringArrayList("array_key", arrayList)
        outState.putInt("counter_key", clickNumbers)
    }

    private fun isBackPressed() {
        onBackPressedDispatcher.addCallback(this, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                intentShoppingListActivity()
                finish()
            }
        })
    }
}