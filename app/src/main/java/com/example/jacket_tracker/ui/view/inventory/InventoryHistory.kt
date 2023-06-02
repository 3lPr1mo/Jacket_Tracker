package com.example.jacket_tracker.ui.view.inventory


import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.jacket_tracker.R
import com.example.jacket_tracker.databinding.FragmentInventoryHistoryBinding
import com.example.jacket_tracker.ui.model.jacketProvider
import com.example.jacket_tracker.ui.view.statistics.Statistics_view
import java.text.SimpleDateFormat


class InventoryHistory :Fragment () {
    private var _binding: FragmentInventoryHistoryBinding? = null
    private val binding get() = _binding!!
    private val model: jacketProvider = jacketProvider()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentInventoryHistoryBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.searchButton.setOnClickListener {
            filter(binding.fecha.text.toString())
        }

        model.getJackets().observe(viewLifecycleOwner){
            for (jacket in it){
                val fragment = InventoryItem.newInstance(jacket.type,jacket.quantityDeliveried,jacket.price,jacket.deliveryDate)
                childFragmentManager.beginTransaction().add(binding.addFragment.id, fragment).commit()
            }
        }

    }

    private fun filter(fecha: String) {
        val fragmentos = childFragmentManager.fragments
        for (fragmento in fragmentos) {
            if (fragmento is InventoryItem) {
                val transaction = childFragmentManager.beginTransaction()
                val fechaFragmento = fragmento.paramDate?.substring(0, fecha.length)
                if (fechaFragmento == fecha) {
                    transaction.show(fragmento)
                } else {
                    transaction.hide(fragmento)
                }
                transaction.commit()
            }
        }
    }
    companion object {
        fun newInstance(param1: String, param2: String) =
            Statistics_view().apply {
                arguments = Bundle().apply {
                }
            }
    }
}

