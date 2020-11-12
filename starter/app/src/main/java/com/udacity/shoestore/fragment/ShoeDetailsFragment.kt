package com.udacity.shoestore.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.databinding.DataBindingUtil
import androidx.databinding.InverseMethod
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.MainActivity
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeDetailsBinding
import com.udacity.shoestore.viewmodel.LoginViewModel
import com.udacity.shoestore.viewmodel.ShoeListViewModel
import com.udacity.shoestore.viewmodel.ShoeViewModel

class ShoeDetailsFragment : Fragment() {

    private lateinit var viewModel: ShoeViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        viewModel = ViewModelProvider(this).get(ShoeViewModel::class.java)

        val binding = DataBindingUtil.inflate<FragmentShoeDetailsBinding>(inflater, R.layout.fragment_shoe_details, container, false)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel

        binding.cancelButton.setOnClickListener {
            NavHostFragment.findNavController(this).popBackStack(R.id.inventoryFragment, false)
        }

        binding.saveButton.setOnClickListener {
            val shoe = viewModel.shoe
            ViewModelProvider(requireActivity()).get(ShoeListViewModel::class.java).add(shoe)
            NavHostFragment.findNavController(this).popBackStack(R.id.inventoryFragment, false)
        }
        return binding.root
    }
}