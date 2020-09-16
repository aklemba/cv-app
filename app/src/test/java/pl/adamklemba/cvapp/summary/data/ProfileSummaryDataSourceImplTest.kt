package pl.adamklemba.cvapp.summary.data

import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import io.reactivex.rxjava3.core.Single
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import pl.adamklemba.cvapp.summary.data.model.ProfileSummary
import pl.adamklemba.cvapp.testutils.getRxLiveDataRule

class ProfileSummaryDataSourceImplTest {

    @Rule
    @JvmField
    var testSchedulerRule = getRxLiveDataRule()

    private val profileSummaryService: ProfileSummaryService= mock()

    private lateinit var dataSource: ProfileSummaryDataSource

    @Before
    fun setUp() {
        dataSource = ProfileSummaryDataSourceImpl(profileSummaryService)
    }

    @Test
    fun `Should return profile summary on calling getProfileSummary`() {
        // given
        val profileSummary = ProfileSummary("name", "introduction", "description")
        whenever(profileSummaryService.getProfileSummary()).thenReturn(Single.just(profileSummary))

        // when
        val result = dataSource.getProfileSummary().test()

        // then
        result.assertValue(profileSummary)
    }
}