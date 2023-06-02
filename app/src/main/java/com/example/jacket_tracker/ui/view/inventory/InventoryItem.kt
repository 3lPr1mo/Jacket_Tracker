package com.example.jacket_tracker.ui.view.inventory

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.jacket_tracker.databinding.FragmentInventoryItemBinding

/**
 * A simple [Fragment] subclass.
 * Use the [InventoryItem.newInstance] factory method to
 * create an instance of this fragment.
 */
private const val ARG_PARAM_INVENTORY_ITEM_1 = "param1"
private const val ARG_PARAM_INVENTORY_ITEM_2 = "param2"
private const val ARG_PARAM_INVENTORY_ITEM_3 = "param3"
private const val ARG_PARAM_INVENTORY_ITEM_4 = "param4"

class InventoryItem : Fragment() {
    // TODO: Rename and change types of parameters
    private var paraType: String? = null
    private var paraQuality: String? = null
    private var paramCost: String? = null
    var paramDate: String? = null

    private var _binding: FragmentInventoryItemBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            paraType = it.getString(ARG_PARAM_INVENTORY_ITEM_1)
            paraQuality = it.getString(ARG_PARAM_INVENTORY_ITEM_2)
            paramCost = it.getString(ARG_PARAM_INVENTORY_ITEM_3)
            paramDate = it.getString(ARG_PARAM_INVENTORY_ITEM_4)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.textView6.text = paraType
        binding.textView7.text = paraQuality
        binding.textView8.text = paramCost
        binding.textView9.text = paramDate
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentInventoryItemBinding.inflate(inflater, container, false)
        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance(type: String, quality: Int, cost: Int, date: String) =
            InventoryItem().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM_INVENTORY_ITEM_1, type)
                    putString(ARG_PARAM_INVENTORY_ITEM_2, quality.toString())
                    putString(ARG_PARAM_INVENTORY_ITEM_3, cost.toString())
                    putString(ARG_PARAM_INVENTORY_ITEM_4, date)
                }
            }
    }
}