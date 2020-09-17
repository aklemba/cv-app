package pl.adamklemba.cvapp.experience.view

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.kotlin.addTo
import io.reactivex.rxjava3.schedulers.Schedulers
import pl.adamklemba.cvapp.base.BaseViewModel
import pl.adamklemba.cvapp.commonview.listLoader.LoadState
import pl.adamklemba.cvapp.experience.domain.FetchJobExperiencesUseCase
import pl.adamklemba.cvapp.experience.domain.GetJobExperiencesUseCase
import pl.adamklemba.cvapp.model.JobExperience
import timber.log.Timber

class ExperienceViewModel @ViewModelInject constructor(
    private val getJobExperiencesUseCase: GetJobExperiencesUseCase,
    private val fetchJobExperiencesUseCase: FetchJobExperiencesUseCase
) : BaseViewModel() {

    val jobExperiences = MutableLiveData<List<JobExperience>>()

    val loadStatus = MutableLiveData<LoadState>()

    init {
        getJobExperiences()
        fetchJobExperiences()
    }

    fun retry() {
        fetchJobExperiences()
    }

    private fun getJobExperiences() = getJobExperiencesUseCase.execute()
        .distinctUntilChanged()
        .doOnSubscribe { loadStatus.postValue(LoadState.Loading) }
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(
            {
                jobExperiences.value = it
                loadStatus.value = LoadState.Done
            },
            {
                Timber.e(it)
                loadStatus.value = LoadState.Error(it)
            }
        ).addTo(disposables)

    private fun fetchJobExperiences() = fetchJobExperiencesUseCase.execute()
        .doOnSubscribe { loadStatus.postValue(LoadState.Loading) }
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(
            { loadStatus.value = LoadState.Done },
            {
                Timber.e(it)
                loadStatus.value = LoadState.Error(it)
            }
        ).addTo(disposables)
}