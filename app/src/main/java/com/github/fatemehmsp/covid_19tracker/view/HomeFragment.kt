package com.github.fatemehmsp.covid_19tracker.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.github.fatemehmsp.covid_19tracker.App
import com.github.fatemehmsp.covid_19tracker.R
import com.github.fatemehmsp.covid_19tracker.databinding.FragmentHomeBinding
import com.github.fatemehmsp.covid_19tracker.di.DaggerAppComponent
import com.github.fatemehmsp.covid_19tracker.viewModel.HomeViewModel
import com.github.fatemehmsp.covid_19tracker.viewModel.MainViewModelFactory
import javax.inject.Inject

/**
 * Created by Fatemeh Movassaghpour on 4/6/2020.
 */
class HomeFragment : Fragment() {

    @Inject
    lateinit var viewModelFactory: MainViewModelFactory
    private lateinit var viewModel: HomeViewModel
    private var _binding: FragmentHomeBinding? = null
    private val binding
        get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupDagger()
        viewModel = ViewModelProvider(activity!!, viewModelFactory).get(HomeViewModel::class.java)
        viewModel.getData()
        viewModel.countries?.observe(activity!!, Observer {
            Log.e("checksize", it.size.toString())
        })
    }

    private fun setupDagger() {
        val mainComponent = (activity!!.application as App).getApplicationComponent()
            .mainComponent().create()

        mainComponent.inject(this)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}