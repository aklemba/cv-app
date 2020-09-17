package pl.adamklemba.cvapp.knowledge.data.mapper

import pl.adamklemba.cvapp.model.KnowledgeTopic as DomainKnowledgeTopic
import pl.adamklemba.cvapp.knowledge.data.model.KnowledgeTopic as DataKnowledgeTopic

interface KnowledgeTopicMapper {

    fun mapToDomain(dataKnowledgeTopic: DataKnowledgeTopic): DomainKnowledgeTopic
}