package pl.adamklemba.cvapp.experience.data

import io.reactivex.rxjava3.core.Single
import pl.adamklemba.cvapp.experience.data.model.JobExperience
import javax.inject.Inject

class JobExperienceDataSourceImpl @Inject constructor(
    private val JobExperienceService: JobExperienceService
) : JobExperienceDataSource {

    override fun getJobExperiences(): Single<List<JobExperience>> =
        JobExperienceService.getJobExperiences()
}