package com.example.islamiappproject.islamiapp.a.islamiapp.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.islamiappproject.R
import com.example.islamiappproject.databinding.FragmentTasbehBinding

class TasbehFragment : Fragment() {
    lateinit var binding: FragmentTasbehBinding
    var conter=0
    var currentDhikr=0
    lateinit var dhikr_list:MutableList<String>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTasbehBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onSebhaClick()
        dhikr_list=resources.getStringArray(R.array.dhikr_list).toMutableList()
       binding.dhikrBox.text=dhikr_list[currentDhikr]
    }

    private fun onSebhaClick() {
        binding.sebhaBody.setOnClickListener({
            binding.sebhaBody.rotation+=(360/80).toFloat()
            if (conter<33) {
                conter++
            }
            else{
                conter=0
                currentDhikr=if (currentDhikr<dhikr_list.size -1) ++currentDhikr else 0
                binding.dhikrBox.text=dhikr_list[currentDhikr]
            }
            binding.counter.text=conter.toString()
        })
    }
}