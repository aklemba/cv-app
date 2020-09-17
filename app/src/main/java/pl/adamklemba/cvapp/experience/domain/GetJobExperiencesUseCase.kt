package pl.adamklemba.cvapp.experience.domain

import io.reactivex.rxjava3.core.Observable
import pl.adamklemba.cvapp.model.JobExperience

interface GetJobExperiencesUseCase {

    /**
     * Get JobExperience items stream
     */
    fun execute(): Observable<List<JobExperience>>
}
