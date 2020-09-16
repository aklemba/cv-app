package pl.adamklemba.cvapp.summary.data.mapper

import javax.inject.Inject
import pl.adamklemba.cvapp.model.ProfileSummary as DomainProfileSummary
import pl.adamklemba.cvapp.summary.data.model.ProfileSummary as DataProfileSummary

class ProfileSummaryMapperImpl @Inject constructor() : ProfileSummaryMapper {

    override fun mapToDomain(dataProfileSummary: DataProfileSummary) =
        DomainProfileSummary(
            dataProfileSummary.name,
            dataProfileSummary.introduction,
            dataProfileSummary.description
        )
}
