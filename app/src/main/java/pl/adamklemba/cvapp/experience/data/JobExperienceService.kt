package pl.adamklemba.cvapp.experience.data

import io.reactivex.rxjava3.core.Single
import pl.adamklemba.cvapp.experience.data.model.JobExperience
import retrofit2.http.GET

interface JobExperienceService {

    @GET("aklemba/2d5a5233b945ac297e53495a37762049/raw/jobExperiences.json")
    fun getJobExperiences(): Single<List<JobExperience>>
}