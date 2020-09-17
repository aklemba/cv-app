package pl.adamklemba.cvapp.knowledge.data

import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.subjects.BehaviorSubject
import pl.adamklemba.cvapp.knowledge.data.mapper.KnowledgeTopicMapper
import pl.adamklemba.cvapp.knowledge.domain.KnowledgeTopicRepository
import pl.adamklemba.cvapp.model.KnowledgeTopic
import javax.inject.Inject

class KnowledgeTopicRepositoryImpl @Inject constructor(
    private val knowledgeTopicDataSource: KnowledgeTopicDataSource,
    private val knowledgeTopicMapper: KnowledgeTopicMapper
) : KnowledgeTopicRepository {

    private val knowledgeTopicsStream = BehaviorSubject.create<List<KnowledgeTopic>>()

    override fun getKnowledgeTopics(): Observable<List<KnowledgeTopic>> =
        knowledgeTopicsStream.hide()

    override fun fetchKnowledgeTopics(): Completable = knowledgeTopicDataSource.getKnowledgeTopics()
        .map { list -> list.map { knowledgeTopicMapper.mapToDomain(it) } }
        .doOnSuccess { knowledgeTopicsStream.onNext(it) }
        .ignoreElement()
}