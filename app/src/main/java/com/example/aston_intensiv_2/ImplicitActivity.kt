package com.example.aston_intensiv_2


import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class ImplicitActivity : AppCompatActivity(), OnClickListener {

    private lateinit var webButton:Button
    private lateinit var locationButton:Button
    private lateinit var shareTextButton:Button
    private lateinit var pictureButton:Button
    private lateinit var webEditText:EditText
    private lateinit var locationEditText:EditText
    private lateinit var shareTextEditText:EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_implict)

        initView()
    }

    override fun onClick(v: View) {
        when(v){
            webButton -> {
                intent = Intent()
                intent.action = Intent.ACTION_VIEW
                intent.data = Uri.parse("${webEditText.text}")
                try {
                    startActivity(intent)
                } catch (e: ActivityNotFoundException) {
                    Log.e("LOGTAG", "Activity not found $e")
                }
            }
            locationButton -> {
                intent = Intent()
                intent.action = Intent.ACTION_VIEW
                intent.data = Uri.parse("geo:0,0?q=${locationEditText.text}")
                try {
                    startActivity(intent)
                } catch (e: ActivityNotFoundException) {
                    Log.e("LOGTAG", "Activity not found $e")
                }
            }
            shareTextButton -> {
                val sendIntent: Intent = Intent().apply {
                    action = Intent.ACTION_SEND
                    putExtra(Intent.EXTRA_TEXT, "I'm the best")
                    type = "text/plain"
                }
                val shareIntent = Intent.createChooser(sendIntent, null)
                try {
                    startActivity(shareIntent)
                } catch (e: ActivityNotFoundException) {
                    Log.e("LOGTAG", "Activity not found $e")
                }
            }
            pictureButton -> {
                val takePictureIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
                try {
                    startActivity(takePictureIntent)
                } catch (e: ActivityNotFoundException) {
                    Log.e("LOGTAG", "Activity not found $e")
                }
            }
        }
    }

    private fun initView(){
        webEditText = findViewById(R.id.web_edit_text)
        locationEditText = findViewById(R.id.location_edit_text)
        shareTextEditText = findViewById(R.id.share_text_edit_text)

        webButton = findViewById(R.id.web_button)
        locationButton = findViewById(R.id.location_button)
        shareTextButton = findViewById(R.id.share_text_button)
        pictureButton = findViewById(R.id.picture_button)

        webButton.setOnClickListener(this)
        locationButton.setOnClickListener(this)
        shareTextButton.setOnClickListener(this)
        pictureButton.setOnClickListener(this)
    }
}