package com.example.jacket_tracker.ui.view.inventory

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import com.example.jacket_tracker.Repository.JacketRepository
import com.example.jacket_tracker.databinding.FragmentInventoryHistoryBinding
import com.example.jacket_tracker.network.JacketApi
import com.example.jacket_tracker.network.Resource
import com.example.jacket_tracker.ui.Base.BaseFragment
import com.example.jacket_tracker.ui.viewmodel.JacketsViewModel

class InventoryHistory : BaseFragment<JacketsViewModel, FragmentInventoryHistoryBinding, JacketRepository> () {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val listJackets = viewModel.getJac()
        Log.d("SAFAS", listJackets.toString())
        viewModel.jacketResponse.observe(viewLifecycleOwner, Observer {
            when (it) {
                is Resource.Success -> {
                    Toast.makeText(requireContext(), it.toString(), Toast.LENGTH_LONG).show()
                }
                is Resource.Failure -> {
                    Toast.makeText(requireContext(), "GET Failed", Toast.LENGTH_LONG).show()
                }
            }
        })
    }

    override fun getViewModel() = JacketsViewModel::class.java

    override fun getFragmentBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = FragmentInventoryHistoryBinding.inflate(inflater, container, false)

    override fun getFragmentRepository() = JacketRepository(remoteDataSource.buildApi(JacketApi::class.java))

}

