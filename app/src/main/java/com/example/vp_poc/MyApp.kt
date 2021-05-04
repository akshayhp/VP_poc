package com.example.vp_poc

import android.app.Application
import com.example.product.viewprovider.C3ViewProvider
import com.example.product.viewprovider.C4ViewProvider
import com.example.product.viewprovider.C5ViewProvider
import com.example.uikit.`interface`.ViewProvider
import com.example.uikit.`interface`.ViewProviderApplication

class MyApp: Application(), ViewProviderApplication {
    override fun getViewProviderById(id: String): ViewProvider {
        return when(id) {
            "c3" -> C3ViewProvider()
            "c4" -> C4ViewProvider()
            "c5" -> C5ViewProvider()
            else -> throw UnsupportedOperationException("$id option not supported")
        }
    }
}