package com.example.aston_intensiv_2

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.*

lateinit var adapter: ListAdapter
val arrayList : ArrayList<String> = arrayListOf("1", "2", "3", "4", "5", "6", "7", "8", "9", "10")

class ShoppingListActivity : AppCompatActivity(), OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shopping_list)

       getData()

       setView()
    }

    private fun getData(){
        val data = intent.getStringArrayListExtra("shopping_list_name")
        if (data != null){
            arrayList.clear()
            arrayList.addAll(data)
        }
    }

    private fun setView(){
        val addProductButton = findViewById<Button>(R.id.add_product_button)
        addProductButton.setOnClickListener {
            startActivity(Intent(this, ItemActivity::class.java))
            finish()

        }
        val searchButton = findViewById<Button>(R.id.search_shop)
        searchButton.setOnClickListener(this)

        adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, arrayList)
        val productsListView = findViewById<ListView>(R.id.shoppingListView)
        productsListView.adapter = adapter
    }

    override fun onClick(v: View) {
        when(v.id){
            R.id.search_shop -> {
                val editText = findViewById<EditText>(R.id.shop_searcher_edit_text)
                intent = Intent()
                intent.action = Intent.ACTION_VIEW
                intent.data = Uri.parse("geo:0,0?q=${editText.text}")
                startActivity(intent)
            }
        }
    }
}