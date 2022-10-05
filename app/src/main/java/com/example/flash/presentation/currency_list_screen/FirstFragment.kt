package com.example.flash.presentation.currency_list_screen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.flash.R
import com.example.flash.databinding.FragmentFirstBinding


/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null
    private lateinit var currencyAdaptor: CurrencyRecyclerViewAdaptor
   private lateinit var currencyListViewModel: CurrencyListViewModel

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        initRecyclerView()
        addDataSet()    
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonFirst.setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }
    }

    private fun initRecyclerView(){
        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(this.context)
            currencyAdaptor = CurrencyRecyclerViewAdaptor()
            adapter = currencyAdaptor
        }
    }

    private fun addDataSet(){
        val data = DataSource.createDataSet()
        currencyAdaptor.setList(data)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}