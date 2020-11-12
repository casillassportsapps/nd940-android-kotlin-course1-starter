package com.udacity.shoestore.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentInstrucionsBinding

class InstructionsFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val binding = DataBindingUtil.inflate<FragmentInstrucionsBinding>(inflater, R.layout.fragment_instrucions, container, false)
        binding.button.setOnClickListener {
            val action = InstructionsFragmentDirections.actionInstructionsFragmentToInventoryFragment()
            NavHostFragment.findNavController(this).navigate(action)
        }
        return binding.root
    }
}