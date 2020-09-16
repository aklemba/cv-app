package pl.adamklemba.cvapp.summary.view

import androidx.annotation.StringRes
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import pl.adamklemba.cvapp.R
import pl.adamklemba.cvapp.liveData.SingleLiveEvent
import pl.adamklemba.cvapp.model.ProfileSummary
import pl.adamklemba.cvapp.summary.domain.GetProfileSummaryUseCase
import timber.log.Timber

class SummaryViewModel @ViewModelInject constructor(
    private val getProfileSummaryUseCase: GetProfileSummaryUseCase
) : ViewModel() {

    val name = MutableLiveData<String>()

    val introduction = MutableLiveData<String>()

    val description = MutableLiveData<String>()

    val errorMessageId = SingleLiveEvent<@StringRes Int>()

    init {
        loadProfileSummary()
    }

    private fun loadProfileSummary() {
        getProfileSummaryUseCase.execute()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { setProfileSummary(it) },
                { handleError(it) }
            )
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
}