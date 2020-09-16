package pl.adamklemba.cvapp.summary.data

import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import io.reactivex.rxjava3.core.Single
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import pl.adamklemba.cvapp.model.ProfileSummary as DomainProfileSummary
import pl.adamklemba.cvapp.summary.data.mapper.ProfileSummaryMapper
import pl.adamklemba.cvapp.summary.data.model.ProfileSummary as DataProfileSummary
import pl.adamklemba.cvapp.summary.domain.ProfileSummaryRepository
import pl.adamklemba.cvapp.testutils.getRxLiveDataRule

class ProfileSummaryRepositoryImplTest {

    @Rule
    @JvmField
    var testSchedulerRule = getRxLiveDataRule()

    private val profileSummaryDataSource: ProfileSummaryDataSource = mock()

    private val mapper: ProfileSummaryMapper = mock()

    private lateinit var repository: ProfileSummaryRepository

    @Before
    fun setUp() {
        repository = ProfileSummaryRepositoryImpl(profileSummaryDataSource, mapper)
    }

    @Test
    fun `Should return mapped profile summary on calling getProfileSummary`() {
        // given
        val dataProfileSummary = DataProfileSummary("name", "introduction", "description")
        val domainProfileSummary = DomainProfileSummary("name", "introduction", "description")
        whenever(profileSummaryDataSource.getProfileSummary()).thenReturn(Single.just(dataProfileSummary))
        whenever(mapper.mapToDomain(any())).thenReturn(domainProfileSummary)

        // when
        val result = repository.getProfileSummary().test()

        // then
        result.assertValue(domainProfileSummary)
    }
}