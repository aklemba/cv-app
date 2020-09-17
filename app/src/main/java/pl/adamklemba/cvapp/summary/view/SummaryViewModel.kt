package pl.adamklemba.cvapp.summary.view

import androidx.annotation.StringRes
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.kotlin.addTo
import io.reactivex.rxjava3.schedulers.Schedulers
import pl.adamklemba.cvapp.R
import pl.adamklemba.cvapp.base.BaseViewModel
import pl.adamklemba.cvapp.liveData.SingleLiveEvent
import pl.adamklemba.cvapp.model.ProfileSummary
import pl.adamklemba.cvapp.summary.domain.GetProfileSummaryUseCase
import timber.log.Timber

class SummaryViewModel @ViewModelInject constructor(
    private val getProfileSummaryUseCase: GetProfileSummaryUseCase
) : BaseViewModel() {

    val name = MutableLiveData<String>()

    val introduction = MutableLiveData<String>()

    val description = MutableLiveData<String>()

    val errorMessageId = SingleLiveEvent<@StringRes Int>()

    val loaderEnabled = MutableLiveData(false)

    init {
        loadProfileSummary()
    }

    private fun loadProfileSummary() {
        getProfileSummaryUseCase.execute()
            .doOnSubscribe { loaderEnabled.postValue(true) }
            .doFinally { loaderEnabled.postValue(false) }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { setProfileSummary(it) },
                { handleError(it) }
            ).addTo(disposables)
    }

    private fun setProfileSummary(profileSummary: ProfileSummary) {
        name.value = profileSummary.name
        introduction.value = profileSummary.introduction
        description.value = profileSummary.description
    }

    private fun handleError(error: Throwable) {
        Timber.e(error)
        this.errorMessageId.value = R.string.error
    }

    companion object {
        const val LOADING_DELAY_SEC = 1L
    }
}