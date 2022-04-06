package com.example.timesheetapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainActivityViewModel :  ViewModel(){

    val liveData = MutableLiveData<String>()
}