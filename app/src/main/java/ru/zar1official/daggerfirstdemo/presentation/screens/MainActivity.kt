package ru.zar1official.daggerfirstdemo.presentation.screens

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import androidx.lifecycle.ViewModelProvider
import ru.zar1official.daggerfirstdemo.R
import ru.zar1official.daggerfirstdemo.databinding.ActivityMainBinding
import ru.zar1official.daggerfirstdemo.presentation.viewmodels.MainViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater).apply {
            changeFragmentButton.setOnClickListener {
                viewModel.onChangeFragment()
            }
        }

        changeScreen(fragment = FirstFragment.newInstance())

        viewModel.currentFragment.observe(this@MainActivity) { fragment ->
            changeScreen(fragment)
        }
        setContentView(binding.root)
    }

    fun changeScreen(fragment: Fragment) {
        supportFragmentManager.commit {
            replace(R.id.fragment_container, fragment)
        }
    }

}