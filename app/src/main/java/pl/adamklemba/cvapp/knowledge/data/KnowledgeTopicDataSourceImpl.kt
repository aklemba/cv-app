package pl.adamklemba.cvapp.knowledge.data

import io.reactivex.rxjava3.core.Single
import pl.adamklemba.cvapp.knowledge.data.model.KnowledgeTopic
import javax.inject.Inject

class KnowledgeTopicDataSourceImpl @Inject constructor(
    private val knowledgeTopicService: KnowledgeTopicService
) : KnowledgeTopicDataSource {

    override fun getKnowledgeTopics(): Single<List<KnowledgeTopic>> =
        knowledgeTopicService.getKnowledgeTopics()
}