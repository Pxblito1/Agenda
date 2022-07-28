package com.example.agendatf

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.Navigation
import com.example.agendatf.databinding.ActivityMainBinding
import com.example.agendatf.nucleo.SQLiteHelper

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var friendsDBHelper : SQLiteHelper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.BottomNavigationView.setOnItemSelectedListener{ item ->
            when (item.itemId){
                R.id.opLista -> {
                    Navigation.findNavController(binding.fragmentContainerView)
                        .navigate(R.id.listaFragment)
                    true
                }
                R.id.opNew -> {
                    Navigation.findNavController(binding.fragmentContainerView)
                        .navigate(R.id.newFragment)
                    true
                }
                R.id.opUpdate -> {
                    Navigation.findNavController(binding.fragmentContainerView)
                        .navigate(R.id.updateFragment)
                    true
                }
                R.id.opDelete -> {
                    Navigation.findNavController(binding.fragmentContainerView)
                        .navigate(R.id.deleteFragment)
                    true
                }
                else -> false
            }

        }

    }
}
