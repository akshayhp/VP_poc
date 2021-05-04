package com.example.vp_poc.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.LinearLayout
import com.example.product.viewprovider.CommonViewModel
import com.example.uikit.`interface`.C3_VIEW_PROVIDER
import com.example.uikit.`interface`.C4_VIEW_PROVIDER
import com.example.uikit.`interface`.C5_VIEW_PROVIDER
import com.example.vp_poc.MyApp
import com.example.vp_poc.R

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        val app = requireActivity().application as MyApp

        val data = hashMapOf<String,Any>()

        val commonViewModel:CommonViewModel = ViewModelProvider(this).get(CommonViewModel::class.java)
        commonViewModel.setStatus("Init")

        requireView().findViewById<CheckBox>(R.id.checkBox).setOnCheckedChangeListener { buttonView, isChecked ->
            commonViewModel.setBreach(isChecked)
        }

        app.getViewProviderById(C3_VIEW_PROVIDER).bindView(this,requireView().findViewById<LinearLayout>(R.id.c3_container), data)
        app.getViewProviderById(C4_VIEW_PROVIDER).bindView(this,requireView().findViewById<LinearLayout>(R.id.c4_container), data)
        app.getViewProviderById(C5_VIEW_PROVIDER).bindView(this,requireView().findViewById<LinearLayout>(R.id.c5_container), data)
    }

}