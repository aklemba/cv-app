package pl.adamklemba.cvapp.knowledge.data.mapper

import pl.adamklemba.cvapp.experience.data.model.JobExperience as DataJobExperience
import pl.adamklemba.cvapp.model.JobExperience as DomainJobExperience

interface JobExperienceMapper {

    fun mapToDomain(dataJobExperience: DataJobExperience): DomainJobExperience
}