package pl.adamklemba.cvapp.testutils

import androidx.lifecycle.Observer

class TestObserver<T> : Observer<T> {

    val observedValues = mutableListOf<T?>()

    var value: T? = null

    override fun onChanged(value: T?) {
        observedValues.add(value)
        this.value = value
    }
}