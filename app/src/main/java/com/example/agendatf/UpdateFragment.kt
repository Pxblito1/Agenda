package com.example.agendatf

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.agendatf.databinding.FragmentUpdateBinding
import com.example.agendatf.nucleo.SQLiteHelper
import com.example.agendatf.nucleo.toast


class UpdateFragment : Fragment(){
    private var _binding: FragmentUpdateBinding?=null
    private val binding get()= _binding!!
    private lateinit var friendsDBHelper : SQLiteHelper

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentUpdateBinding.inflate(inflater,container,false)
        return binding.root}

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        friendsDBHelper = SQLiteHelper(this.requireContext())


        binding.btnactualizar.setOnClickListener {
            if (binding.etNombreu.text.isNotBlank() &&
                binding.etApellidosu.text.isNotBlank() &&
                binding.etTelefonou.text.isNotBlank() &&
                binding.etEmailu.text.isNotBlank()){
                friendsDBHelper.updateData(
                    binding.etIdu.text.toString(),
                    binding.etNombreu.text.toString(),
                    binding.etApellidosu.text.toString(),
                    binding.etTelefonou.text.toString(),
                    binding.etEmailu.text.toString()
                )
                binding.etNombreu.text.clear();
                binding.etApellidosu.text.clear();
                binding.etTelefonou.text.clear();
                binding.etEmailu.text.clear()
                toast("¡Modificado!")

            } else {
                toast("No permitido campos vacíos", Toast.LENGTH_LONG)
            }
        }
    }
}

