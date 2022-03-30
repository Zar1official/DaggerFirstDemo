package ru.zar1official.daggerfirstdemo.presentation.screens

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import ru.zar1official.daggerfirstdemo.databinding.FragmentSecondBinding
import ru.zar1official.daggerfirstdemo.presentation.factories.SecondFragmentViewModelFactory
import ru.zar1official.daggerfirstdemo.presentation.viewmodels.SecondFragmentViewModel
import ru.zar1official.daggerfirstdemo.util.appComponent
import javax.inject.Inject

class SecondFragment : Fragment() {
    private val binding: FragmentSecondBinding get() = _binding!!
    private var _binding: FragmentSecondBinding? = null
    private val key
        get() = binding.keyField.text.toString()

    @Inject
    lateinit var viewModelFactory: SecondFragmentViewModelFactory
    private val viewModel: SecondFragmentViewModel by lazy {
        ViewModelProvider(
            this,
            viewModelFactory
        )[SecondFragmentViewModel::class.java]
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        context.appComponent.inject(this)
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSecondBinding.inflate(layoutInflater, container, false).apply {
            saveButton.setOnClickListener {
                viewModel.onReadData(key)
            }
            viewModel.data.observe(viewLifecycleOwner) {
                Toast.makeText(context, it, Toast.LENGTH_LONG).show()
            }
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