package pl.adamklemba.cvapp.summary

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SummaryViewModel @ViewModelInject constructor() : ViewModel() {

    val title = MutableLiveData("aa")
}