package com.example.consumingdatawithrecyclerview.overview

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.consumingdatawithrecyclerview.databinding.FragmentOverviewBinding

/**
 * A simple [Fragment] subclass.
 * Use the [OverviewFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class OverviewFragment : Fragment() {

    private val viewModel: OverviewViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        val binding = FragmentOverviewBinding.inflate(inflater)

        //binding lifecycle
        binding.lifecycleOwner = this

        //binding viewmodel
        binding.viewModel = viewModel

        return binding.root
    }


}