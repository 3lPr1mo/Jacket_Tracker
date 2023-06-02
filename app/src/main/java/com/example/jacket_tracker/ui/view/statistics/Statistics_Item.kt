package com.example.jacket_tracker.ui.view.statistics

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.location.LocationRequestCompat.Quality
import com.example.jacket_tracker.R
import com.example.jacket_tracker.databinding.FragmentInventoryItemBinding
import com.example.jacket_tracker.databinding.FragmentStatisticsItemBinding

private const val ARG_STAT_ITEM1 = "param1"
private const val ARG_STAT_ITEM2 = "param2"
private const val ARG_STAT_ITEM3 = "param3"

class Statistics_Item : Fragment() {
    // TODO: Rename and change types of parameters
    private var category: String? = null
    private var totalPrice: String? = null
    private var totalQuality: String? = null

    private var _binding: FragmentStatisticsItemBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            category = it.getString(ARG_STAT_ITEM1)
            totalPrice = it.getString(ARG_STAT_ITEM2)
            totalQuality= it.getString(ARG_STAT_ITEM3)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.type.text = category
        binding.price.text = totalPrice
        binding.quantity.text = totalQuality
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentStatisticsItemBinding.inflate(inflater, container, false)
        return binding.root
    }

    companion object {
        fun newInstance(category: String, totalQuantity: Int, totalPrice: Int) =
            Statistics_Item().apply {
                arguments = Bundle().apply {
                    putString(ARG_STAT_ITEM1, category)
                    putString(ARG_STAT_ITEM2, totalPrice.toString())
                    putString(ARG_STAT_ITEM3, totalQuantity.toString())
                }
            }
    }
}