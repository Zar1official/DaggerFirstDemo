package ru.zar1official.daggerfirstdemo.presentation.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ru.zar1official.daggerfirstdemo.R
import ru.zar1official.daggerfirstdemo.databinding.FragmentSecondBinding
import ru.zar1official.daggerfirstdemo.databinding.FragmentThirdBinding
import ru.zar1official.daggerfirstdemo.di.data.qualifiers.ThirdLoggerQualifier
import java.util.logging.Logger
import javax.inject.Inject
import javax.inject.Qualifier

class ThirdFragment : Fragment() {

    private val binding: FragmentThirdBinding get() = _binding!!
    private var _binding: FragmentThirdBinding? = null
    @Inject @field:ThirdLoggerQualifier lateinit var thirdLogger: Logger

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