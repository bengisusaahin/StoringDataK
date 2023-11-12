package com.bengisusahin.storingdata

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.bengisusahin.storingdata.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var sharedPref : SharedPreferences
    var ageFromPref : Int? = null //integer nullabell ve null atıyoruz

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //SharedPreferences - XML - Key-Value kucuk veritabanlari
        sharedPref = getSharedPreferences("com.bengisusahin.storingdata", MODE_PRIVATE) //MODE_PRIVATE benim verielerime benim uygulamam ulassin sadece

        ageFromPref = sharedPref.getInt("age", -1) //o anahtarda bir deger yoksa default value dondurmesi gerek
        if (ageFromPref == -1){ //demek ki kayitli bir veri yok
            binding.textView.text = "Your age :"
        }else{
            binding.textView.text = "Your age : ${ageFromPref}"
        }
    }

    fun save(view : View){
        val myAge = binding.editText.text.toString().toIntOrNull()

        if (myAge != null){
            binding.textView.text = "Your age: ${myAge}"
            //binding.textView.text = "Your age: " + myAge
            sharedPref.edit().putInt("age",myAge).apply()
        }

    }

    fun delete(view: View){
        ageFromPref = sharedPref.getInt("age", -1)

        if (ageFromPref != -1){
            sharedPref.edit().remove("age").apply()
            binding.textView.text = "Your age:"
        }
    }
}