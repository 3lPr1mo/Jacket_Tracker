package com.example.jacket_tracker.ui.view.statistics

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.jacket_tracker.R
import com.example.jacket_tracker.databinding.FragmentInventoryHistoryBinding
import com.example.jacket_tracker.databinding.FragmentStatisticsViewBinding
import com.example.jacket_tracker.ui.model.ConsolidateProvider
import com.example.jacket_tracker.ui.view.inventory.InventoryItem

class Statistics_view : Fragment() {
    private var _binding: FragmentStatisticsViewBinding? = null
    private val binding get() = _binding!!
    private val model: ConsolidateProvider = ConsolidateProvider()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentStatisticsViewBinding.inflate(inflater, container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        model.getConsolidate().observe(viewLifecycleOwner){
            for (consolidate in it){
                val fragment = Statistics_Item.newInstance(consolidate.categoryname,consolidate.totalprice,consolidate.totalquantity)
                childFragmentManager.beginTransaction().add(binding.container.id, fragment).commit()
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