package com.example.kotlinappfirebase

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.kotlinappfirebase.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.btnImageSlider.setOnClickListener{
            val intent= Intent(this,ImageSliderActivity::class.java)
            startActivity(intent)
        }
        binding.btnToDo.setOnClickListener{
            val intent= Intent(this,ToDoActivity::class.java)
            startActivity(intent)
        }


    }
}