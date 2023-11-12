package com.bengisusahin.storingdata

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.bengisusahin.storingdata.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var sharedPref : SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //SharedPreferences - XML - Key-Value kucuk veritabanlari
        sharedPref = getSharedPreferences("com.bengisusahin.storingdata", MODE_PRIVATE) //MODE_PRIVATE benim verielerime benim uygulamam ulassin sadece
    }

    fun save(view : View){
        val myAge = binding.editText.text.toString()
        binding.textView.text = "Your age: ${myAge}"
        //binding.textView.text = "Your age: " + myAge
    }

    fun delete(view: View){

    }
}