package ru.zar1official.daggerfirstdemo.presentation.screens

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import ru.zar1official.daggerfirstdemo.R
import ru.zar1official.daggerfirstdemo.databinding.ActivityMainBinding
import ru.zar1official.daggerfirstdemo.presentation.viewmodels.MainViewModel
import ru.zar1official.daggerfirstdemo.util.appComponent

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel by lazy {
        ViewModelProvider(
            this
        )[MainViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater).apply {
            changeFragmentButton.setOnClickListener {
                viewModel.onChangeFragment()
            }
        }
        viewModel.state.observe(this@MainActivity) { state ->
            supportFragmentManager.beginTransaction().replace(
                R.id.fragment_container,
                FirstFragment.newInstance()
            ).commit()
        }
        setContentView(binding.root)
    }

}