package com.example.islamiappproject.islamiapp.a.islamiapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.islamiappproject.R
import com.example.islamiappproject.databinding.ActivityHadethDetailsBinding
import com.example.islamiappproject.databinding.FragmentHadethBinding
import com.example.islamiappproject.islamiapp.a.islamiapp.adapter.HadethVersesAdapter
import com.example.islamiappproject.islamiapp.a.islamiapp.adapter.SuraVersesAdapter

class HadethDetailsActivity : AppCompatActivity() {
    lateinit var adapter: HadethVersesAdapter
    lateinit var binding: ActivityHadethDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityHadethDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapter=HadethVersesAdapter(null)
        binding.recyclerviewsura.adapter=adapter
        binding.icBack.setOnClickListener(
            {
                finish()
            })


         var list =intent.getStringExtra(Constant.Hadeth_Name)?.split("\n")?.toList()?: listOf()
            adapter.updateData(list)
        val title=intent.getStringExtra(Constant.Hadeth_Title)
        binding.hadethtitle.text=title
        }


}