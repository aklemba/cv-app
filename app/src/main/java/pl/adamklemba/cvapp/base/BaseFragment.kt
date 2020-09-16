package pl.adamklemba.cvapp.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.NonNull
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import dagger.hilt.android.AndroidEntryPoint
import pl.adamklemba.cvapp.BR
import pl.adamklemba.cvapp.liveData.SingleLiveEvent

abstract class BaseFragment<T : ViewDataBinding, V : ViewModel> : Fragment() {

    abstract val viewModel: V

    private lateinit var binding: T

    protected abstract fun getLayoutId(): Int

    open fun V.observeLiveData() {}

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, getLayoutId(), container, false);
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupBinding()
        viewModel.observeLiveData()
    }

    private fun setupBinding() {
        binding.setVariable(BR.viewModel, viewModel)
        binding.lifecycleOwner = viewLifecycleOwner
    }

    fun <T> LiveData<T>.observe(observer: (T) -> Unit) = observe(viewLifecycleOwner, observer)
}