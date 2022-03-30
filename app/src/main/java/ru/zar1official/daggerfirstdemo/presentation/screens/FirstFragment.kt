package ru.zar1official.daggerfirstdemo.presentation.screens

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import ru.zar1official.daggerfirstdemo.databinding.FragmentFirstBinding
import ru.zar1official.daggerfirstdemo.presentation.factories.FirstFragmentViewModelFactory
import ru.zar1official.daggerfirstdemo.presentation.viewmodels.FirstFragmentViewModel
import ru.zar1official.daggerfirstdemo.util.appComponent
import javax.inject.Inject

class FirstFragment : Fragment() {

    private val binding: FragmentFirstBinding get() = _binding!!
    private var _binding: FragmentFirstBinding? = null
    private val key
        get() = binding.keyField.text.toString()
    private val value
        get() = binding.valueField.text.toString()

    @Inject
    lateinit var viewModelFactory: FirstFragmentViewModelFactory
    private val viewModel: FirstFragmentViewModel by lazy {
        ViewModelProvider(
            this,
            viewModelFactory
        )[FirstFragmentViewModel::class.java]
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        context.appComponent.inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFirstBinding.inflate(layoutInflater, container, false).apply {
            saveButton.setOnClickListener {
                viewModel.onSaveData(key, value)
            }
        }
        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance() = FirstFragment()
    }
}