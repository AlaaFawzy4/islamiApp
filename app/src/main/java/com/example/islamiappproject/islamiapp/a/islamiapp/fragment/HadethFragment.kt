package com.example.islamiappproject.islamiapp.a.islamiapp.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.islamiappproject.databinding.FragmentHadethBinding
import com.example.islamiappproject.islamiapp.a.islamiapp.Constant
import com.example.islamiappproject.islamiapp.a.islamiapp.HadethDetailsActivity
import com.example.islamiappproject.islamiapp.a.islamiapp.adapter.SuraVersesAdapter

class HadethFragment : Fragment() {
lateinit var binding: FragmentHadethBinding
lateinit var adapter: SuraVersesAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=FragmentHadethBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter= SuraVersesAdapter(null)
        binding.recyclerview.adapter=adapter
        readHadethFromAssetFile()
    }

    private fun readHadethFromAssetFile() {
        val file_name = "ahadeeth.txt"
        val textFileContent = requireContext().assets.open(file_name).bufferedReader().use {
            it.readText()
        }
        val hadethList=textFileContent.trim().split("#")
        val hadethTitleList= mutableListOf<String>()
        val hadethContentList= mutableListOf<String>()
        hadethList.forEach {hadeth ->
            val Hadeth=hadeth.trim().split("\n").toMutableList()
            hadethTitleList.add(Hadeth.get(0))
            Hadeth.removeAt(0)
            hadethContentList.add(Hadeth.joinToString())
        }
        adapter.updateData(hadethTitleList)
        adapter.onHadethClickListener=object :SuraVersesAdapter.OnHadethClickListener{
            override fun OnHadethClick(position: Int) {
                super.OnHadethClick(position)
                val intent=Intent(requireContext(), HadethDetailsActivity::class.java)
                intent.putExtra(Constant.Hadeth_Title,hadethTitleList.get(position))
                intent.putExtra(Constant.Hadeth_Name,hadethContentList.get(position))
                startActivity(intent)
            }
        }
    }

}