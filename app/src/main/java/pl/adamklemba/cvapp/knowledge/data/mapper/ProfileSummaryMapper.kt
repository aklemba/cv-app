package pl.adamklemba.cvapp.knowledge.data.mapper

import pl.adamklemba.cvapp.knowledge.data.model.KnowledgeTopic as DataKnowledgeTopic
import pl.adamklemba.cvapp.model.KnowledgeTopic as DomainKnowledgeTopic

interface KnowledgeTopicMapper {

    fun mapToDomain(dataKnowledgeTopic: DataKnowledgeTopic): DomainKnowledgeTopic
}