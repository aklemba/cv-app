package pl.adamklemba.cvapp.experience.domain

import io.reactivex.rxjava3.core.Completable

interface FetchJobExperiencesUseCase {

    /**
     * Fetch fresh JobExperience list from data source
     */
    fun execute(): Completable
}
