package pl.adamklemba.cvapp.knowledge.domain

import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single
import pl.adamklemba.cvapp.model.KnowledgeTopic

interface KnowledgeTopicRepository {

    /**
     * Get KnowledgeTopic items stream
     */
    fun getKnowledgeTopics(): Observable<List<KnowledgeTopic>>

    /**
     * Fetch fresh KnowledgeTopic list from data source
     */
    fun fetchKnowledgeTopics(): Completable
}
