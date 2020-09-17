package pl.adamklemba.cvapp.knowledge.data

import io.reactivex.rxjava3.core.Single
import pl.adamklemba.cvapp.knowledge.data.model.KnowledgeTopic

interface KnowledgeTopicDataSource {

    fun getKnowledgeTopics(): Single<List<KnowledgeTopic>>
}