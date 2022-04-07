package ru.zar1official.daggerfirstdemo.presentation.screens

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import ru.zar1official.daggerfirstdemo.data.logger.Logger
import ru.zar1official.daggerfirstdemo.data.saver.LocalSaver
import ru.zar1official.daggerfirstdemo.data.saver.Saver
import ru.zar1official.daggerfirstdemo.databinding.FragmentFirstBinding
import ru.zar1official.daggerfirstdemo.di.components.FirstScreenComponent
import ru.zar1official.daggerfirstdemo.di.modules.firstscreen.FirstScreenModule
import ru.zar1official.daggerfirstdemo.presentation.factories.FirstFragmentViewModelFactory
import ru.zar1official.daggerfirstdemo.presentation.viewmodels.FirstFragmentViewModel
import ru.zar1official.daggerfirstdemo.util.appComponent
import javax.inject.Inject
import javax.inject.Named

class FirstFragment : Fragment() {

    private val component: FirstScreenComponent by lazy {
        requireContext().appComponent.plusFirstScreenComponent(
            FirstScreenModule()
        )
    }
    private val binding: FragmentFirstBinding get() = _binding!!
    private var _binding: FragmentFirstBinding? = null
    private val save
        get() = binding.saveField.text.toString()
    private val saveLocally
        get() = binding.saveLocallyField.text.toString()

    @Inject
    @field:Named("first_logger")
    lateinit var firstLogger: Logger

    @Inject
    lateinit var viewModelFactory: FirstFragmentViewModelFactory

    @Inject
    lateinit var localSaver: LocalSaver

    @Inject
    lateinit var saver: Saver

    private val viewModel: FirstFragmentViewModel by viewModels { viewModelFactory }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        component.inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFirstBinding.inflate(layoutInflater, container, false).apply {
            saveButton.setOnClickListener {
                saver.save(data = save)
            }

            saveLocallyButton.setOnClickListener {
                localSaver.saveLocally(data = saveLocally)
            }
        }
        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance() = FirstFragment()
    }
}