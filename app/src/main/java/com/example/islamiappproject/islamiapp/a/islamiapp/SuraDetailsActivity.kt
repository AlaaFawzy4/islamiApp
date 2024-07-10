package com.example.islamiappproject.islamiapp.a.islamiapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import com.example.islamiappproject.R
import com.example.islamiappproject.databinding.ActivitySuraDetailsBinding
import com.example.islamiappproject.islamiapp.a.islamiapp.adapter.SuraVersesAdapter

class SuraDetailsActivity : AppCompatActivity() {
    lateinit var adapter: SuraVersesAdapter
    lateinit var binding: ActivitySuraDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySuraDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val title = intent.getStringExtra(Constant.Sura_Name)
        val index = intent.getIntExtra(Constant.index, -1)
        binding.suratitle.text = title
       adapter = SuraVersesAdapter(null)
        binding.recyclerviewsura.adapter = adapter
        readFileFromAsset(index)
    }

    private fun readFileFromAsset(index: Int) {
        val file_name = "$index.txt"
        val textFileContent = application.assets.open(file_name).bufferedReader().use {
            it.readText()
        }
        val suracontent=textFileContent.split("/n")
        adapter.updateData(suracontent)
    }
}