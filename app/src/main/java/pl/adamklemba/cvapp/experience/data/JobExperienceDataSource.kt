package pl.adamklemba.cvapp.experience.data

import io.reactivex.rxjava3.core.Single
import pl.adamklemba.cvapp.experience.data.model.JobExperience

interface JobExperienceDataSource {

    fun getJobExperiences(): Single<List<JobExperience>>
}