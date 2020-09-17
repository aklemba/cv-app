package pl.adamklemba.cvapp.experience.di

import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import dagger.hilt.android.scopes.ActivityRetainedScoped
import pl.adamklemba.cvapp.experience.domain.*
import pl.adamklemba.cvapp.experience.view.JobExperienceAdapter
import pl.adamklemba.cvapp.experience.data.JobExperienceDataSource
import pl.adamklemba.cvapp.experience.data.JobExperienceDataSourceImpl
import pl.adamklemba.cvapp.experience.data.JobExperienceRepositoryImpl
import pl.adamklemba.cvapp.experience.data.JobExperienceService
import pl.adamklemba.cvapp.knowledge.data.mapper.JobExperienceMapper
import pl.adamklemba.cvapp.experience.data.mapper.JobExperienceMapperImpl
import retrofit2.Retrofit

@Module
@InstallIn(ActivityRetainedComponent::class)
abstract class ExperienceFragmentModule {

    @Binds
    @ActivityRetainedScoped
    abstract fun bindGetJobExperiencesUseCase(useCaseImpl: GetJobExperiencesUseCaseImpl): GetJobExperiencesUseCase

    @Binds
    @ActivityRetainedScoped
    abstract fun bindFetchJobExperiencesUseCase(useCaseImpl: FetchJobExperiencesUseCaseImpl): FetchJobExperiencesUseCase

    @Binds
    @ActivityRetainedScoped
    abstract fun bindJobExperienceRepository(repository: JobExperienceRepositoryImpl): JobExperienceRepository

    @Binds
    @ActivityRetainedScoped
    abstract fun bindJobExperienceDataSource(dataSource: JobExperienceDataSourceImpl): JobExperienceDataSource

    @Binds
    @ActivityRetainedScoped
    abstract fun bindJobExperienceMapper(mapper: JobExperienceMapperImpl): JobExperienceMapper

    companion object {

        @Provides
        @ActivityRetainedScoped
        fun bindJobExperienceService(retrofit: Retrofit): JobExperienceService =
            retrofit.create(JobExperienceService::class.java)

        @Provides
        @ActivityRetainedScoped
        fun provideJobExperienceAdapter() = JobExperienceAdapter()
    }
}