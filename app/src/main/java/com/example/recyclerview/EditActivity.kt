package com.example.recyclerview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.recyclerview.databinding.ActivityContentBinding
import com.example.recyclerview.databinding.ActivityEditBinding

class EditActivity : AppCompatActivity() {
    lateinit var binding: ActivityEditBinding
    private val imageIdList = listOf(
        R.drawable.plant1,
        R.drawable.plant2,
        R.drawable.plant3,
        R.drawable.plant4,
        R.drawable.plant5,
    )
    private var index = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initButtons()
    }

    private fun initButtons() = with(binding) {
        buttonNext.setOnClickListener {
            index++
            if (index == 5) index = 0
            imagePlantEdit.setImageResource(imageIdList[index])
        }
        buttonSave.setOnClickListener {
            val i = intent
            i.putExtra("Key0", imageIdList[index])
            i.putExtra("Key1", editTextName.text)
            i.putExtra("Key2", editTextDescription.text)
            setResult(RESULT_OK, i)
            finish()
        }
    }
}