package pl.adamklemba.cvapp.experience.domain

import javax.inject.Inject

class FetchJobExperiencesUseCaseImpl @Inject constructor(
    private val JobExperienceRepository: JobExperienceRepository
) : FetchJobExperiencesUseCase {

    override fun execute() = JobExperienceRepository.fetchJobExperiences()
}
