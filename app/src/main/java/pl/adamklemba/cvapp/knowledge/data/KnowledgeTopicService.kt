package pl.adamklemba.cvapp.knowledge.data

import io.reactivex.rxjava3.core.Single
import pl.adamklemba.cvapp.knowledge.data.model.KnowledgeTopic
import retrofit2.http.GET

interface KnowledgeTopicService {

    @GET("aklemba/9b4ceb6a5393cfb04f29ab62b7c694d5/raw/knowledgeTopics.json")
    fun getKnowledgeTopics(): Single<List<KnowledgeTopic>>
}