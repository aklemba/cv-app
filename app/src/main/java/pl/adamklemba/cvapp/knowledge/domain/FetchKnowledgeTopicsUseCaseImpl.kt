package pl.adamklemba.cvapp.knowledge.domain

import javax.inject.Inject

class FetchKnowledgeTopicsUseCaseImpl @Inject constructor(
    private val KnowledgeTopicRepository: KnowledgeTopicRepository
) : FetchKnowledgeTopicsUseCase {

    override fun execute() = KnowledgeTopicRepository.fetchKnowledgeTopics()
}
