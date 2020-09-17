package pl.adamklemba.cvapp.experience.domain

import javax.inject.Inject

class GetJobExperiencesUseCaseImpl @Inject constructor(
    private val JobExperienceRepository: JobExperienceRepository
) : GetJobExperiencesUseCase {

    override fun execute() = JobExperienceRepository.getJobExperiences()
}
