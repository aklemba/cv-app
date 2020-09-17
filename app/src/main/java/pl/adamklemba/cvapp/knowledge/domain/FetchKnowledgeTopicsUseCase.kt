package pl.adamklemba.cvapp.knowledge.domain

import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Observable
import pl.adamklemba.cvapp.model.KnowledgeTopic

interface FetchKnowledgeTopicsUseCase {

    /**
     * Fetch fresh KnowledgeTopic list from data source
     */
    fun execute(): Completable
}
