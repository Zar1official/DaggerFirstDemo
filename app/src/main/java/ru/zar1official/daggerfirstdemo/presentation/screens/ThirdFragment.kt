package ru.zar1official.daggerfirstdemo.presentation.screens

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import ru.zar1official.daggerfirstdemo.app.App
import ru.zar1official.daggerfirstdemo.data.A
import ru.zar1official.daggerfirstdemo.data.B
import ru.zar1official.daggerfirstdemo.databinding.FragmentThirdBinding
import ru.zar1official.daggerfirstdemo.util.thirdScreenComponent
import javax.inject.Inject

class ThirdFragment : Fragment() {

    private val binding: FragmentThirdBinding get() = _binding!!
    private var _binding: FragmentThirdBinding? = null
    @Inject
    lateinit var a: A
    @Inject
    lateinit var b: B

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (context.applicationContext as App).initThirdScreenComponent()
        context.thirdScreenComponent?.inject(this)
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