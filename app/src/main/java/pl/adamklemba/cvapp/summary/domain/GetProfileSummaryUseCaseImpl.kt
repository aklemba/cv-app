package pl.adamklemba.cvapp.summary.domain

import javax.inject.Inject

class GetProfileSummaryUseCaseImpl @Inject constructor(
    private val profileSummaryRepository: ProfileSummaryRepository
) : GetProfileSummaryUseCase {

    override fun execute() = profileSummaryRepository.getProfileSummary()
}
