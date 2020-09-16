package pl.adamklemba.cvapp.summary.domain

import io.reactivex.rxjava3.core.Single
import pl.adamklemba.cvapp.model.ProfileSummary

interface ProfileSummaryRepository {

    /**
     * Gets profile summary
     */
    fun getProfileSummary(): Single<ProfileSummary>
}
