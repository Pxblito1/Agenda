package com.example.agendatf
import android.database.sqlite.SQLiteDatabase
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.agendatf.Contact
import com.example.agendatf.adaptadores.ContactAdapter
import com.example.agendatf.databinding.FragmentLista2Binding
import com.example.agendatf.nucleo.SQLiteHelper
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class ListaFragment : Fragment() {
    private var _binding: FragmentLista2Binding?=null
    private val binding get()= _binding!!
    private lateinit var friendsDBHelper : SQLiteHelper


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentLista2Binding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        friendsDBHelper = SQLiteHelper(this.requireContext())
        val manager= LinearLayoutManager(this.context)
        val decoration=DividerItemDecoration(this.context,manager.orientation)
        binding.rccontact.layoutManager=manager
        binding.rccontact.addItemDecoration(decoration)
        binding.rccontact.adapter= ContactAdapter(sqliteToList())



    }
    fun sqliteToList(): MutableList<Contact>{

        val lista = mutableListOf<Contact>()
        val db : SQLiteDatabase = friendsDBHelper.readableDatabase
        val cursor = db.rawQuery ("SELECT * FROM ${SQLiteHelper.TABLE_NAME}", null)
        if (cursor.moveToFirst()) {
            do {
                lista.add(
                    Contact(
                        cursor.getString(0),
                        cursor.getString(1),
                        cursor.getString(2),
                        cursor.getString(3),
                        cursor.getString(4),
                    )
                )
            } while (cursor.moveToNext())
        }
        cursor.close()
        return lista
    }
}