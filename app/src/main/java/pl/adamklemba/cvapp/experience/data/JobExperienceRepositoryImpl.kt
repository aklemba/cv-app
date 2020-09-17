package pl.adamklemba.cvapp.experience.data

import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.subjects.BehaviorSubject
import pl.adamklemba.cvapp.knowledge.data.mapper.JobExperienceMapper
import pl.adamklemba.cvapp.experience.domain.JobExperienceRepository
import pl.adamklemba.cvapp.model.JobExperience
import javax.inject.Inject

class JobExperienceRepositoryImpl @Inject constructor(
    private val JobExperienceDataSource: JobExperienceDataSource,
    private val JobExperienceMapper: JobExperienceMapper
) : JobExperienceRepository {

    private val jobExperiencesStream = BehaviorSubject.create<List<JobExperience>>()

    override fun getJobExperiences(): Observable<List<JobExperience>> =
        jobExperiencesStream.hide()

    override fun fetchJobExperiences(): Completable = JobExperienceDataSource.getJobExperiences()
        .map { list -> list.map { JobExperienceMapper.mapToDomain(it) } }
        .doOnSuccess { jobExperiencesStream.onNext(it) }
        .ignoreElement()
}