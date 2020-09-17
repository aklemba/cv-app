package pl.adamklemba.cvapp.knowledge.data.mapper

import javax.inject.Inject
import pl.adamklemba.cvapp.knowledge.data.model.KnowledgeTopic as DataKnowledgeTopic
import pl.adamklemba.cvapp.knowledge.data.model.KnowledgeTopic.KnowledgeLevel as DataKnowledgeLevel
import pl.adamklemba.cvapp.model.KnowledgeTopic as DomainKnowledgeTopic
import pl.adamklemba.cvapp.model.KnowledgeTopic.KnowledgeLevel as DomainKnowledgeLevel

class KnowledgeTopicMapperImpl @Inject constructor() : KnowledgeTopicMapper {

    override fun mapToDomain(dataKnowledgeTopic: DataKnowledgeTopic) =
        DomainKnowledgeTopic(
            dataKnowledgeTopic.name,
            mapLevel(dataKnowledgeTopic.level)
        )

    private fun mapLevel(level: DataKnowledgeLevel) = when (level) {
        DataKnowledgeLevel.BASIC -> DomainKnowledgeLevel.BASIC
        DataKnowledgeLevel.INTERMEDIATE -> DomainKnowledgeLevel.INTERMEDIATE
        DataKnowledgeLevel.ADVANCED -> DomainKnowledgeLevel.ADVANCED
    }
}
