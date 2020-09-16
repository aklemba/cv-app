package pl.adamklemba.cvapp.summary.di

import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import dagger.hilt.android.components.FragmentComponent
import dagger.hilt.android.scopes.ActivityRetainedScoped
import dagger.hilt.android.scopes.FragmentScoped
import pl.adamklemba.cvapp.summary.data.ProfileSummaryDataSource
import pl.adamklemba.cvapp.summary.data.ProfileSummaryDataSourceImpl
import pl.adamklemba.cvapp.summary.data.ProfileSummaryRepositoryImpl
import pl.adamklemba.cvapp.summary.data.ProfileSummaryService
import pl.adamklemba.cvapp.summary.data.mapper.ProfileSummaryMapper
import pl.adamklemba.cvapp.summary.data.mapper.ProfileSummaryMapperImpl
import pl.adamklemba.cvapp.summary.domain.GetProfileSummaryUseCase
import pl.adamklemba.cvapp.summary.domain.GetProfileSummaryUseCaseImpl
import pl.adamklemba.cvapp.summary.domain.ProfileSummaryRepository
import retrofit2.Retrofit

@Module
@InstallIn(ActivityRetainedComponent::class)
abstract class SummaryFragmentModule {

    @Binds
    @ActivityRetainedScoped
    abstract fun bindGetProfileSummaryUseCase(useCaseImpl: GetProfileSummaryUseCaseImpl): GetProfileSummaryUseCase

    @Binds
    @ActivityRetainedScoped
    abstract fun bindProfileSummaryRepository(repository: ProfileSummaryRepositoryImpl): ProfileSummaryRepository

    @Binds
    @ActivityRetainedScoped
    abstract fun bindProfileSummaryDataSource(dataSource: ProfileSummaryDataSourceImpl): ProfileSummaryDataSource

    @Binds
    @ActivityRetainedScoped
    abstract fun bindProfileSummaryMapper(mapper: ProfileSummaryMapperImpl): ProfileSummaryMapper

    companion object {

        @Provides
        @ActivityRetainedScoped
        fun bindProfileSummaryService(retrofit: Retrofit): ProfileSummaryService =
            retrofit.create(ProfileSummaryService::class.java)
    }
}