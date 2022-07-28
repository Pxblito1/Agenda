package com.example.agendatf

import android.database.sqlite.SQLiteDatabase
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.agendatf.databinding.FragmentDeleteBinding
import com.example.agendatf.nucleo.SQLiteHelper
import com.example.agendatf.nucleo.toast


class DeleteFragment : Fragment() {
    private var _binding: FragmentDeleteBinding?=null
    private val binding get()= _binding!!
    private lateinit var friendsDBHelper : SQLiteHelper

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDeleteBinding.inflate(inflater,container,false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        friendsDBHelper = SQLiteHelper(requireContext())

        binding.btnborrar.setOnClickListener {
            var affected = 0
            if (binding.etId.text.isNotBlank()){
                affected = friendsDBHelper.deleteData(binding.etId.text.toString())
                binding.etId.text.clear()

                toast("¡Borrado!")
            }
            toast("Datos borrados: $affected", Toast.LENGTH_LONG)
        }
    }



}