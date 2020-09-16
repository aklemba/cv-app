package pl.adamklemba.cvapp.summary.data

import io.reactivex.rxjava3.core.Single
import pl.adamklemba.cvapp.summary.data.model.ProfileSummary
import javax.inject.Inject

class ProfileSummaryDataSourceImpl @Inject constructor(
    private val profileSummaryService: ProfileSummaryService
) : ProfileSummaryDataSource {

    override fun getProfileSummary(): Single<ProfileSummary> =
        profileSummaryService.getProfileSummary()
}