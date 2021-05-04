package com.example.uikit.`interface`

import android.view.ViewGroup
import androidx.fragment.app.Fragment

interface ViewProvider {
    fun bindView(fragment:Fragment, parent:ViewGroup, data:HashMap<String, Any>)
}