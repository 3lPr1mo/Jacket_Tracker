package com.example.jacket_tracker.ui.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.jacket_tracker.R
import com.example.jacket_tracker.databinding.FragmentNewTypeAddMenuBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_NEWTYADD1 = "param1"
private const val ARG_NEWTYADD2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [NewType_Add_Menu.newInstance] factory method to
 * create an instance of this fragment.
 */
class NewType_Add_Menu : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private var _binding: FragmentNewTypeAddMenuBinding? = null
    private val binding get() = _binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_NEWTYADD1)
            param2 = it.getString(ARG_NEWTYADD2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding?.apply {
            NewTypeDateEt.setOnClickListener{
                // create new instance of DatePickerFragment
                val datePickerFragment = DatePickerFragment()
                val supportFragmentManager = requireActivity().supportFragmentManager

                supportFragmentManager.setFragmentResultListener(
                    "REQUEST_KEY",
                    viewLifecycleOwner
                ){
                        resultKey, bundle -> if(resultKey == "REQUEST_KEY"){
                    val date = bundle.getString("SELECTED_DATE")
                    NewTypeDateEt.setText(date)
                }
                }
                //show the date picker
                datePickerFragment.show(supportFragmentManager,"DataPickerFragment")
            }
        }

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_new_type__add__menu, container, false)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment NewType_Add_Menu.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            NewType_Add_Menu().apply {
                arguments = Bundle().apply {
                    putString(ARG_NEWTYADD1, param1)
                    putString(ARG_NEWTYADD2, param2)
                }
            }
    }
}