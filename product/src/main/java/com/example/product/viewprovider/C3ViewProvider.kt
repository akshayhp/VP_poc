package com.example.product.viewprovider

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.product.R
import com.example.uikit.`interface`.ViewProvider

class C3ViewProvider:ViewProvider {

    lateinit var viewModel:CommonViewModel
    private var view:View? = null
    override fun bindView(fragment: Fragment, parent: ViewGroup, data: HashMap<String, Any>) {

        viewModel = ViewModelProvider(fragment).get(CommonViewModel::class.java)

        view = LayoutInflater.from(parent.context).inflate(R.layout.c3_layout, parent, true)

        view?.findViewById<Button>(R.id.button)?.setOnClickListener{ v->
            viewModel.setStatus("Loaded")
        }

        viewModel.status.observe(fragment,{s->
            view?.findViewById<TextView>(R.id.textView)?.let {t->
                t.text = "C3 $s"
            }
        })

        viewModel.hasBreach.observe(fragment,{value->

            view?.let {
                it.visibility = if (value) View.GONE else View.VISIBLE
            }

        })

    }
}