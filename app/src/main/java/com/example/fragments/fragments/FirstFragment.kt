package com.example.fragments.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.fragments.R
import com.example.fragments.databinding.FragmentFirstBinding


class FirstFragment : Fragment() {

    private lateinit var binding: FragmentFirstBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFirstBinding.inflate(layoutInflater)
        binding.btnSave.setOnClickListener {
            val secondFragment = SecondFragment()
            val bundle = Bundle()
            bundle.putString("keyName", binding.name.text.toString().trim())
            bundle.putInt("keyAge", binding.number.text.toString().toInt())
            secondFragment.arguments = bundle
            parentFragmentManager.beginTransaction()
                .addToBackStack(secondFragment.toString())
                .replace(R.id.my_container, secondFragment)
                .commit()
        }
        return binding.root
    }


}