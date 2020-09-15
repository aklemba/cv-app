package pl.adamklemba.cvapp.knowledge

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class KnowledgeViewModel @ViewModelInject constructor() : ViewModel() {

    val title = MutableLiveData("bb")
}