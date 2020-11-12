package com.udacity.shoestore.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentInventoryBinding
import com.udacity.shoestore.viewmodel.ShoeListViewModel
import java.lang.StringBuilder

class InventoryFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val binding = DataBindingUtil.inflate<FragmentInventoryBinding>(inflater, R.layout.fragment_inventory, container, false)
        binding.fab.setOnClickListener {
            val action = InventoryFragmentDirections.actionInventoryFragmentToShoeDetailsFragment()
            NavHostFragment.findNavController(this).navigate(action)
        }

        val viewModel = ViewModelProvider(requireActivity()).get(ShoeListViewModel::class.java)
        viewModel.shoes.observe(viewLifecycleOwner, { list ->
            val builder = StringBuilder()
            for (shoe in list) {
                builder.append("${shoe.company} ${shoe.name} ${shoe.size}")
                builder.append("\n")
            }

            binding.inventoryText.text = builder.toString().trim()
        })

        return binding.root
    }
}