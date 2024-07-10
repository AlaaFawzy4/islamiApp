package com.example.islamiappproject.islamiapp.a.islamiapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.islamiappproject.R
import com.example.islamiappproject.databinding.ActivityHomeBinding
import com.example.islamiappproject.islamiapp.a.islamiapp.fragment.HadethFragment
import com.example.islamiappproject.islamiapp.a.islamiapp.fragment.QuranFragment
import com.example.islamiappproject.islamiapp.a.islamiapp.fragment.RadioFragment
import com.example.islamiappproject.islamiapp.a.islamiapp.fragment.TasbehFragment

class HomeActivity : AppCompatActivity() {
    lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.bottomNavBar.setOnItemSelectedListener {
            when(it.itemId){
                R.id.navigation_quran ->{
                pushFragment(QuranFragment())
                }
                R.id.navigation_ahadeth ->{
                 pushFragment(HadethFragment())
                }
                R.id.navigation_tsabeh ->{
                 pushFragment(TasbehFragment())
                }
                R.id.navigation_radio ->{
                 pushFragment(RadioFragment())
                }
            }
          return@setOnItemSelectedListener true
        }
           binding.bottomNavBar.selectedItemId=R.id.navigation_quran

    }
    private fun pushFragment(fragment:Fragment){
          supportFragmentManager.beginTransaction()
              .replace(binding.islamiFragmentContainer.id,fragment)
              .commit()
    }
}