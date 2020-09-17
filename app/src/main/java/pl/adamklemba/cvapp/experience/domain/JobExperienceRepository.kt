package pl.adamklemba.cvapp.experience.domain

import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single
import pl.adamklemba.cvapp.model.JobExperience

interface JobExperienceRepository {

    /**
     * Get JobExperience items stream
     */
    fun getJobExperiences(): Observable<List<JobExperience>>

    /**
     * Fetch fresh JobExperience list from data source
     */
    fun fetchJobExperiences(): Completable
}
