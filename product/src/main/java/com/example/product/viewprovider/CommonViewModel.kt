package com.example.product.viewprovider

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CommonViewModel:ViewModel() {


    private val  mStatus = MutableLiveData<String>()
    val status:LiveData<String> = mStatus

    private val  mHasBreach = MutableLiveData<Boolean>()
    val hasBreach:LiveData<Boolean> = mHasBreach

    fun setBreach(hasBreach:Boolean){
        mHasBreach.value = hasBreach
    }

    fun setStatus(status:String){
        mStatus.value = status
    }

}