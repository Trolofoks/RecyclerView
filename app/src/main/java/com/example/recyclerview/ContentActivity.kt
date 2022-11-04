package com.example.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.recyclerview.databinding.ActivityContentBinding

class ContentActivity : AppCompatActivity() {
    lateinit var binding: ActivityContentBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityContentBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val item = intent.getSerializableExtra("Key") as PlantModel
        binding.apply {
            imagePlant.setImageResource(item.imageId)
            textName.text = item.title
            textDescription.text = item.description
        }
    }
}