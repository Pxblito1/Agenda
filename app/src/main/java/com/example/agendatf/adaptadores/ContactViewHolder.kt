package com.example.agendatf.adaptadores

import android.annotation.SuppressLint
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.agendatf.Contact
import com.example.agendatf.databinding.ActivityMainBinding
import com.example.agendatf.databinding.CardviewBinding

class ContactViewHolder (view: View): RecyclerView.ViewHolder(view){
    val binding = CardviewBinding.bind(view)

    fun render(contactModel: Contact){
        binding.tvId.text = contactModel.id
        binding.tvnombre.text = contactModel.name
        binding.tvapellidos.text = contactModel.last_name
        binding.tvemail.text = contactModel.mail
        binding.tvtelefono.text = contactModel.phone
    }
}
