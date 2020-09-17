package pl.adamklemba.cvapp.knowledge.view

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.kotlin.addTo
import io.reactivex.rxjava3.schedulers.Schedulers
import pl.adamklemba.cvapp.base.BaseViewModel
import pl.adamklemba.cvapp.commonview.listLoader.LoadState
import pl.adamklemba.cvapp.knowledge.domain.FetchKnowledgeTopicsUseCase
import pl.adamklemba.cvapp.knowledge.domain.GetKnowledgeTopicsUseCase
import pl.adamklemba.cvapp.model.KnowledgeTopic
import pl.adamklemba.cvapp.summary.view.SummaryViewModel
import timber.log.Timber
import java.util.concurrent.TimeUnit

class KnowledgeViewModel @ViewModelInject constructor(
    private val getKnowledgeTopicsUseCase: GetKnowledgeTopicsUseCase,
    private val fetchKnowledgeTopicsUseCase: FetchKnowledgeTopicsUseCase
) : BaseViewModel() {

    val knowledgeTopics = MutableLiveData<List<KnowledgeTopic>>()

    val loadStatus = MutableLiveData<LoadState>()

    init {
        getKnowledgeTopics()
        fetchKnowledgeTopics()
    }

    fun retry() {
        fetchKnowledgeTopics()
    }

    private fun getKnowledgeTopics() = getKnowledgeTopicsUseCase.execute()
        .distinctUntilChanged()
        .doOnSubscribe { loadStatus.postValue(LoadState.Loading) }
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(
            {
                knowledgeTopics.value = it
                loadStatus.value = LoadState.Done
            },
            {
                Timber.e(it)
                loadStatus.value = LoadState.Error(it)
            }
        ).addTo(disposables)

    private fun fetchKnowledgeTopics() = fetchKnowledgeTopicsUseCase.execute()
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