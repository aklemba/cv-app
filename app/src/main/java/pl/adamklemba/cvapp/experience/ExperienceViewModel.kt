package pl.adamklemba.cvapp.experience

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ExperienceViewModel @ViewModelInject constructor() : ViewModel() {

    val title = MutableLiveData("cc")
}