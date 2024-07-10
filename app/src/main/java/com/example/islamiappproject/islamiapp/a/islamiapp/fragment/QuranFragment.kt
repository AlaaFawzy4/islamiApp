package com.example.islamiappproject.islamiapp.a.islamiapp.fragment

import adapter.SuraNameIndexAdapter
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.islamiappproject.databinding.FragmentQuranBinding
import com.example.islamiappproject.islamiapp.a.islamiapp.Constant
import com.example.islamiappproject.islamiapp.a.islamiapp.SuraDetailsActivity
import com.example.islamiappproject.islamiapp.a.islamiapp.SuraNameData
import com.example.islamiappproject.islamiapp.a.islamiapp.suranamelist

class QuranFragment : Fragment() {
lateinit var binding: FragmentQuranBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=FragmentQuranBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //List<String>  --> item / object
       val suraNameList= suranamelist.mapIndexed { index, s ->
           return@mapIndexed SuraNameData(s,index+1)
       }
        val adapter=SuraNameIndexAdapter(suraNameList)
        adapter.onSuraNameClickListener=object :SuraNameIndexAdapter.OnSuraNameClickListener{
            override fun onSuraNameClick(suraName: String, index: Int) {
                super.onSuraNameClick(suraName, index)
                val intent=Intent(requireContext(), SuraDetailsActivity::class.java)
                intent.putExtra(Constant.Sura_Name,suraName)
                intent.putExtra(Constant.index,index)
                startActivity(intent)
            }
        }
        binding.recyclerview.adapter=adapter
    }

}