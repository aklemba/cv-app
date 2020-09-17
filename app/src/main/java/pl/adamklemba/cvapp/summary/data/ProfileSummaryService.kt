package pl.adamklemba.cvapp.summary.data

import io.reactivex.rxjava3.core.Single
import pl.adamklemba.cvapp.summary.data.model.ProfileSummary
import retrofit2.http.GET

interface ProfileSummaryService {

    @GET("aklemba/a5a7614eb387f543c4b19dc5b310f55a/raw/summary.json")
    fun getProfileSummary(): Single<ProfileSummary>
}