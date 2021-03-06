package ru.zar1official.daggerfirstdemo.presentation.screens

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import ru.zar1official.daggerfirstdemo.app.App
import ru.zar1official.daggerfirstdemo.data.logger.Logger
import ru.zar1official.daggerfirstdemo.data.saver.LocalSaver
import ru.zar1official.daggerfirstdemo.databinding.FragmentThirdBinding
import ru.zar1official.daggerfirstdemo.di.components.ThirdScreenComponent
import ru.zar1official.daggerfirstdemo.di.modules.thirdscreen.ThirdScreenModule
import ru.zar1official.daggerfirstdemo.di.qualifiers.ThirdLoggerQualifier
import ru.zar1official.daggerfirstdemo.util.appComponent
import ru.zar1official.daggerfirstdemo.util.thirdScreenComponent
import javax.inject.Inject

class ThirdFragment : Fragment() {

    private val component: ThirdScreenComponent by lazy {
        requireContext().appComponent.plusThirdScreenComponent(
            ThirdScreenModule()
        )
    }
    private val binding: FragmentThirdBinding get() = _binding!!
    private var _binding: FragmentThirdBinding? = null

    @Inject
    @field:ThirdLoggerQualifier
    lateinit var logger: Logger

    @Inject
    lateinit var saver: LocalSaver

    override fun onAttach(context: Context) {
        super.onAttach(context)
        component.inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentThirdBinding.inflate(layoutInflater, container, false).apply {

        }
        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            ThirdFragment()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}