package pl.adamklemba.cvapp.experience.data.mapper

import pl.adamklemba.cvapp.knowledge.data.mapper.JobExperienceMapper
import javax.inject.Inject
import pl.adamklemba.cvapp.experience.data.model.JobExperience as DataJobExperience
import pl.adamklemba.cvapp.model.JobExperience as DomainJobExperience

class JobExperienceMapperImpl @Inject constructor() : JobExperienceMapper {

    override fun mapToDomain(dataJobExperience: DataJobExperience) = DomainJobExperience(
        dataJobExperience.companyName,
        dataJobExperience.role,
        dataJobExperience.employmentStart,
        dataJobExperience.employmentEnd,
        dataJobExperience.companyLogoUrl
    )
}
