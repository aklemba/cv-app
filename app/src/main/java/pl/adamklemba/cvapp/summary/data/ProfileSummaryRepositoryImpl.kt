package pl.adamklemba.cvapp.summary.data

import io.reactivex.rxjava3.core.Single
import pl.adamklemba.cvapp.model.ProfileSummary
import pl.adamklemba.cvapp.summary.data.mapper.ProfileSummaryMapper
import pl.adamklemba.cvapp.summary.data.mapper.ProfileSummaryMapperImpl
import pl.adamklemba.cvapp.summary.domain.ProfileSummaryRepository
import javax.inject.Inject

class ProfileSummaryRepositoryImpl @Inject constructor(
    private val profileSummaryDataSource: ProfileSummaryDataSource,
    private val profileSummaryMapper: ProfileSummaryMapper
) : ProfileSummaryRepository {

    override fun getProfileSummary(): Single<ProfileSummary> =
        profileSummaryDataSource.getProfileSummary()
            .map { profileSummaryMapper.mapToDomain(it) }
}