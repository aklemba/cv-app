package pl.adamklemba.cvapp.summary.domain

import io.reactivex.rxjava3.core.Single
import pl.adamklemba.cvapp.model.ProfileSummary

interface GetProfileSummaryUseCase {

    /**
     * Gets profile summary
     */
    fun execute(): Single<ProfileSummary>
}