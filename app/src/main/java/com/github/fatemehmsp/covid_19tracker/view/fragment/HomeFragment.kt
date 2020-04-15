package com.github.fatemehmsp.covid_19tracker.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.github.fatemehmsp.covid_19tracker.App
import com.github.fatemehmsp.covid_19tracker.databinding.FragmentHomeBinding
import com.github.fatemehmsp.covid_19tracker.model.CountryModel
import com.github.fatemehmsp.covid_19tracker.repository.Resource
import com.github.fatemehmsp.covid_19tracker.view.adapter.CountryListAdapter
import com.github.fatemehmsp.covid_19tracker.viewModel.HomeViewModel
import com.github.fatemehmsp.covid_19tracker.viewModel.viewModels
import javax.inject.Inject
import javax.inject.Provider


/**
 * Created by Fatemeh Movassaghpour on 4/6/2020.
 */
class HomeFragment : Fragment() {

    @Inject
    lateinit var viewModelProvider: Provider<HomeViewModel>

    private val viewModel by viewModels{ viewModelProvider }

    private var _binding: FragmentHomeBinding? = null
    private lateinit var adapter : CountryListAdapter
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

        adapter = CountryListAdapter{item -> countryClicked(item)}

        binding.mainList.layoutManager =
            LinearLayoutManager(activity!!, LinearLayoutManager.VERTICAL, false)
        binding.mainList.adapter = adapter


        viewModel.countries?.observe(viewLifecycleOwner, Observer {
                adapter.submitList(it)
        })

        viewModel.networkState?.observe(viewLifecycleOwner, Observer {
            hideProgress()
            hideProgressHorizontal()
            when(it){
                is Resource.Loading ->
                    showProgressHorizontal()
                is Resource.Error ->{
                    hideProgressHorizontal()
                    Toast.makeText(activity!!,it.message,Toast.LENGTH_SHORT).show()
                }
            }
        })

    }

    private fun countryClicked(item: CountryModel) {
        /*val nav1 = NavArgument.Builder().setDefaultValue(item).build()
        findNavController().graph.addArgument("countryDetail",nav1)*/
        val arge = HomeFragmentDirections.homeToDetail(item)
        findNavController().navigate(arge)
    }

    private fun hideProgress() {
        binding.mainProgress.visibility = View.GONE
    }

    private fun showProgressHorizontal() {
        binding.mainProgressHorizontal.visibility = View.VISIBLE
    }

    private fun hideProgressHorizontal() {
        binding.mainProgressHorizontal.visibility = View.GONE
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