package pl.adamklemba.cvapp.knowledge.domain

import io.reactivex.rxjava3.core.Observable
import pl.adamklemba.cvapp.model.KnowledgeTopic

interface GetKnowledgeTopicsUseCase {

    /**
     * Get KnowledgeTopic items stream
     */
    fun execute(): Observable<List<KnowledgeTopic>>
}
