package com.example.mvvm.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.mvvm.R
import com.example.mvvm.databinding.FragmentFirstBinding
import com.example.mvvm.viewmodel.FirstViewModel

class FirstFragment : Fragment() {
    private lateinit var binding : FragmentFirstBinding
    private lateinit var viewModel : FirstViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_first,container,false)

        viewModel = ViewModelProvider(this).get(FirstViewModel::class.java)

        binding.firstViewModel = viewModel
        binding.lifecycleOwner = this

        binding.button.setOnClickListener {
            viewModel.increaseTheNumber(binding.textView.text.toString().toInt())
            binding.textView.text = viewModel.number.value.toString()
        }

        return binding.root
    }

}