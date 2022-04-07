package ru.zar1official.daggerfirstdemo.presentation.screens

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import ru.zar1official.daggerfirstdemo.data.logger.Logger
import ru.zar1official.daggerfirstdemo.data.saver.LocalSaver
import ru.zar1official.daggerfirstdemo.data.saver.Saver
import ru.zar1official.daggerfirstdemo.databinding.FragmentSecondBinding
import ru.zar1official.daggerfirstdemo.di.components.SecondScreenComponent
import ru.zar1official.daggerfirstdemo.di.components.ThirdScreenComponent
import ru.zar1official.daggerfirstdemo.di.modules.secondscreen.SecondScreenModule
import ru.zar1official.daggerfirstdemo.di.modules.thirdscreen.ThirdScreenModule
import ru.zar1official.daggerfirstdemo.presentation.factories.SecondFragmentViewModelFactory
import ru.zar1official.daggerfirstdemo.presentation.viewmodels.SecondFragmentViewModel
import ru.zar1official.daggerfirstdemo.util.appComponent
import javax.inject.Inject
import javax.inject.Named

class SecondFragment : Fragment() {
    private val component: SecondScreenComponent by lazy {
        requireContext().appComponent.plusSecondScreenComponent(
            SecondScreenModule()
        )
    }
    private val binding: FragmentSecondBinding get() = _binding!!
    private var _binding: FragmentSecondBinding? = null

    @Inject
    @field:Named("second_logger")
    lateinit var  secondLogger: Logger

    @Inject
    lateinit var localSaver: LocalSaver

    @Inject
    lateinit var saver: Saver

    @Inject
    lateinit var viewModelFactory: SecondFragmentViewModelFactory
    private val viewModel: SecondFragmentViewModel by viewModels {viewModelFactory}

    override fun onAttach(context: Context) {
        super.onAttach(context)
        component.inject(this)
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSecondBinding.inflate(layoutInflater, container, false).apply {
            getButton.setOnClickListener{
                Toast.makeText(context, saver.read(), Toast.LENGTH_SHORT).show()
            }
            getLocallyButton.setOnClickListener{
                Toast.makeText(context, localSaver.read(), Toast.LENGTH_SHORT).show()
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