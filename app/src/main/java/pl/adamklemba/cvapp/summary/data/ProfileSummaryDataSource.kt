package pl.adamklemba.cvapp.summary.data

import io.reactivex.rxjava3.core.Single

interface ProfileSummaryDataSource {

    fun getProfileSummary(): Single<pl.adamklemba.cvapp.summary.data.model.ProfileSummary>
}