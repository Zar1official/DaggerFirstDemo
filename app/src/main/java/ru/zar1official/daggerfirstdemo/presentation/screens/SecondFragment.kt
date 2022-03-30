package ru.zar1official.daggerfirstdemo.presentation.screens

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import ru.zar1official.daggerfirstdemo.databinding.FragmentSecondBinding


class SecondFragment : Fragment() {
    private val binding: FragmentSecondBinding get() = _binding!!
    private var _binding: FragmentSecondBinding? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSecondBinding.inflate(layoutInflater, container, false).apply {

        }
        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance() = SecondFragment()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}