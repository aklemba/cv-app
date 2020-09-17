package pl.adamklemba.cvapp.knowledge.domain

import javax.inject.Inject

class GetKnowledgeTopicsUseCaseImpl @Inject constructor(
    private val KnowledgeTopicRepository: KnowledgeTopicRepository
) : GetKnowledgeTopicsUseCase {

    override fun execute() = KnowledgeTopicRepository.getKnowledgeTopics()
}
