package pl.adamklemba.cvapp.knowledge.di

import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import dagger.hilt.android.scopes.ActivityRetainedScoped
import pl.adamklemba.cvapp.knowledge.data.KnowledgeTopicDataSource
import pl.adamklemba.cvapp.knowledge.data.KnowledgeTopicDataSourceImpl
import pl.adamklemba.cvapp.knowledge.data.KnowledgeTopicRepositoryImpl
import pl.adamklemba.cvapp.knowledge.data.KnowledgeTopicService
import pl.adamklemba.cvapp.knowledge.data.mapper.KnowledgeTopicMapper
import pl.adamklemba.cvapp.knowledge.data.mapper.KnowledgeTopicMapperImpl
import pl.adamklemba.cvapp.knowledge.domain.*
import pl.adamklemba.cvapp.knowledge.view.KnowledgeTopicAdapter
import retrofit2.Retrofit

@Module
@InstallIn(ActivityRetainedComponent::class)
abstract class KnowledgeFragmentModule {

    @Binds
    @ActivityRetainedScoped
    abstract fun bindGetKnowledgeTopicsUseCase(useCaseImpl: GetKnowledgeTopicsUseCaseImpl): GetKnowledgeTopicsUseCase

    @Binds
    @ActivityRetainedScoped
    abstract fun bindFetchKnowledgeTopicsUseCase(useCaseImpl: FetchKnowledgeTopicsUseCaseImpl): FetchKnowledgeTopicsUseCase

    @Binds
    @ActivityRetainedScoped
    abstract fun bindKnowledgeTopicRepository(repository: KnowledgeTopicRepositoryImpl): KnowledgeTopicRepository

    @Binds
    @ActivityRetainedScoped
    abstract fun bindKnowledgeTopicDataSource(dataSource: KnowledgeTopicDataSourceImpl): KnowledgeTopicDataSource

    @Binds
    @ActivityRetainedScoped
    abstract fun bindKnowledgeTopicMapper(mapper: KnowledgeTopicMapperImpl): KnowledgeTopicMapper

    companion object {

        @Provides
        @ActivityRetainedScoped
        fun bindKnowledgeTopicService(retrofit: Retrofit): KnowledgeTopicService =
            retrofit.create(KnowledgeTopicService::class.java)

        @Provides
        @ActivityRetainedScoped
        fun provideKnowledgeTopicAdapter() = KnowledgeTopicAdapter()
    }
}