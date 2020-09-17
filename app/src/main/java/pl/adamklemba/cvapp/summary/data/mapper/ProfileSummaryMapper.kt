package pl.adamklemba.cvapp.summary.data.mapper

import pl.adamklemba.cvapp.model.ProfileSummary as DomainProfileSummary
import pl.adamklemba.cvapp.summary.data.model.ProfileSummary as DataProfileSummary

interface ProfileSummaryMapper {

    fun mapToDomain(dataProfileSummary: DataProfileSummary): DomainProfileSummary
}