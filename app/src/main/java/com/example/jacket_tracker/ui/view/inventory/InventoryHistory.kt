package com.example.jacket_tracker.ui.view.inventory


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.jacket_tracker.R
import com.example.jacket_tracker.databinding.FragmentInventoryHistoryBinding
import com.example.jacket_tracker.ui.model.jacketProvider
import com.example.jacket_tracker.ui.view.statistics.Statistics_view


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
            filtrarFragmentosPorFecha(binding.fecha.toString())
        }

        model.getJackets().observe(viewLifecycleOwner){
            for (jacket in it){
                val fragment = InventoryItem.newInstance(jacket.id,jacket.quantityDeliveried,jacket.price,jacket.deliveryDate)
                childFragmentManager.beginTransaction().add(binding.addFragment.id, fragment).commit()
            }
        }

    }

    private fun filtrarFragmentosPorFecha(fecha: String) {
        val fragmentos = childFragmentManager.fragments

        for (fragmento in fragmentos) {
            if (fragmento is InventoryItem) {
                val transaction = childFragmentManager.beginTransaction()
                var fecha = fecha + "T05:00:00.000Z"
                if (fragmento.paramDate?.contains(fecha, ignoreCase = true) == true) {
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

